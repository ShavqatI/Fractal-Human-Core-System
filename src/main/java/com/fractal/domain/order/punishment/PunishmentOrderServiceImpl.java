package com.fractal.domain.order.punishment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employment.punishment.PunishmentService;
import com.fractal.domain.employment.punishment.dto.PunishmentApprovalWorkflowAwareRequest;
import com.fractal.domain.order.punishment.dto.PunishmentOrderRequest;
import com.fractal.domain.order.punishment.dto.PunishmentOrderResponse;
import com.fractal.domain.order.punishment.mapper.PunishmentOrderMapperService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class PunishmentOrderServiceImpl implements PunishmentOrderService {

    private final PunishmentOrderRepository orderRepository;
    private final PunishmentOrderMapperService orderMapperService;
    private final StatusService statusService;
    private final OrderStateService stateService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final PunishmentService punishmentService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final OrderUseCaseService orderUseCaseService;
    private final FileService fileService;
    private final AuthenticatedService authenticatedService;

    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;

    @Override
    @Transactional
    public PunishmentOrder create(PunishmentOrderRequest dto) {
        return save(orderMapperService.toEntity(dto));
    }

    @Override
    public List<PunishmentOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public PunishmentOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public PunishmentOrder update(Long id, PunishmentOrderRequest dto) {
        return save(orderMapperService.toEntity(getById(id),dto));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var order = getById(id);
        punishmentService.delete(order.getEmployeeEmployment().getEmployment().getId(),order.getPunishment().getId());
        orderRepository.delete(getById(id));
    }

    private PunishmentOrder save(PunishmentOrder order) {
        try {
            order = orderRepository.save(order);
            stateService.create(order);
            return order;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }



    @Override
    public PunishmentOrderResponse toDTO(PunishmentOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    public PunishmentOrder review(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            punishmentService.review(new PunishmentApprovalWorkflowAwareRequest(order.getEmployeeEmployment().getEmployment().getId(),order.getPunishment().getId()));
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public PunishmentOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            punishmentService.review(new PunishmentApprovalWorkflowAwareRequest(order.getEmployeeEmployment().getEmployment().getId(),order.getPunishment().getId()));
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }

    }
    @Override
    public Path print(Long id)  {
        var order = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath =  Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();

        Map<String, String> values = new HashMap<>();

        values.putAll(orderUseCaseService.getHeader(order));
        var employment = employeeUseCaseService.getCurrentEmployment(order.getEmployeeEmployment().getEmployee()).get();
        var punishment  = punishmentService.toDTO(order.getPunishment());
        values.put("fullBankName", employment.organization().name());
        values.put("employeeName", employeeUseCaseService.getFullName(order.getEmployeeEmployment().getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("punishmentType", punishment.punishmentType().name());

        values.putAll(orderUseCaseService.getFooter());

        try {
            wordTemplateProcessorService.process(Path.of(order.getOrderType().getDocumentTemplateManager().getFilePath()), wordFilePath, values);
            wordToPdfConverterService.convert(wordFilePath,pdfFilePath);
            fileService.delete(wordFilePath.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pdfFilePath;
    }


}

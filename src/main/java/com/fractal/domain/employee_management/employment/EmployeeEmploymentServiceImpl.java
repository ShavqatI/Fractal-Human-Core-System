package com.fractal.domain.employee_management.employment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentApprovedMapperService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentMapperService;
import com.fractal.domain.employee_management.employment.state.EmployeeEmploymentStateService;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.HireRequest;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.TransferRequest;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateRequest;
import com.fractal.domain.employee_management.subordinate.type.SubordinateTypeService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.EmploymentService;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.ExternalEmploymentService;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponentService;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.employment.internal.dto.TerminationRequest;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentServiceImpl implements EmployeeEmploymentService {

    private final EmployeeEmploymentRepository employmentRepository;
    private final EmployeeService employeeService;
    private final InternalEmploymentService internalEmploymentService;
    private final ExternalEmploymentService externalEmploymentService;
    private final EmployeeEmploymentMapperService employmentMapperService;
    private final EmployeeEmploymentApprovedMapperService employmentApprovedMapperService;
    private final AuthenticatedService authenticatedService;
    private final EmployeeEmploymentStateService stateService;
    private final StatusService statusService;
    private final EmploymentService employmentService;
    private final CompensationComponentService compensationComponentService;
    private final SubordinateService subordinateService;
    private final PositionService positionService;
    private final SubordinateTypeService subordinateTypeService;


    @Override
    @Transactional
    public EmployeeEmployment create(Long employeeId, EmploymentRequest dto) {
        Employment employment = null;
        if (dto instanceof InternalEmploymentRequest) {
            employment = internalEmploymentService.create((InternalEmploymentRequest) dto);
        } else if (dto instanceof ExternalEmploymentRequest) {
            employment = externalEmploymentService.create((ExternalEmploymentRequest) dto);
        }
        var employeeEmployment = EmployeeEmployment.builder()
                .employee(employeeService.getById(employeeId))
                .employment(employment)
                .status(statusService.getByCode("CREATED"))
                .build();
        return employmentRepository.save(employeeEmployment);
    }

    @Override
    public EmployeeEmployment getById(Long employeeId, Long id) {
        return employmentRepository.findByEmployeeIdAndEmploymentId(employeeId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public EmployeeEmployment getByCompensationComponentId(Long compensationComponentId) {
        var employment = internalEmploymentService.getByCompensationComponentId(compensationComponentId);
        return employmentRepository.findByEmploymentId(employment.getId()).orElseThrow(()-> new ResourceNotFoundException("EmployeeEmployment with employmentId" + employment.getId() + " not found"));
    }

    @Override
    public EmployeeEmployment getById(Long id) {
        return employmentRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public EmployeeEmployment getByEmploymentId(Long id) {
        return employmentRepository.findByEmploymentId(id).orElseThrow(()-> new ResourceNotFoundException("Employment with id: " + id + " not found in EmployeeEmployment"));
    }

    @Override
    public List<EmployeeEmployment> getAllByEmployeeId(Long employeeId) {
        return employmentRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeEmployment> getAllActive() {
        return employmentRepository.findAllByStatus("ACTIVE");
    }

    @Override
    public EmployeeEmployment getActiveBefore(Long employeeId,LocalDate date) {
        return employmentRepository.findActiveEmploymentBefore(employeeId,date).orElseThrow(()-> new ResourceNotFoundException("Employment for employee id: " + employeeId + " for date <= " + date + " not found"));
    }

    @Override
    public List<EmployeeEmployment> getAllApproved() {
       return employmentRepository.findAllByStatus("APPROVED")
                .stream().filter(employeeEmployment -> {
                    var employeeEmployment1 = (EmployeeEmployment) Hibernate.unproxy(employeeEmployment);
                    var employment = (Employment) Hibernate.unproxy(employeeEmployment1.getEmployment());
                    return employment instanceof InternalEmployment;
                }).collect(Collectors.toList());
    }


    @Override
    public EmployeeEmployment update(Long employeeId, Long id, EmploymentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var employeeEmployment = employee.getEmployments()
                .stream()
                .filter(eh -> eh.getEmployment().getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        if (dto instanceof InternalEmploymentRequest) {
            internalEmploymentService.update(employeeEmployment.getEmployment().getId(), (InternalEmploymentRequest) dto);
        } else if (dto instanceof ExternalEmploymentRequest) {
            externalEmploymentService.update(employeeEmployment.getEmployment().getId(), (ExternalEmploymentRequest) dto);
        }
        employmentRepository.save(employeeEmployment);
        employeeService.save(employee);
        return employeeEmployment;
    }


    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var employeeEmployment = employee.getEmployments()
                .stream()
                .filter(eh -> eh.getEmployment().getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        employee.removeEmployment(employeeEmployment);
        employeeService.save(employee);
    }

    @Override
    public EmploymentResponse toDTO(EmployeeEmployment employment) {
        return employmentMapperService.toDTO(employment);
    }

    @Override
    public InternalEmploymentApprovedResponse toApprovedDTO(EmployeeEmployment employment) {
        return employmentApprovedMapperService.toDTO(employment);
    }

    @Override
    @Transactional
    public EmployeeEmployment review(ApprovalWorkflowAwareRequest dto) {
        var employeeEmployment = getById(dto.employeeId(),dto.id());
        if (employeeEmployment.getStatus().getCode().equals("CREATED")) {
            employeeEmployment.setReviewedDate(LocalDateTime.now());
            employeeEmployment.setReviewedUser(authenticatedService.getUser());
            employeeEmployment.setStatus(statusService.getByCode("REVIEWED"));
            stateService.create(employeeEmployment);
            employmentService.review(employeeEmployment.getEmployment().getId());
            if(filterInternalEmployment(employeeEmployment)){
                var internalEmployment  = getInternalEmployment(employeeEmployment);
                 internalEmployment.getCompensationComponents().forEach(cc-> {
                         compensationComponentService.review(new com.fractal.domain.employment.internal.compensation_component.dto.ApprovalWorkflowAwareRequest(internalEmployment.getId(),cc.getId()));
                 });
            }
            return employmentRepository.save(employeeEmployment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employeeEmployment.getStatus().getName());
        }
    }

    @Override
    @Transactional
    public EmployeeEmployment approve(ApprovalWorkflowAwareRequest dto) {
        var employeeEmployment = getById(dto.employeeId(),dto.id());
        if (employeeEmployment.getStatus().getCode().equals("REVIEWED")) {
            employeeEmployment.setApprovedDate(LocalDateTime.now());
            employeeEmployment.setApprovedUser(authenticatedService.getUser());
            employeeEmployment.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(employeeEmployment);
            employmentService.approve(employeeEmployment.getEmployment().getId());
            activate(dto.employeeId(),dto.id());
            if(filterInternalEmployment(employeeEmployment)){
                var internalEmployment  = getInternalEmployment(employeeEmployment);
                internalEmployment.getCompensationComponents().forEach(cc-> {
                    compensationComponentService.approve(new com.fractal.domain.employment.internal.compensation_component.dto.ApprovalWorkflowAwareRequest(internalEmployment.getId(),cc.getId()));
                });
            }
            return employmentRepository.save(employeeEmployment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employeeEmployment.getStatus().getName());
        }
    }
    @Override
    @Transactional
    public Void cancel(EmployeeEmploymentCancelRequest dto) {
        var employeeEmployment = getActiveBefore(dto.employeeId(),getById(dto.employeeId(),dto.id()).getEmployment().getStartDate());
        employeeEmployment.setStatus(statusService.getByCode("ACTIVE"));
        activate(employeeEmployment.getEmployee().getId(),employeeEmployment.getEmployment().getId());
        delete(dto.employeeId(),dto.id());
       return null;
    }

    @Override
    @Transactional
    public EmployeeEmployment hire(Long employeeId, HireRequest dto) {
        return create(employeeId,
                new InternalEmploymentRequest(
                        dto.organizationId(),
                        dto.departmentId(),
                        dto.positionId(),
                        dto.employmentTypeId(),
                        dto.startDate(),
                        dto.endDate(),
                        List.of(),
                        List.of(),
                        List.of(),
                        dto.compensationComponents()

                )
        );
    }

    @Override
    public EmployeeEmployment terminate(Long employeeId, TerminationRequest dto) {
       var employeeEmployment = getActiveEmployment(employeeId);
       if(employeeEmployment != null) {
           employeeEmployment.setStatus(statusService.getByCode("CREATED"));
           var employment = (Employment) Hibernate.unproxy(employeeEmployment.getEmployment());
           if(employment instanceof InternalEmployment){
               internalEmploymentService.terminate(employment.getId(),dto);
           }
          return employmentRepository.save(employeeEmployment);
       }
      return null;
    }

    @Override
    public EmployeeEmployment transfer(Long employeeId, TransferRequest dto) {
        return create(employeeId,
                new InternalEmploymentRequest(
                        dto.organizationId(),
                        dto.departmentId(),
                        dto.positionId(),
                        dto.employmentTypeId(),
                        dto.startDate(),
                        dto.endDate(),
                        List.of(),
                        List.of(),
                        List.of(),
                        dto.compensationComponents()

                )
        );
    }

    @Override
    public Optional<CompensationComponent> addCompensation(Long employeeId, CompensationComponentRequest dto) {
        var employeeEmployment = getActiveEmployment(employeeId);
        var employment1 = (Employment) Hibernate.unproxy(employeeEmployment.getEmployment());
        if(employment1 instanceof InternalEmployment) {
          return Optional.of(compensationComponentService.create(employment1.getId(),dto));
        }
       return Optional.empty();
    }

    @Override
    @Transactional
    public EmployeeEmployment activate(Long employeeId,Long id) {
        var employeeEmployment = getById(employeeId,id);
        if (employeeEmployment.getStatus().getCode().equals("APPROVED")) {
            try {
                var activeEmployment = getActiveEmployment(employeeId);
                close(employeeId,activeEmployment.getEmployment().getId(),employeeEmployment.getEmployment().getStartDate());
            }
            catch (Exception e){}
            employeeEmployment.setStatus(statusService.getByCode("ACTIVE"));
            stateService.create(employeeEmployment);
            employmentService.activate(employeeEmployment.getEmployment().getId());
            addSubordinate(employeeEmployment);
            return employmentRepository.save(employeeEmployment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employeeEmployment.getStatus().getName());
        }
    }

    @Override
    @Transactional
    public EmployeeEmployment close(Long employeeId,Long id,LocalDate endDate) {
        var employeeEmployment = getById(employeeId,id);
        if (!employeeEmployment.getStatus().getCode().equals("CLOSE")) {
            employeeEmployment.setStatus(statusService.getByCode("CLOSE"));
            stateService.create(employeeEmployment);
            employmentService.close(employeeEmployment.getEmployment().getId(),endDate);
            return employmentRepository.save(employeeEmployment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employeeEmployment.getStatus().getName());
        }
    }

    @Override
    public EmployeeEmployment getActiveEmployment(Long employeeId) {
        return employmentRepository.findActiveEmployment(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employment for employee with id " + employeeId + " not found"));
    }

    @Override
    public Optional<InternalEmploymentResponse> getEmployment(EmployeeEmployment employment) {
        var  employeeEmployment = (EmployeeEmployment) Hibernate.unproxy(employment);
        var employment1 = (Employment) Hibernate.unproxy(employeeEmployment.getEmployment());
        if(employment1 instanceof InternalEmployment){
            return Optional.ofNullable(internalEmploymentService.toDTO((InternalEmployment) employment1));
        }
        return Optional.empty();
    }

    private void addSubordinate(EmployeeEmployment employeeEmployment) {
        var internalEmployment = getInternalEmployment(employeeEmployment);
        try {
            var active = subordinateService.getActiveByEmployeeId(employeeEmployment.getEmployee().getId());
            subordinateService.close(active.getId(),employeeEmployment.getEmployment().getStartDate());
        }
        catch (Exception e){}
        try {
                var supervisorPosition = positionService.getSupervisor(internalEmployment.getPosition().getId());
                if(supervisorPosition == null){
                    if(internalEmployment.getDepartment().getParent() != null){
                        supervisorPosition = positionService.getSupervisor(internalEmployment.getDepartment().getParent());
                    }
                 }
                var supervisorEmployee = getEmployeeByPosition(supervisorPosition.getCode());
                subordinateService.create(new SubordinateRequest(
                        supervisorEmployee.get().getId(),
                        employeeEmployment.getEmployee().getId(),
                        subordinateTypeService.getByCode("DIRECT").getId(),
                        statusService.getByCode("ACTIVE").getId(),
                        employeeEmployment.getEmployment().getStartDate(),
                        employeeEmployment.getEmployment().getEndDate()
                ));
            }
            catch (Exception e){}


    }

    private Optional<Employee> getEmployeeByPosition(String positionCode){
        var employee = getAllActive().stream().filter(
                        employeeEmployment -> filterInternalEmployment(employeeEmployment))
                .filter(ee -> filterPosition(getInternalEmployment(ee),positionCode)
                )
                .map(employeeEmployment -> employeeEmployment.getEmployee());
        return employee.findFirst();
    }

    private boolean filterInternalEmployment(EmployeeEmployment employeeEmployment) {
        employeeEmployment = (EmployeeEmployment) Hibernate.unproxy(employeeEmployment);
        var employment = (Employment) Hibernate.unproxy(employmentService.getById(employeeEmployment.getEmployment().getId()));
        if(employment instanceof InternalEmployment) return true;
        else return false;
    }
    private boolean filterPosition(InternalEmployment employment,String positionCode) {
        var position = positionService.getById(employment.getPosition().getId());
        return position.getCode().equals(positionCode) ? true : false;
    }

    private InternalEmployment getInternalEmployment(EmployeeEmployment employeeEmployment){
        if(filterInternalEmployment(employeeEmployment)) {
            var employment = (Employment) Hibernate.unproxy(employmentService.getById(employeeEmployment.getEmployment().getId()));
            return internalEmploymentService.getById(employment.getId());
        }
        return null;
    }



}

package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import com.fractal.domain.employee_management.employment.agreement.resource.AgreementResourceService;
import com.fractal.domain.organization_management.job_description.JobDescription;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class AgreementServiceImpl implements AgreementService {

    private final StatusService statusService;
    private final AgreementResourceService resourceService;
    private final AgreementRepository agreementRepository;

    @Override
    public AgreementResponse toDTO(Agreement agreement) {
        return new AgreementResponse(
                agreement.getId(),
                agreement.getNumber(),
                agreement.getStartDate(),
                agreement.getEndDate(),
                agreement.getStatus().getName(),
                Optional.ofNullable(agreement.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceService::toDTO)
                        .collect(Collectors.toList()),
                agreement.getCreatedDate(),
                agreement.getUpdatedDate()
        );
    }

    @Override
    public Agreement toEntity(AgreementRequest dto) {
        var agreement = Agreement.builder()
                .number(dto.number())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .status(statusService.getById(dto.statusId()))
                .build();
        dto.files().forEach(file-> agreement.addResource(resourceService.toEntity(file,null)));
      return agreement;
    }

    @Override
    public Agreement update(Long id, AgreementRequest dto) {
        try {
             Agreement agreement = findById(id);
             agreement.setNumber(dto.number());
             agreement.setStartDate(dto.startDate());
             agreement.setEndDate(dto.endDate());
             agreement.setStatus(statusService.getById(dto.statusId()));
            dto.files().forEach(file-> agreement.addResource(resourceService.toEntity(file,null)));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
        return null;
    }

    @Override
    public void delete(Agreement agreement) {
         agreementRepository.delete(agreement);
    }

    @Override
    public Agreement addResource(Long id,MultipartFile file, String url) {
        var agreement = findById(id);
        var resource =resourceService.toEntity(file,url);
        agreement.addResource(resource);
       return save(agreement);
    }

    @Override
    public Agreement deleteResource(Long id,Long resourceId) {
        var agreement = findById(id);
        var resource = resourceService.findById(resourceId);
        agreement.removeResource(resource);
        resourceService.delete(resource);
       return save(agreement);
    }

    private Agreement save(Agreement agreement) {
        try {
            return agreementRepository.save(agreement);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Agreement findById(Long id) {
        return agreementRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Agreement with id: " + id + " not found"));
    }
}

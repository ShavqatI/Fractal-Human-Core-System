package com.fractal.domain.employee_management.military_service;

import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.employee_management.military_service.resource.MilitaryServiceResourceService;
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
class MilitaryServiceServiceImpl implements MilitaryServiceService {

    private final MilitaryServiceRepository militaryServiceRepository;
    private final MilitaryServiceResourceService resourceService;

    @Override
    public MilitaryService create(MilitaryServiceRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public MilitaryServiceResponse toDTO(MilitaryService militaryService) {
        return new MilitaryServiceResponse(
                militaryService.getId(),
                militaryService.getAccountNumber(),
                militaryService.getTitle(),
                militaryService.getCategoryFund(),
                militaryService.getAddress(),
                militaryService.getBeginDate(),
                militaryService.getEndDate(),
                Optional.ofNullable(militaryService.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceService::toDTO)
                        .collect(Collectors.toList()),
                militaryService.getCreatedDate()
        );
    }

    @Override
    public MilitaryService toEntity(MilitaryServiceRequest dto) {
        var militaryService = MilitaryService.builder()
                .accountNumber(dto.accountNumber())
                .title(dto.title())
                .categoryFund(dto.categoryFund())
                .address(dto.address())
                .beginDate(dto.beginDate())
                .endDate(dto.endDate())
                .build();
         dto.files().forEach(file-> militaryService.addResource(resourceService.toEntity(file,null)));
        return militaryService;
    }

    @Override
    public MilitaryService update(Long id, MilitaryServiceRequest dto) {
        var militaryService = findById(id);
        militaryService.setAccountNumber(dto.accountNumber());
        militaryService.setTitle(dto.title());
        militaryService.setCategoryFund(dto.categoryFund());
        militaryService.setAddress(dto.address());
        militaryService.setBeginDate(dto.beginDate());
        militaryService.setEndDate(dto.endDate());
        dto.files().forEach(file-> militaryService.addResource(resourceService.toEntity(file,null)));
      return militaryService;
    }

    @Override
    public void delete(MilitaryService militaryService) {
      militaryServiceRepository.delete(militaryService);
    }

    @Override
    public MilitaryService addResource(Long id, MultipartFile file, String url) {
        var militaryService = findById(id);
        var resource =resourceService.toEntity(file,url);
        militaryService.addResource(resource);
        return save(militaryService);
    }

    @Override
    public MilitaryService updateResource(Long id, Long resourceId, MultipartFile file) {
        var militaryService = findById(id);
        var resource = militaryService.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service Resource  with id: " + resourceId + " not found"));
        resourceService.update(resource,resourceService.fileToRequest(file,null));
        return save(militaryService);
    }

    @Override
    public MilitaryService deleteResource(Long id, Long resourceId) {
        var militaryService = findById(id);
        var resource = militaryService.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service Resource  with id: " + resourceId + " not found"));
        militaryService.removeResource(resource);
        resourceService.delete(resource);
        return save(militaryService);
    }

    private MilitaryService save(MilitaryService militaryService) {
        try {
            return militaryServiceRepository.save(militaryService);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private MilitaryService findById(Long id) {
        return militaryServiceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Military service  with id: " + id + " not found"));
    }
}

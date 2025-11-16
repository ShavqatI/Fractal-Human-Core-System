package com.fractal.domain.military_service.mapper;

import com.fractal.domain.military_service.MilitaryService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.military_service.resource.mapper.MilitaryServiceResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class MilitaryServiceMapperServiceImpl implements MilitaryServiceMapperService {

    private final MilitaryServiceResourceMapperService resourceMapperService;

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
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                militaryService.getCreatedDate()
        );
    }

    @Override
    public MilitaryService toEntity(MilitaryServiceRequest dto) {
        return mapToEntity(new MilitaryService(), dto);
    }

    @Override
    public MilitaryService toEntity(MilitaryService militaryService, MilitaryServiceRequest dto) {
        return mapToEntity(militaryService, dto);
    }

    @Override
    public MilitaryService copy(MilitaryService militaryService) {
        var copy = MilitaryService.builder().build();
        copy.setAccountNumber(militaryService.getAccountNumber());
        copy.setTitle(militaryService.getTitle());
        copy.setCategoryFund(militaryService.getCategoryFund());
        copy.setAddress(militaryService.getAddress());
        copy.setBeginDate(militaryService.getBeginDate());
        copy.setEndDate(militaryService.getEndDate());
        var resourceCopy = militaryService.getResources().stream().map(resourceMapperService::copy).collect(Collectors.toCollection(ArrayList::new));
        copy.setResources(resourceCopy);
        return copy;
    }

    private MilitaryService mapToEntity(MilitaryService militaryService, MilitaryServiceRequest dto) {
        militaryService.setAccountNumber(dto.accountNumber());
        militaryService.setTitle(dto.title());
        militaryService.setCategoryFund(dto.categoryFund());
        militaryService.setAddress(dto.address());
        militaryService.setBeginDate(dto.beginDate());
        militaryService.setEndDate(dto.endDate());
        dto.files().forEach(file -> militaryService.addResource(resourceMapperService.toEntity(file, null)));
        return militaryService;
    }

}

package com.fractal.domain.recruitment.candidate.military_service.mapper;

import com.fractal.domain.military_service.MilitaryService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.military_service.mapper.MilitaryServiceMapperService;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateMilitaryServiceMapperServiceImpl implements CandidateMilitaryServiceMapperService {

    private final MilitaryServiceMapperService mapperService;

    @Override
    public MilitaryServiceResponse toDTO(CandidateMilitaryService militaryService) {
        return mapperService.toDTO(militaryService);
    }

    @Override
    public CandidateMilitaryService toEntity(MilitaryServiceRequest dto) {
        return convert(new CandidateMilitaryService(), mapperService.toEntity(dto));
    }

    @Override
    public CandidateMilitaryService toEntity(CandidateMilitaryService militaryService, MilitaryServiceRequest dto) {
        return convert(militaryService, mapperService.toEntity(militaryService, dto));
    }

    private CandidateMilitaryService convert(CandidateMilitaryService candidateMilitaryService, MilitaryService militaryService) {
        candidateMilitaryService.setAccountNumber(militaryService.getAccountNumber());
        candidateMilitaryService.setTitle(militaryService.getTitle());
        candidateMilitaryService.setCategoryFund(militaryService.getCategoryFund());
        candidateMilitaryService.setAddress(militaryService.getAddress());
        candidateMilitaryService.setBeginDate(militaryService.getBeginDate());
        candidateMilitaryService.setEndDate(militaryService.getEndDate());
        candidateMilitaryService.setResources(militaryService.getResources());
        return candidateMilitaryService;
    }


}

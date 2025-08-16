package com.fractal.domain.recruitment.candidate.citizenship.mapper;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.citizenship.mapper.CitizenshipMapperService;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateCitizenshipMapperServiceImpl implements CandidateCitizenshipMapperService {

    private final CitizenshipMapperService citizenshipMapperService;
    @Override
    public CitizenshipResponse toDTO(CandidateCitizenship citizenship) {
        return citizenshipMapperService.toDTO(citizenship);
    }

    @Override
    public CandidateCitizenship toEntity(CitizenshipRequest dto) {
        return (CandidateCitizenship) citizenshipMapperService.toEntity(dto);
    }

    @Override
    public CandidateCitizenship toEntity(CandidateCitizenship citizenship, CitizenshipRequest dto) {
        return (CandidateCitizenship) citizenshipMapperService.toEntity(citizenship,dto);
    }

}

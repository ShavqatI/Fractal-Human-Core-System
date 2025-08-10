package com.fractal.domain.recruitment.candidate.citizenship.mapper;

import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipRequest;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateCitizenshipMapperServiceImpl implements CandidateCitizenshipMapperService {

    private final CountryService countryService;

    @Override
    public CandidateCitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship) {
        return new CandidateCitizenshipResponse(candidateCitizenship.getCountry().getName());
    }

    @Override
    public CandidateCitizenship toEntity(CandidateCitizenshipRequest dto) {
        return mapToEntity(new CandidateCitizenship(),dto);
    }

    @Override
    public CandidateCitizenship toEntity(CandidateCitizenship candidateCitizenship, CandidateCitizenshipRequest dto) {
        return mapToEntity(candidateCitizenship,dto);
    }

    private CandidateCitizenship mapToEntity(CandidateCitizenship candidateCitizenship, CandidateCitizenshipRequest dto) {
        candidateCitizenship.setCountry(countryService.getById(dto.countryId()));
        return candidateCitizenship;
    }
}

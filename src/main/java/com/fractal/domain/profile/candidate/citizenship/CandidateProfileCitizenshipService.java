package com.fractal.domain.profile.candidate.citizenship;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;

import java.util.List;

public interface CandidateProfileCitizenshipService {
    CandidateCitizenship create(CitizenshipRequest dto);

    List<CandidateCitizenship> getAll();

    CandidateCitizenship getById(Long id);

    CandidateCitizenship update(Long id, CitizenshipRequest dto);

    void delete(Long id);

    CitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship);


}

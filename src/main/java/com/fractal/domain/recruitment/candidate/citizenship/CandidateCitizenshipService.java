package com.fractal.domain.recruitment.candidate.citizenship;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;

import java.util.List;

public interface CandidateCitizenshipService {

    CandidateCitizenship create(Long candidateId, CitizenshipRequest dto);

    List<CandidateCitizenship> getAllByCandidateId(Long candidateId);

    CandidateCitizenship getById(Long candidateId, Long id);

    CandidateCitizenship update(Long candidateId, Long id, CitizenshipRequest dto);

    void delete(Long candidateId, Long id);

    CitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship);

}

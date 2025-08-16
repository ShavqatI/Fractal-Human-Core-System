package com.fractal.domain.recruitment.candidate.citizenship;

import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipRequest;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipResponse;

import java.util.List;

public interface CandidateCitizenshipService {

    CandidateCitizenship create(Long candidateId, CandidateCitizenshipRequest dto);
    List<CandidateCitizenship> getAllByCandidateId(Long candidateId);
    CandidateCitizenship getById(Long candidateId , Long id);
    CandidateCitizenship update(Long candidateId, Long id, CandidateCitizenshipRequest dto);
    void delete(Long candidateId,Long id);
    CandidateCitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship);

}

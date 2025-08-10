package com.fractal.domain.recruitment.candidate.citizenship;

import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipRequest;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipResponse;

import java.util.List;

public interface CandidateCitizenshipService {

    CandidateCitizenship create(Long employeeId, CandidateCitizenshipRequest dto);
    List<CandidateCitizenship> getAllByEmployeeId(Long employeeId);
    CandidateCitizenship getById(Long employeeId , Long id);
    CandidateCitizenship update(Long employeeId, Long id, CandidateCitizenshipRequest dto);
    void delete(Long employeeId,Long id);
    CandidateCitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship);

}

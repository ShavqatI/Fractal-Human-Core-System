package com.fractal.domain.recruitment.candidate.citizenship;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipRequest;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipResponse;
import com.fractal.domain.recruitment.candidate.citizenship.mapper.CandidateCitizenshipMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateCitizenshipServiceImpl implements CandidateCitizenshipService {


    @Override
    public CandidateCitizenship create(Long employeeId, CandidateCitizenshipRequest dto) {
        return null;
    }

    @Override
    public List<CandidateCitizenship> getAllByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public CandidateCitizenship getById(Long employeeId, Long id) {
        return null;
    }

    @Override
    public CandidateCitizenship update(Long employeeId, Long id, CandidateCitizenshipRequest dto) {
        return null;
    }

    @Override
    public void delete(Long employeeId, Long id) {

    }

    @Override
    public CandidateCitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship) {
        return null;
    }
}

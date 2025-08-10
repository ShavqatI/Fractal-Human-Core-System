package com.fractal.domain.citizenship;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.citizenship.mapper.CitizenshipMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CitizenshipServiceImpl implements CitizenshipService {


    @Override
    public Citizenship create(Long employeeId, CitizenshipRequest dto) {
        return null;
    }

    @Override
    public List<Citizenship> getAllByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public Citizenship getById(Long employeeId, Long id) {
        return null;
    }

    @Override
    public Citizenship update(Long employeeId, Long id, CitizenshipRequest dto) {
        return null;
    }

    @Override
    public void delete(Long employeeId, Long id) {

    }

    @Override
    public CitizenshipResponse toDTO(Citizenship citizenship) {
        return null;
    }
}

package com.fractal.domain.employment;

import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmploymentServiceImpl implements EmploymentService {

    private final EmploymentRepository employmentRepository;

    @Override
    public Employment getById(Long id) {
        return employmentRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public Employment save(Employment employment) {
        try {
            return employmentRepository.save(employment);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}

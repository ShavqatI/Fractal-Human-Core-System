package com.fractal.domain.employment.internal;

import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.employment.internal.mapper.InternalEmploymentMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class InternalEmploymentServiceImpl implements InternalEmploymentService {

    private final InternalEmploymentRepository employmentRepository;
    private final InternalEmploymentMapperService mapperService;

    @Override
    @Transactional
    public InternalEmployment create(InternalEmploymentRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InternalEmployment> getAll() {
        return employmentRepository.findAll();
    }

    @Override
    public InternalEmployment getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public InternalEmployment update(Long id, InternalEmploymentRequest dto) {
        try {
            InternalEmployment employment = mapperService.toEntity(findById(id), dto);
            return save(employment);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        employmentRepository.delete(findById(id));
    }

    @Override
    public InternalEmploymentResponse toDTO(InternalEmployment employment) {
        return mapperService.toDTO(employment);
    }

    @Override
    @Transactional
    public InternalEmployment save(InternalEmployment employment) {
        try {
            return employmentRepository.save(employment);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InternalEmployment findById(Long id) {
        return employmentRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}

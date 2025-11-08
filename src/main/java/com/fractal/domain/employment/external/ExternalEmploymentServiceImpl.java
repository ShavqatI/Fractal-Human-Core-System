package com.fractal.domain.employment.external;

import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;
import com.fractal.domain.employment.external.mapper.ExternalEmploymentMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ExternalEmploymentServiceImpl implements ExternalEmploymentService {

    private final ExternalEmploymentRepository employmentRepository;
    private final ExternalEmploymentMapperService mapperService;

    @Override
    @Transactional
    public ExternalEmployment create(ExternalEmploymentRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<ExternalEmployment> getAll() {
        return employmentRepository.findAll();
    }

    @Override
    public ExternalEmployment getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public ExternalEmployment update(Long id, ExternalEmploymentRequest dto) {
        try {
            ExternalEmployment employment = mapperService.toEntity(findById(id),dto);
            return save(employment);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      employmentRepository.delete(findById(id));
    }

    @Override
    public ExternalEmploymentResponse toDTO(ExternalEmployment instructor) {
        return mapperService.toDTO(instructor);
    }

    @Override
    @Transactional
    public ExternalEmployment save(ExternalEmployment employment) {
        try {
            return employmentRepository.save(employment);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ExternalEmployment findById(Long id) {
        return employmentRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}

package com.fractal.domain.organization_management.grade.method.hay.factor;

import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.mapper.HayFactorMapperService;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class HayFactorServiceImpl implements HayFactorService {

    private final HayFactorRepository hayFactorRepository;
    private final HayFactorMapperService mapperService;

    @Override
    public HayFactor create(HayFactorRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<HayFactor> getAll() {
        return hayFactorRepository.findAll();
    }

    @Override
    public HayFactor getByCode(String code) {
        return hayFactorRepository.findByCode(code).orElseThrow(() -> new ResourceWithCodeNotFoundException(this, code));
    }

    @Override
    public HayFactor getById(Long id) {
        return findById(id);
    }

    @Override
    public HayFactor update(Long id, HayFactorRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id), dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        hayFactorRepository.delete(findById(id));
    }

    @Override
    public HayFactorResponse toDTO(HayFactor factor) {
        return mapperService.toDTO(factor);
    }

    @Override
    public HayFactorCompactResponse toCompactDTO(HayFactor factor) {
        return mapperService.toCompactDTO(factor);
    }


    public HayFactor save(HayFactor factor) {
        try {
            return hayFactorRepository.save(factor);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private HayFactor findById(Long id) {
        return hayFactorRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}

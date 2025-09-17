package com.fractal.domain.employee_management.insurance;

import com.fractal.domain.employee_management.insurance.dto.InsuranceRequest;
import com.fractal.domain.employee_management.insurance.dto.InsuranceResponse;
import com.fractal.domain.employee_management.insurance.mapper.InsuranceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapperService mapperService;


    @Override
    public Insurance create(InsuranceRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Insurance> getAllByEmployeeId(Long employeeId) {
        return insuranceRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public List<Insurance> getAll() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance getById(Long id) {
        return findById(id);
    }

    @Override
    public Insurance update(Long id, InsuranceRequest dto) {
        var insurance = findById(id);
        return save(mapperService.toEntity(insurance,dto));
    }

    @Override
    public void deleteById(Long id) {
        insuranceRepository.delete(findById(id));
    }

    @Override
    public Insurance save(Insurance insurance) {
        try {
            return insuranceRepository.save(insurance);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public InsuranceResponse toDTO(Insurance insurance) {
        return mapperService.toDTO(insurance);
    }

    private Insurance findById(Long id) {
        return insuranceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Insurance with id: " + id + " not found"));
    }
}

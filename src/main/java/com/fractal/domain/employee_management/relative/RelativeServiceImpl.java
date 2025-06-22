package com.fractal.domain.employee_management.relative;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.employee_management.relative.mapper.RelativeMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class RelativeServiceImpl implements RelativeService {

    private final RelativeRepository relativeRepository;
    private final RelativeMapperService relativeMapperService;
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public Relative create(Long employeeId,RelativeRequest dto) {
        var employee = employeeService.getById(employeeId);
        var relative = relativeMapperService.toEntity(dto);
        employee.addRelative(relative);
        employeeService.save(employee);
       return relative;
    }

    @Override
    public Relative getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Relative> getAllByEmployeeId(Long employeeId) {
        return relativeRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public Relative getById(Long employeeId, Long id) {
        return relativeRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Relative update(Long employeeId,Long id, RelativeRequest dto) {
        var employee = employeeService.getById(employeeId);
        var relative = employee.getRelatives()
                .stream()
                .filter(r-> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + id + " not found"));
        relative = relativeRepository.save(relativeMapperService.toEntity(relative,dto));
        employeeService.save(employee);
       return relative;
    }
    @Override
    @Transactional
    public void delete(Long employeeId,Long id) {
        var employee = employeeService.getById(employeeId);
        var relative = employee.getRelatives()
                .stream()
                .filter(r-> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + id + " not found"));
        employee.removeRelative(relative);
        relativeRepository.delete(relative);
        employeeService.save(employee);
    }

    @Override
    public RelativeResponse toDTO(Relative relative) {
        return relativeMapperService.toDTO(relative);
    }

    @Override
    public Relative save(Relative relative) {
        try {
            return relativeRepository.save(relative);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Relative findById(Long id) {
        return relativeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + id + " not found"));
    }

}

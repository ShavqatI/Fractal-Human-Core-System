package com.fractal.domain.vacation_management.accrual;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualRequest;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.accrual.mapper.VacationAccrualMapperService;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class VacationAccrualServiceImpl implements VacationAccrualService {

    private final VacationAccrualRepository vacationAccrualRepository;
    private final VacationAccrualMapperService mapperService;
    private final EmployeeService employeeService;
    private final VacationTypeService vacationTypeService;

    @Override
    @Transactional
    public VacationAccrual create(VacationAccrualRequest dto) {
        return save(mapperService.toEntity(dto));

    }

    @Override
    public List<VacationAccrual> getAll() {
        return vacationAccrualRepository.findAll();
    }

    @Override
    public VacationAccrual getById(Long id) {
        return findById(id);
    }

    @Override
    public List<VacationAccrual> getAllByEmployeeId(Long employeeId) {
        return vacationAccrualRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public VacationAccrual update(Long id, VacationAccrualRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id), dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        vacationAccrualRepository.delete(findById(id));
    }

    public VacationAccrualResponse toDTO(VacationAccrual vacationAccrual) {
        return mapperService.toDTO(vacationAccrual);
    }

    @Override
    @Transactional
    public VacationAccrual save(VacationAccrual vacationAccrual) {
        try {
            return vacationAccrualRepository.save(vacationAccrual);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationAccrual findById(Long id) {
        return vacationAccrualRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public void calculate() {
        var employees = employeeService.getAll().stream().filter(employee -> employee.getStatus().getCode().equals("ACTIVE"));
        var vacationTypes = vacationTypeService.getAll().stream().filter(vacationType -> vacationType.getDays() > 0);

    }
}

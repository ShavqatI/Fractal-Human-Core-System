package com.fractal.domain.vacation_management.accrual;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualRequest;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.accrual.mapper.VacationAccrualMapperService;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecord;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
class VacationAccrualServiceImpl implements VacationAccrualService {

    private final VacationAccrualRepository vacationAccrualRepository;
    private final VacationAccrualMapperService mapperService;
    private final EmployeeService employeeService;
    private final VacationTypeService vacationTypeService;
    private final StatusService statusService;

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
    public List<VacationAccrual> getAllActivePeriodByEmployeeId(Long employeeId) {
        return vacationAccrualRepository.findAllByEmployeeId(employeeId)
                .stream()
                .filter(accrual ->
                        accrual.getPeriods().stream()
                                .anyMatch(period ->
                                        "ACTIVE".equals(
                                                statusService.getById(period.getStatus().getId()).getCode()
                                        )
                                )
                ).toList();
    }

    @Override
    public int getAllEmployeeRemainingDays(Long employeeId) {
        var days = 0;
        var accrual = getAllByEmployeeId(employeeId).getFirst();
        var periods = accrual.getPeriods().stream().filter(p-> statusService.getById(p.getStatus().getId()).getCode().equals("ACTIVE")).findFirst();
        if(periods.isPresent()){
          if(!periods.get().getRecords().isEmpty()){
              var records = periods.get().getRecords();
               days = records.stream()
                      .mapToInt(r -> r.getRemainingDays())
                      .sum();
          }
        }
       return days;
    }

    @Override
    public int getAllEmployeeRemainingDaysForCompensation(Long employeeId) {
        var days = 0;
        var accrual = getAllByEmployeeId(employeeId).getFirst();
        var periods = accrual.getPeriods().stream().filter(p-> statusService.getById(p.getStatus().getId()).getCode().equals("ACTIVE")).findFirst();
        if(periods.isPresent()){
            if(!periods.get().getRecords().isEmpty()){
                var records = periods.get().getRecords();
                days = records.stream().filter(r-> r.getVacationType().getPayable().equals(true))
                        .mapToInt(r -> r.getRemainingDays())
                        .sum();
            }
        }
        return days;
    }

    @Override
    public int getAllEmployeeRemainingPayableDays(Long employeeId) {
        var days = 0;
        var accrual = getAllByEmployeeId(employeeId).getFirst();
        var periods = accrual.getPeriods().stream().filter(p-> statusService.getById(p.getStatus().getId()).getCode().equals("ACTIVE")).findFirst();
        if(periods.isPresent()) {
            if(!periods.get().getRecords().isEmpty()){
                var records = periods.get().getRecords();
                days = records.stream().filter(r-> r.getVacationType().getPayable().equals(true))
                        .mapToInt(r -> r.getRemainingDays())
                        .sum();
            }
        }
        return days;
    }

    @Override
    public int getAllEmployeeRemainingUnPayableDays(Long employeeId) {
        var days = 0;
        var accrual = getAllByEmployeeId(employeeId).getFirst();
        var periods = accrual.getPeriods().stream().filter(p-> statusService.getById(p.getStatus().getId()).getCode().equals("ACTIVE")).findFirst();
        if(periods.isPresent()) {
            if(!periods.get().getRecords().isEmpty()){
                var records = periods.get().getRecords();
                days = records.stream().filter(r-> r.getVacationType().getPayable().equals(false))
                        .mapToInt(r -> r.getRemainingDays())
                        .sum();
            }
        }
        return days;
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
    public void accrual() {
        var employees = employeeService.getAll().stream().filter(employee -> employee.getStatus().getCode().equals("ACTIVE"));
        var vacationTypes = vacationTypeService.getAll().stream().filter(vt -> (vt.getCode().equals("ANNUAL") || vt.getCode().equals("CASUAL"))).collect(Collectors.toList());
        employees.forEach(employee -> {
            VacationAccrual accrual;
            if(employee.getVacationAccruals().isEmpty()){
               accrual = VacationAccrual.builder()
                       .status(statusService.getByCode("ACTIVE"))
                       .employee(employee)
                       .build();
            }
            else {
                accrual = employee.getVacationAccruals().getFirst();
            }

            var period = VacationAccrualPeriod.builder()
                    .startDate(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()))
                    .endDate(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()))
                    .status(statusService.getByCode("ACTIVE"))
                    .build();
             var periodStart = period.getStartDate();
             var periodEndDate = period.getEndDate();
             var existPeriod = accrual.getPeriods().stream().filter(period1 -> period1.getStartDate().equals(periodStart) && period1.getEndDate().equals(periodEndDate)).findFirst();
             if(!existPeriod.isEmpty()){
                 period = existPeriod.get();
             }
            VacationAccrualPeriod finalPeriod = period;
            vacationTypes.forEach(vacationType -> {
                 var record = VacationAccrualPeriodRecord.builder()
                         .vacationType(vacationType)
                         .accruedDays(vacationType.getDays())
                         .utilizedDays(0)
                         .remainingDays(vacationType.getDays())
                         .date(LocalDate.now())
                         .status(statusService.getByCode("ACTIVE"))
                         .build();
                 finalPeriod.addRecord(record);
             });
             period = finalPeriod;
             accrual.addPeriod(period);
             save(accrual);
        });

    }
}

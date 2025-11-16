package com.fractal.domain.vacation_management.accrual;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacation_accrual", schema = "vacation_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacationAccrual extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "vacationAccrual", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VacationAccrualPeriod> periods = new ArrayList<>();

    public void addPeriod(VacationAccrualPeriod period) {
        if (periods == null) periods = new ArrayList<>();
        period.setVacationAccrual(this);
        periods.add(period);
    }

    public void removePeriod(VacationAccrualPeriod period) {
        if (periods != null && !periods.isEmpty())
            periods.remove(period);
    }

}

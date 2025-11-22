package com.fractal.domain.vacation_management.vacation.allocation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecord;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.type.VacationType;
import com.fractal.domain.vacation_management.vacation.Vacation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "vacation_allocation", schema = "vacation_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VacationAllocation extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", referencedColumnName = "id")
    private Vacation vacation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_accrual_period_record_id", referencedColumnName = "id")
    private VacationAccrualPeriodRecord vacationAccrualPeriodRecord;

    private Integer days;


}

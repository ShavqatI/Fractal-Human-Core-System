package com.fractal.domain.vacation_management.accrual.period;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacation_accrual_period", schema = "vacation_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VacationAccrualPeriod extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_accrual_id", referencedColumnName = "id")
    private VacationAccrual vacationAccrual;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "vacationAccrualPeriod", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<VacationAccrualPeriodRecord> records = new ArrayList<>();
    public void addRecord(VacationAccrualPeriodRecord record) {
        if (records == null) records = new ArrayList<>();
        record.setVacationAccrualPeriod(this);
        records.add(record);
    }
    public void removeRecord(VacationAccrualPeriodRecord record) {
        if (records != null && !records.isEmpty())
            records.remove(record);
    }
}

package com.fractal.domain.employee_management.attendance.absence;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.attendance.absence.type.AbsenceType;
import com.fractal.domain.employee_management.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "absence", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Absence extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "absence_type_id", referencedColumnName = "id")
    private AbsenceType absenceType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "reason")
    private String reason;

    @Column(name = "remarks")
    private String remarks;

}

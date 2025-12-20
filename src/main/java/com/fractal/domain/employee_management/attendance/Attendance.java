package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attendance extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "hours_worked")
    private long hoursWorked;

    @Column(name = "overtime_hours")
    private long overtimeHours;

    @Column(name = "remarks")
    private String remarks;
}

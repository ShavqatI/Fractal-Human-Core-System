package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.attendance.absence.Absence;
import com.fractal.domain.employee_management.attendance.absence.type.AbsenceType;
import com.fractal.domain.employee_management.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "absence_id", referencedColumnName = "id")
    private Absence absence;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "canceled_date")
    private LocalDateTime canceledDate;

    @ManyToOne
    @JoinColumn(name = "canceled_user_id")
    private User canceledUser;

    @Column(name = "canceled_reason")
    private String canceledReason;
}

package com.fractal.domain.vacation_management.schedule;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.vacation_management.type.VacationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "vacation_schedule", schema = "vacation_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacationSchedule extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_type_id", referencedColumnName = "id")
    private VacationType vacationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "days")
    private Integer days;

    @Column(name = "canceled_date")
    private LocalDateTime canceledDate;

    @ManyToOne
    @JoinColumn(name = "canceled_user_id")
    private User canceledUser;

    @Column(name = "canceled_reason")
    private String canceledReason;
}

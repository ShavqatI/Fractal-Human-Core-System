package com.fractal.domain.employment.punishment;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.punishment.type.PunishmentType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "punishment", schema = "employment_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Punishment extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_id", referencedColumnName = "id")
    private Employment employment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee initiator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "punishment_type_id", referencedColumnName = "id")
    private PunishmentType punishmentType;

    private String description;
    private BigDecimal amount;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(name = "canceled_date")
    private LocalDateTime canceledDate;

    @ManyToOne
    @JoinColumn(name = "canceled_user_id")
    private User canceledUser;

    @Column(name = "canceled_reason")
    private String canceledReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;



}

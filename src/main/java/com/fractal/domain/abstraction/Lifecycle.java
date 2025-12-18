package com.fractal.domain.abstraction;


import com.fractal.domain.authorization.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public abstract class Lifecycle extends ApprovalWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @Column(name = "open_date")
    protected LocalDate openDate;

    @Column(name = "open_reason")
    protected String openReason;

    @Column(name = "close_date")
    protected LocalDate closeDate;

    @Column(name = "close_reason")
    protected String closeReason;

    @ManyToOne
    @JoinColumn(name = "closed_user_id")
    protected User closedUser;
}

package com.fractal.domain.abstraction;


import com.fractal.domain.authorization.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class ApprovalWorkflow extends Auditable {

    @Column(name = "reviewed_date")
    protected LocalDateTime reviewedDate;

    @ManyToOne
    @JoinColumn(name = "reviewed_user_id")
    protected User reviewedUser;

    @Column(name = "approved_date")
    protected LocalDateTime approvedDate;

    @ManyToOne
    @JoinColumn(name = "approved_user_id")
    protected User approvedUser;

}

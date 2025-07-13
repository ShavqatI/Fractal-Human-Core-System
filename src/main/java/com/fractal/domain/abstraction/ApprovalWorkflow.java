package com.fractal.domain.abstraction;


import com.fractal.domain.authorization.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalWorkflow extends Auditable {

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

    public LocalDateTime getReviewedDate() {
        return reviewedDate;
    }

    protected void setReviewedDate(LocalDateTime reviewedDate) {
        this.reviewedDate = reviewedDate;
    }

    public User getReviewedUser() {
        return reviewedUser;
    }

    protected void setReviewedUser(User reviewedUser) {
        this.reviewedUser = reviewedUser;
    }

    public LocalDateTime getApprovedDate() {
        return approvedDate;
    }

    protected void setApprovedDate(LocalDateTime approvedDate) {
        this.approvedDate = approvedDate;
    }

    public User getApprovedUser() {
        return approvedUser;
    }

    protected void setApprovedUser(User approvedUser) {
        this.approvedUser = approvedUser;
    }
}

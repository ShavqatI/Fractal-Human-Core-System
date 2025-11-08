package com.fractal.domain.abstraction;

import com.fractal.domain.authorization.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @Column(name = "created_date", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreatedDate
    protected LocalDateTime createdDate;

    @Column(name = "updated_date",insertable = false)
    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id",updatable = false,referencedColumnName = "id")
    @CreatedBy
    protected User createdUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_user_id",insertable = false,referencedColumnName = "id")
    //@LastModifiedBy
    protected User updatedUser;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public User getUpdatedUser() {
        return updatedUser;
    }

}


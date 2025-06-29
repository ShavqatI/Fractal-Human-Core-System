package com.fractal.domain.abstraction;

import com.fractal.domain.authorization.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Auditable {

    @Column(name = "created_date", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime createdDate;

    @Column(name = "updated_date")
    protected LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "created_user_id")
    protected User createdUser;

    @ManyToOne
    @JoinColumn(name = "updated_user_id")
    protected User updatedUser;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

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


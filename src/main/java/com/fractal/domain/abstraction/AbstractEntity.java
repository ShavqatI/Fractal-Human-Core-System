package com.fractal.domain.abstraction;

import com.fractal.domain.user.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "created_date",updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
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

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createdDate, that.createdDate) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(createdUser, that.createdUser) && Objects.equals(updatedUser, that.updatedUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, updatedDate, createdUser, updatedUser);
    }

}

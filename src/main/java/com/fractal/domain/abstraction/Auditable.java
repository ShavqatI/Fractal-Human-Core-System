package com.fractal.domain.abstraction;


import com.fractal.domain.authorization.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Setter
@Getter
//@EntityListeners({AuditingEntityListener.class})
public abstract class Auditable {

    @Column(name = "created_date", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //@CreatedDate
    protected LocalDateTime createdDate;

    @Column(name = "updated_date", insertable = false)
    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id", updatable = false, referencedColumnName = "id")
    //@CreatedBy
    protected User createdUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_user_id", updatable = true, referencedColumnName = "id")
    //@LastModifiedBy
    protected User updatedUser;


    @PrePersist
    public void onPrePersist() {
        this.createdDate = LocalDateTime.now();
    }



}


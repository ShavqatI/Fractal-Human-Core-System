
package com.fractal.config;

import com.fractal.component.CurrentUserHolder;
import com.fractal.component.SpringContext;
import com.fractal.domain.abstraction.Auditable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class AuditEntityListener {

    @PrePersist
    public void prePersist(Auditable entity) {
        try {
            CurrentUserHolder currentUserHolder = SpringContext.getBean(CurrentUserHolder.class);
            entity.setCreatedUser(currentUserHolder.get());
            entity.setCreatedDate(LocalDateTime.now());
        } catch (Exception e) {
            System.out.println("Error fetching user: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @PreUpdate
    public void preUpdate(Auditable entity) {
        try {
            CurrentUserHolder currentUserHolder = SpringContext.getBean(CurrentUserHolder.class);
            entity.setUpdatedUser(currentUserHolder.get());
            entity.setUpdatedDate(LocalDateTime.now());
        } catch (Exception e) {
            System.out.println("Error fetching user: " + e.getMessage());
            e.printStackTrace();
        }
    }

}


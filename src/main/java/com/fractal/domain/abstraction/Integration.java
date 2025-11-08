package com.fractal.domain.abstraction;


import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class Integration extends AbstractEntity {

     private String referenceType;
     private String reference;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "status_id",updatable = false,referencedColumnName = "id")
     protected Status status;
}

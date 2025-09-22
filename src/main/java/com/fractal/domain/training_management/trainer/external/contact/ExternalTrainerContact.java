package com.fractal.domain.training_management.trainer.external.contact;


import com.fractal.domain.contact.Contact;
import com.fractal.domain.training_management.trainer.external.ExternalTrainer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "external_trainer_contact",schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class ExternalTrainerContact extends Contact {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_trainer_id", referencedColumnName = "id")
    private ExternalTrainer externalTrainer;

}

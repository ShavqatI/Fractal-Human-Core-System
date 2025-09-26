package com.fractal.domain.learning_develpment.learning.learner.external.contact;


import com.fractal.domain.contact.Contact;
import com.fractal.domain.learning_develpment.learning.learner.external.ExternalLearner;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "external_learner_contact",schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class ExternalLearnerContact extends Contact {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_learner_id", referencedColumnName = "id")
    private ExternalLearner externalLearner;

}

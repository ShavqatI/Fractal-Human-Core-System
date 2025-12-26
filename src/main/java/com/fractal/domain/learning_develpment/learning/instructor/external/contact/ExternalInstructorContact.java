package com.fractal.domain.learning_develpment.learning.instructor.external.contact;


import com.fractal.domain.contact.Contact;
import com.fractal.domain.learning_develpment.learning.instructor.external.ExternalInstructor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "external_instructor_contact", schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExternalInstructorContact extends Contact {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_instructor_id", referencedColumnName = "id")
    private ExternalInstructor externalInstructor;

}

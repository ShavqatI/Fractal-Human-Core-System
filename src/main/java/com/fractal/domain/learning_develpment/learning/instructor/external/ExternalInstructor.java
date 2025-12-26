package com.fractal.domain.learning_develpment.learning.instructor.external;

import com.fractal.domain.dictionary.gender.Gender;
import com.fractal.domain.dictionary.marital_status.MaritalStatus;
import com.fractal.domain.dictionary.nationality.Nationality;
import com.fractal.domain.learning_develpment.learning.instructor.Instructor;
import com.fractal.domain.learning_develpment.learning.instructor.external.contact.ExternalInstructorContact;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "external_instructor", schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExternalInstructor extends Instructor {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "patronymic_name")
    private String patronymicName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "tin")
    private String tin;

    @Column(name = "ssn")
    private String ssn;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "marital_status_id", referencedColumnName = "id")
    private MaritalStatus maritalStatus;

    @ManyToOne
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    private Nationality nationality;

    @OneToMany(mappedBy = "externalInstructor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ExternalInstructorContact> contacts = new ArrayList<>();

    public void addContact(ExternalInstructorContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setExternalInstructor(this);
        contacts.add(contact);
    }

    public void removeContact(ExternalInstructorContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }

}

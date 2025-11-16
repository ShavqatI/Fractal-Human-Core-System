package com.fractal.domain.learning_develpment.learning.learner.external;

import com.fractal.domain.dictionary.gender.Gender;
import com.fractal.domain.dictionary.marital_status.MaritalStatus;
import com.fractal.domain.dictionary.nationality.Nationality;
import com.fractal.domain.learning_develpment.learning.learner.Learner;
import com.fractal.domain.learning_develpment.learning.learner.external.contact.ExternalLearnerContact;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "external_learner", schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExternalLearner extends Learner {

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

    @OneToMany(mappedBy = "externalLearner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ExternalLearnerContact> contacts = new ArrayList<>();

    public void addContact(ExternalLearnerContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setExternalLearner(this);
        contacts.add(contact);
    }

    public void removeContact(ExternalLearnerContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }

}

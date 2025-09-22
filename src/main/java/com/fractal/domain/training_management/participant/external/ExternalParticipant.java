package com.fractal.domain.training_management.participant.external;

import com.fractal.domain.dictionary.gender.Gender;
import com.fractal.domain.dictionary.marital_status.MaritalStatus;
import com.fractal.domain.dictionary.nationality.Nationality;
import com.fractal.domain.training_management.participant.Participant;
import com.fractal.domain.training_management.participant.external.contact.ExternalParticipantContact;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "external_participant", schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExternalParticipant extends Participant {

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

    @OneToMany(mappedBy = "externalParticipant", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ExternalParticipantContact> contacts = new ArrayList<>();

    public void addContact(ExternalParticipantContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setExternalParticipant(this);
        contacts.add(contact);
    }

    public void removeContact(ExternalParticipantContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }

}

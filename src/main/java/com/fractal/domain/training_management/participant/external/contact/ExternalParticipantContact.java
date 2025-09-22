package com.fractal.domain.training_management.participant.external.contact;


import com.fractal.domain.contact.Contact;
import com.fractal.domain.training_management.participant.external.ExternalParticipant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "external_participant_contact",schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class ExternalParticipantContact extends Contact {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_participant_id", referencedColumnName = "id")
    private ExternalParticipant externalParticipant;

}

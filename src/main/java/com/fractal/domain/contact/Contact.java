package com.fractal.domain.contact;

import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.contact.type.ContactType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "contact", schema = "contact_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Contact extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contact_type_id", referencedColumnName = "id")
    private ContactType contactType;

    @Column(name = "value")
    private String value;

}

package com.fractal.domain.contact;

import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.contact.type.ContactType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "contact", schema = "contact_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Contact extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contact_type_id", referencedColumnName = "id")
    private ContactType contactType;

    @Column(name = "value")
    private String value;
}

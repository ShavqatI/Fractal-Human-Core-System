package com.fractal.domain.contact;

import com.fractal.domain.abstraction.Auditable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "contact", schema = "contact_schema", catalog = "fractal")
@Data
public class Contact extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}

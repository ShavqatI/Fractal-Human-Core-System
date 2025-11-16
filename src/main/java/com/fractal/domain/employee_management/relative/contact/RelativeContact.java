package com.fractal.domain.employee_management.relative.contact;


import com.fractal.domain.contact.Contact;
import com.fractal.domain.employee_management.relative.Relative;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "relative_contact", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class RelativeContact extends Contact {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relative_id", referencedColumnName = "id")
    private Relative relative;

}

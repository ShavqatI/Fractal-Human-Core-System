package com.fractal.domain.organization_management.organization.contact;


import com.fractal.domain.contact.Contact;
import com.fractal.domain.organization_management.organization.Organization;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "organization_contact", schema = "organization_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class OrganizationContact extends Contact {

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

}

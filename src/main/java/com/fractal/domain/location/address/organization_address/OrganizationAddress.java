package com.fractal.domain.location.address.organization_address;


import com.fractal.domain.location.address.Address;
import com.fractal.domain.organization_management.organization.Organization;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "organization_address", schema = "location_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationAddress extends Address {

    @ManyToOne
    @JoinColumn(name ="organization_id", referencedColumnName = "id")
    private Organization organization;
}

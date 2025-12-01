package com.fractal.domain.integration.mapping.organization;

import com.fractal.domain.abstraction.Integration;
import com.fractal.domain.organization_management.organization.Organization;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "organization_mapping", schema = "integration_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class OrganizationMapping extends Integration {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", updatable = false, referencedColumnName = "id")
    protected Organization organization;

}

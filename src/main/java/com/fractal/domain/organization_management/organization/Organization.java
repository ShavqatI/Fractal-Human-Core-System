package com.fractal.domain.organization_management.organization;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.organization.address.OrganizationAddress;
import com.fractal.domain.organization_management.unit.OrganizationUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organization", schema = "organization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization extends AbstractEntity {

    @Column(name = "code",unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "tin_number")
    private String tinNumber;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "close_date")
    private LocalDate closeDate;

    @Column(name = "level")
    private Integer level;

    @Column(name = "level_map")
    private String levelMap;

    @ManyToOne
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Organization parent;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Organization> children = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<OrganizationAddress> addresses = new ArrayList<>();

    public void addAddress(OrganizationAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setOrganization(this);
        addresses.add(address);
    }
    public void removeAddress(OrganizationAddress address) {
        if (addresses != null && !addresses.isEmpty())
            addresses.remove(address);
    }

    public void addChild(Organization organization) {
        if (children == null) children = new ArrayList<>();
        organization.setParent(this);
        children.add(organization);
    }
    public void removeChild(Organization organization) {
        if (children != null && !children.isEmpty())
            children.remove(organization);
    }

}

package com.fractal.domain.organization_management.organization;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.location.address.organization_address.OrganizationAddress;
import com.fractal.domain.organization_management.organization_unit.OrganizationUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organization", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "code")
    private String code;

    @Column(name = "tin_number")
    private String tinNumber;

    @Column(name = "open_date")
    private Date openDate;

    @Column(name = "close_date")
    private Date closeDate;

    @Column(name = "level")
    private Integer level;

    @Column(name = "level_map")
    private String levelMap;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Organization parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Organization> children = new ArrayList<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<OrganizationAddress> addresses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;
}

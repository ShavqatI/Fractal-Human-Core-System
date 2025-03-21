package com.fractal.domain.organization_management;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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

    @ManyToOne
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;
}

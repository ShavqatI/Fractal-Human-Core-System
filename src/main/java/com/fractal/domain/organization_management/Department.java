package com.fractal.domain.organization_management;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department", schema = "organization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "level")
    private Integer level;

    @Column(name = "level_map")
    private String levelMap;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Department parent;

    @ManyToOne
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;
}

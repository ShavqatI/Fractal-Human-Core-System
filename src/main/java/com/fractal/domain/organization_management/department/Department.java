package com.fractal.domain.organization_management.department;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.unit.OrganizationUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department", schema = "organization_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Department extends AbstractEntity {

    @Column(name = "code",unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "level_map")
    private String levelMap;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Department parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Department> children = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;

    public void addChild(Department department) {
        if (children == null) children = new ArrayList<>();
        department.setParent(this);
        children.add(department);
    }
    public void removeChild(Department department) {
        if (children != null && !children.isEmpty())
            children.remove(department);
    }
}

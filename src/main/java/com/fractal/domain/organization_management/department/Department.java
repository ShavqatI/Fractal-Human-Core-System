package com.fractal.domain.organization_management.department;

import com.fractal.domain.abstraction.Lifecycle;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.unit.OrganizationUnit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department", schema = "organization_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Department extends Lifecycle {

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "level_map")
    private String levelMap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Department parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Department> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Transactional
    public void addChild(Department department) {
        if (children == null) children = new ArrayList<>();
        department.setParent(this);
        children.add(department);
    }

    @Transactional
    public void removeChild(Department department) {
        if (children != null && !children.isEmpty())
            children.remove(department);
    }
}

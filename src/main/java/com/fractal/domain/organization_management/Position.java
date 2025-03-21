package com.fractal.domain.organization_management;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

}

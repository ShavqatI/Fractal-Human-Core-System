package com.fractal.domain.organization_management.grade.method.hay.factor.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hay_factor_type", schema = "organization_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HayFactorType extends Dictionary {

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private HayFactorType parent;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<HayFactorType> children = new ArrayList<>();

    public void addChild(HayFactorType factorType) {
        if (children == null) children = new ArrayList<>();
        factorType.setParent(this);
        children.add(factorType);
    }
    public void removeChild(HayFactorType factorType) {
        if (children != null && !children.isEmpty())
            children.remove(factorType);
    }
}

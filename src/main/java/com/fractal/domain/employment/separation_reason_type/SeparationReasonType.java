package com.fractal.domain.employment.separation_reason_type;


import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "separation_reason_type", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SeparationReasonType extends Dictionary {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private SeparationReasonType parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SeparationReasonType> children = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Transactional
    public void addChild(SeparationReasonType separationReasonType) {
        if (children == null) children = new ArrayList<>();
        separationReasonType.setParent(this);
        children.add(separationReasonType);
    }

    @Transactional
    public void removeChild(SeparationReasonType separationReasonType) {
        if (children != null && !children.isEmpty())
            children.remove(separationReasonType);
    }

}

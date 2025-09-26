package com.fractal.domain.learning_develpment.learning.category;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "learning_category", schema = "ld_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class LearningCategory extends Dictionary {

    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private LearningCategory parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<LearningCategory> children = new ArrayList<>();

    public void addChild(LearningCategory learningCategory) {
        if (children == null) children = new ArrayList<>();
        learningCategory.setParent(this);
        children.add(learningCategory);
    }
    public void removeChild(LearningCategory learningCategory) {
        if (children != null && !children.isEmpty())
            children.remove(learningCategory);
    }


}

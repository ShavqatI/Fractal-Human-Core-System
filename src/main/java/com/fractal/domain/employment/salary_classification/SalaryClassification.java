package com.fractal.domain.employment.salary_classification;


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
@Table(name = "salary_classification", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SalaryClassification extends Dictionary {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private SalaryClassification parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SalaryClassification> children = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Transactional
    public void addChild(SalaryClassification salaryClassification) {
        if (children == null) children = new ArrayList<>();
        salaryClassification.setParent(this);
        children.add(salaryClassification);
    }

    @Transactional
    public void removeChild(SalaryClassification salaryClassification) {
        if (children != null && !children.isEmpty())
            children.remove(salaryClassification);
    }

}

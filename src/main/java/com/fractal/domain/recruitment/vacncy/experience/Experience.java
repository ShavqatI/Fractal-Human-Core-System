package com.fractal.domain.recruitment.vacncy.experience;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.recruitment.vacncy.Vacancy;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experience", schema = "recruitment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Experience extends AbstractEntity {

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "required_years")
    private Integer requiredYears;

    @Column(name = "domain")
    private String domain;

    @Column(name = "level")
    private String level;

    @Column(name = "mandatory")
    private Boolean mandatory;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "vacancy_id",referencedColumnName = "id")
    private Vacancy vacancy;
}
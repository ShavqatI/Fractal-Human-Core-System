package com.fractal.domain.recruitment.vacncy.skill;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.recruitment.vacncy.Vacancy;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skill", schema = "recruitment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Skill extends AbstractEntity {

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "vacancy_id",referencedColumnName = "id")
    private Vacancy vacancy;
}

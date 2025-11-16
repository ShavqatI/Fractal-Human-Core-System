package com.fractal.domain.recruitment.vacncy.duty;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.recruitment.vacncy.Vacancy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "duty", schema = "recruitment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Duty extends AbstractEntity {

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacancy_id", referencedColumnName = "id")
    private Vacancy vacancy;
}

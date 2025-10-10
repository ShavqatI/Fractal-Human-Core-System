package com.fractal.domain.employment.work_experience.separation_reason;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employment.separation_reason_type.SeparationReasonType;
import com.fractal.domain.employment.work_experience.WorkExperience;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/*
@Entity
@Table(name = "separation_reason", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class SeparationReason extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "separation_reason_type_id", referencedColumnName = "id")
    private SeparationReasonType separationReasonType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_experience_id", referencedColumnName = "id")
    private WorkExperience workExperience;



}
*/

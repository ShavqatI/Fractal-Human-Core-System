package com.fractal.domain.organization_management.grade.method.hay;


import com.fractal.domain.organization_management.grade.method.GradingEvaluation;
import com.fractal.domain.organization_management.grade.method.hay.factor.HayFactor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "hay_evaluation", schema = "organization_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class HayEvaluation extends GradingEvaluation {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hay_factor_id",referencedColumnName = "id")
    private HayFactor hayFactor;

    private Double point;




}

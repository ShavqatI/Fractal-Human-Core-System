package com.fractal.domain.education.grade_point_average;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "grade_point_average", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class GradePointAverage extends AbstractEntity {

    @Column(name = "value")
    private String value;

    @Column(name = "scale")
    private Double scale;
}

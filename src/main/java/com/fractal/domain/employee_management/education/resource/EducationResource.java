package com.fractal.domain.employee_management.education.resource;


import com.fractal.domain.employee_management.education.Education;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "education_resource",schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class EducationResource extends Resource {

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    private Education education;

}

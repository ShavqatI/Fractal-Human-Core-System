package com.fractal.domain.employee_management.professional_experience;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.industry.Industry;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.recruitment.candidate.Candidate;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employee_professional_experience",schema = "employee_schema", catalog = "fractal")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
public class EmployeeProfessionalExperience extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_id", referencedColumnName = "id")
    private Industry industry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    private Integer years;



}

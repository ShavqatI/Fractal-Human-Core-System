package com.fractal.domain.employee_management.work_experience;


import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.work_experience.WorkExperience;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "employee_work_experience", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class EmployeeWorkExperience extends WorkExperience {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="employee_id", referencedColumnName = "id")
    private Employee employee;
}

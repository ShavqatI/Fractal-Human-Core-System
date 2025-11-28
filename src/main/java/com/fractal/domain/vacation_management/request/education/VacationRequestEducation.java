package com.fractal.domain.vacation_management.request.education;


import com.fractal.domain.education.Education;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.vacation_management.request.VacationRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "vacation_request_education", schema = "vacation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VacationRequestEducation extends Education {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_request_id", referencedColumnName = "id")
    private VacationRequest vacationRequest;
}

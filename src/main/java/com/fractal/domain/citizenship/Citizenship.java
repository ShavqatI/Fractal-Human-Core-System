package com.fractal.domain.citizenship;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.abstraction.Person;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "citizenship", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Citizenship extends AbstractEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    protected Country country;

}

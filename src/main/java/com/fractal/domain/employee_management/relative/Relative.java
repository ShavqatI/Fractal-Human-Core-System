package com.fractal.domain.employee_management.relative;


import com.fractal.domain.abstraction.Person;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.relative.relation_type.RelationType;
import com.fractal.domain.location.address.relative_address.RelativeAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "relative", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Relative extends Person {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "relation_type_id", referencedColumnName = "id")
    private RelationType relationType;

    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<RelativeAddress> addresses   = new ArrayList<>();


}

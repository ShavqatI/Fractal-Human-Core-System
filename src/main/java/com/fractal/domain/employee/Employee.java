package com.fractal.domain.employee;

import com.fractal.domain.abstraction.AbstractPerson;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee", schema = "employee_schema", catalog = "fractal")
public class Employee extends AbstractPerson {


}

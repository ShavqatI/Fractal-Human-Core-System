package com.fractal.domain.employee;


import com.fractal.domain.abstraction.AbstractPerson;
import com.fractal.domain.dictionary.RelationType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "relative", schema = "employee_schema", catalog = "fractal")
public class Relative extends AbstractPerson {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "relation_type_id", referencedColumnName = "id")
    private RelationType relationType;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }
}

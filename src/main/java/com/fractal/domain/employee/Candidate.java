package com.fractal.domain.employee;


import com.fractal.domain.abstraction.AbstractPerson;
import com.fractal.domain.organization.Vacancy;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "candidate", schema = "employee_schema", catalog = "fractal")
public class Candidate extends AbstractPerson {

    @ManyToOne
    @JoinColumn(name = "vacancy_id", referencedColumnName = "id")
    private Vacancy vacancy;

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }
}

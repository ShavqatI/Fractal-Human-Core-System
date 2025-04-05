package com.fractal.domain.employee_management.vacation.category;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacation_category", schema = "employee_schema", catalog = "fractal")
public class VacationCategory extends Dictionary {
    private String description;

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

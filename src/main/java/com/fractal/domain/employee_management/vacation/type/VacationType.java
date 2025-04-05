package com.fractal.domain.employee_management.vacation.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacation_type", schema = "dictionary_schema", catalog = "fractal")
public class VacationType extends Dictionary {
    private String description;
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.fractal.domain.employee_management.attendance.absence.type;


import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "absence_type", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceType extends Dictionary {
}

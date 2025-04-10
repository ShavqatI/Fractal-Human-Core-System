package com.fractal.domain.employee_management.attendance.absence.type;


import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "absence_type", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AbsenceType extends Dictionary {
}

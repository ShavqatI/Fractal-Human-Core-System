package com.fractal.domain.order.employment.record;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.order.employment.EmploymentOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employment_order_record", schema = "order_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmploymentOrderRecord extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_order_id", referencedColumnName = "id")
    private EmploymentOrder employmentOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_employment_id", referencedColumnName = "id")
    private EmployeeEmployment employment;
}

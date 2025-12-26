package com.fractal.domain.order.recognition.record;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.order.recognition.RecognitionOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "recognition_order_record", schema = "order_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RecognitionOrderRecord extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recognition_order_id", referencedColumnName = "id")
    private RecognitionOrder recognitionOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_employment_id", referencedColumnName = "id")
    private EmployeeEmployment employment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compensation_component_id", referencedColumnName = "id")
    private CompensationComponent compensationComponent;
}

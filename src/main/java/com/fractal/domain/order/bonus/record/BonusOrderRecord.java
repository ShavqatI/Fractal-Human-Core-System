package com.fractal.domain.order.bonus.record;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.order.bonus.BonusOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "bonus_order_record", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BonusOrderRecord extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bonus_order_id", referencedColumnName = "id")
    private BonusOrder bonusOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_employment_id", referencedColumnName = "id")
    private EmployeeEmployment employment;
}

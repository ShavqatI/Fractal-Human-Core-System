package com.fractal.domain.order.punishment;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.punishment.Punishment;
import com.fractal.domain.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "punishment_order", schema = "order_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PunishmentOrder extends Order {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_employment_id", referencedColumnName = "id")
    private EmployeeEmployment employeeEmployment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "punishment_id", referencedColumnName = "id")
    private Punishment punishment;

}

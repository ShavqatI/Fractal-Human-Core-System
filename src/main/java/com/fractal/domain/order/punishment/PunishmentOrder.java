package com.fractal.domain.order.punishment;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.punishment.Punishment;
import com.fractal.domain.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "punishment_order", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PunishmentOrder extends Order {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_employment_id", referencedColumnName = "id")
    private EmployeeEmployment employeeEmployment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "punishment_id", referencedColumnName = "id")
    private Punishment punishment;

}

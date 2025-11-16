package com.fractal.domain.vacation_management.vacation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.vacation_management.vacation.order.VacationOrder;
import com.fractal.domain.vacation_management.request.VacationRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacation", schema = "vacation_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vacation extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_request_id", referencedColumnName = "id")
    private VacationRequest vacationRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VacationOrder> orders = new ArrayList<>();

    public void addOrder(VacationOrder order) {
        if (orders == null) orders = new ArrayList<>();
        order.setVacation(this);
        orders.add(order);
    }
    public void removeOrder(VacationOrder order) {
        if (orders != null && !orders.isEmpty())
            orders.remove(order);
    }

}

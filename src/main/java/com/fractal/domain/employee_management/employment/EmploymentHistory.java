package com.fractal.domain.employee_management.employment;

import com.fractal.domain.abstraction.AbstractEmploymentHistory;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employment.agreement.Agreement;
import com.fractal.domain.employee_management.employment.order.EmploymentHistoryOrder;
import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.position.Position;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employment_history", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmploymentHistory extends AbstractEmploymentHistory {

    @Column(name = "serial")
    private Integer serial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "employmentHistory", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private  List<Agreement> agreements   = new ArrayList<>();

    @OneToMany(mappedBy = "employmentHistory", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<EmploymentHistoryOrder> orders = new ArrayList<>();


    public void addAgreement(Agreement agreement) {
        if (agreements == null) agreements = new ArrayList<>();
        agreement.setEmploymentHistory(this);
        agreements.add(agreement);
    }
    public void removeAgreement(Agreement agreement) {
        if (agreements != null && !agreements.isEmpty())
            agreements.remove(agreement);
    }

    public void addOrder(EmploymentHistoryOrder order) {
        if (orders == null) orders = new ArrayList<>();
        order.setEmploymentHistory(this);
        orders.add(order);
    }
    public void removeOrder(EmploymentHistoryOrder order) {
        if (orders != null && !orders.isEmpty())
            orders.remove(order);
    }

}

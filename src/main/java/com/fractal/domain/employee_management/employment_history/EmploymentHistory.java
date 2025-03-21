package com.fractal.domain.employee_management.employment_history;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import com.fractal.domain.employee_management.category.Category;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.organization_management.Department;
import com.fractal.domain.organization_management.Organization;
import com.fractal.domain.organization_management.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "labor_activity", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentHistory extends AbstractEntity {

    @Column(name = "accept_date")
    private Date acceptDate;

    @Column(name = "agreement_number")
    private String agreementNumber;

    @Column(name = "agreement_date")
    private Date agreementDate;

    @Column(name = "agreement_term")
    private Date agreementTerm;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "serial")
    private Integer serial;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

}

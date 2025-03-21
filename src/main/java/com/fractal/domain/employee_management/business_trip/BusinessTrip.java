package com.fractal.domain.employee_management.business_trip;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.organization_management.Organization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Table(name = "business_trip", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTrip extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "description")
    private String description;

}

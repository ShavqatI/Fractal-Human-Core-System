package com.fractal.domain.employee;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import com.fractal.domain.organization.Organization;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "business_trip", schema = "employee_schema", catalog = "fractal")
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

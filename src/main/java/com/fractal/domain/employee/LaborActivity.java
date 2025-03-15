package com.fractal.domain.employee;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import com.fractal.domain.organization.Department;
import com.fractal.domain.organization.Organization;
import com.fractal.domain.organization.Position;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "labor_activity", schema = "employee_schema", catalog = "fractal")
public class LaborActivity extends AbstractEntity {
    @Basic
    @Column(name = "accept_date")
    private Date acceptDate;
    @Basic
    @Column(name = "agreement_number")
    private String agreementNumber;
    @Basic
    @Column(name = "agreement_date")
    private Date agreementDate;
    @Basic
    @Column(name = "agreement_term")
    private Date agreementTerm;
    @Basic
    @Column(name = "order_number")
    private String orderNumber;
    @Basic
    @Column(name = "order_date")
    private Date orderDate;
    @Basic
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




    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }


    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public Date getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(Date agreementDate) {
        this.agreementDate = agreementDate;
    }

    public Date getAgreementTerm() {
        return agreementTerm;
    }

    public void setAgreementTerm(Date agreementTerm) {
        this.agreementTerm = agreementTerm;
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

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employeeByEmployeeId) {
        this.employee = employeeByEmployeeId;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organizationByOrganizationId) {
        this.organization = organizationByOrganizationId;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departmentByDepartmentId) {
        this.department = departmentByDepartmentId;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position positionByPositionId) {
        this.position = positionByPositionId;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status statusByStatusId) {
        this.status = statusByStatusId;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryByCategoryId) {
        this.category = categoryByCategoryId;
    }




}

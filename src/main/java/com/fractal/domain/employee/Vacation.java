package com.fractal.domain.employee;

import com.fractal.domain.dictionary.Status;
import com.fractal.domain.dictionary.VacationCategory;
import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.VacationType;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "vacation", schema = "employee_schema", catalog = "fractal")
public class Vacation extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "replaced_employee_id", referencedColumnName = "id")
    private Employee replacedEmployee;

    @ManyToOne
    @JoinColumn(name = "vacation_category_id", referencedColumnName = "id")
    private VacationCategory vacationCategory;

    @ManyToOne
    @JoinColumn(name = "vacation_type_id", referencedColumnName = "id")
    private VacationType vacationType;
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

    public Employee getReplacedEmployee() {
        return replacedEmployee;
    }

    public void setReplacedEmployee(Employee replacedEmployee) {
        this.replacedEmployee = replacedEmployee;
    }

    public VacationCategory getVacationCategory() {
        return vacationCategory;
    }

    public void setVacationCategory(VacationCategory vacationCategory) {
        this.vacationCategory = vacationCategory;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
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

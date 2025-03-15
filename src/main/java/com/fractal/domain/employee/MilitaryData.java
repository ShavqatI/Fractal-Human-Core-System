package com.fractal.domain.employee;


import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "military_data", schema = "employee_schema", catalog = "fractal")
public class MilitaryData extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "category_fund")
    private String categoryFund;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private String image;

    @Column(name = "begin_date")
    private Date beginDate;
    @Column(name = "end_date")
    private Date endDate;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryFund() {
        return categoryFund;
    }

    public void setCategoryFund(String categoryFund) {
        this.categoryFund = categoryFund;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}

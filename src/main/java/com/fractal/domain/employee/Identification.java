package com.fractal.domain.employee;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.IdentificationType;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "identification", schema = "employee_schema", catalog = "fractal")
public class Identification extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "identification_type_id", referencedColumnName = "id")
    private IdentificationType identificationType;


    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "valid_date")
    private Date validDate;

    @Column(name = "term")
    private Integer term;

    @Column(name = "issue_organization")
    private String issueOrganization;

    @Column(name = "issue_organization_address")
    private String issueOrganizationAddress;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getIssueOrganization() {
        return issueOrganization;
    }

    public void setIssueOrganization(String issueOrganization) {
        this.issueOrganization = issueOrganization;
    }

    public String getIssueOrganizationAddress() {
        return issueOrganizationAddress;
    }

    public void setIssueOrganizationAddress(String issueOrganizationAddress) {
        this.issueOrganizationAddress = issueOrganizationAddress;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

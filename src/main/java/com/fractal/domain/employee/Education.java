package com.fractal.domain.employee;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.EducationDocumentType;
import com.fractal.domain.dictionary.EducationType;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "education", schema = "employee_schema", catalog = "fractal")
public class Education extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "education_type_id", referencedColumnName = "id")
    private EducationType educationType;

    @ManyToOne
    @JoinColumn(name = "education_document_type_id", referencedColumnName = "id")
    private EducationDocumentType educationDocumentType;


    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "university")
    private String university;

    @Column(name = "university_address")
    private String universityAddress;

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

    public EducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }

    public EducationDocumentType getEducationDocumentType() {
        return educationDocumentType;
    }

    public void setEducationDocumentType(EducationDocumentType educationDocumentType) {
        this.educationDocumentType = educationDocumentType;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversityAddress() {
        return universityAddress;
    }

    public void setUniversityAddress(String universityAddress) {
        this.universityAddress = universityAddress;
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

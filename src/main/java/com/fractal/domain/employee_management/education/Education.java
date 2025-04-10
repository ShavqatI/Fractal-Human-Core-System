package com.fractal.domain.employee_management.education;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import com.fractal.domain.employee_management.education.document_type.EducationDocumentType;
import com.fractal.domain.employee_management.education.type.EducationType;
import com.fractal.domain.employee_management.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Table(name = "education", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}

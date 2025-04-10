package com.fractal.domain.employee_management.identification_document;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.identification_document.type.IdentificationDocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Table(name = "identification_document",schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocument extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "identification_type_id", referencedColumnName = "id")
    private IdentificationDocumentType identificationDocumentType;


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

}

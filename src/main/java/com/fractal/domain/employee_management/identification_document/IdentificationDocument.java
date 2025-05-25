package com.fractal.domain.employee_management.identification_document;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.employee_management.identification_document.type.IdentificationDocumentType;
import com.fractal.domain.organization_management.department.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    private Integer number;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate ;

    @Column(name = "term_in_years")
    private Integer termInYears;

    @Column(name = "issue_organization")
    private String issueOrganization;

    @Column(name = "issue_organization_address")
    private String issueOrganizationAddress;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "identificationDocument",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<IdentificationDocumentResource> resources;

    public void addResource(IdentificationDocumentResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setIdentificationDocument(this);
        resources.add(resource);
    }
    public void removeResource(IdentificationDocumentResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

}

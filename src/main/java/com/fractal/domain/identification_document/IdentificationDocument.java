package com.fractal.domain.identification_document;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.identification_document.type.IdentificationDocumentType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "identification_document",schema = "identification_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class IdentificationDocument extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "identificationDocument",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IdentificationDocumentResource> resources = new ArrayList<>();

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

package com.fractal.domain.agreement;


import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.agreement.resource.AgreementResource;
import com.fractal.domain.agreement.type.AgreementType;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agreement", schema = "employee_schema", catalog = "fractal")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@SuperBuilder
@NoArgsConstructor
public class Agreement extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agreement_type_id")
    protected AgreementType agreementType;

    @Column(name = "number")
    private String number;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgreementResource> resources = new ArrayList<>();

    public void addResource(AgreementResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setAgreement(this);
        resources.add(resource);
    }

    public void removeResource(AgreementResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }
}

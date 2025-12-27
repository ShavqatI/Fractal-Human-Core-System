package com.fractal.domain.agreement;


import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.agreement.resource.AgreementResource;
import com.fractal.domain.agreement.type.AgreementType;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agreement", schema = "agreement_schema", catalog = "fractal")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Agreement extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agreement_type_id")
    protected AgreementType agreementType;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "number")
    private String number;

    @Column(name = "start_date")
    protected LocalDate startDate;

    @Column(name = "end_date")
    protected LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    protected Status status;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<AgreementResource> resources = new ArrayList<>();

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

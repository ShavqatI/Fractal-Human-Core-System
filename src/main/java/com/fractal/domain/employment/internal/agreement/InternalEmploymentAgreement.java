package com.fractal.domain.employment.internal.agreement;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.agreement.resource.InternalEmploymentAgreementResource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "internal_employment_agreement", schema = "employment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InternalEmploymentAgreement extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internal_employment_id",referencedColumnName = "id")
    private InternalEmployment internalEmployment;

    @Column(name = "number")
    private String number;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "agreement",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<InternalEmploymentAgreementResource> resources = new ArrayList<>();

    public void addResource(InternalEmploymentAgreementResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setInternalEmploymentAgreement(this);
        resources.add(resource);
    }
    public void removeResource(InternalEmploymentAgreementResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }
}

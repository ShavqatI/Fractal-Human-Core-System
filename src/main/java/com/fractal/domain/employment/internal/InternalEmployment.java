package com.fractal.domain.employment.internal;

import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.internal.agreement.InternalEmploymentAgreement;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.position.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "internal_employment", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InternalEmployment extends Employment {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @OneToMany(mappedBy = "internalEmployment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<InternalEmploymentAgreement> agreements = new ArrayList<>();

    @OneToMany(mappedBy = "internalEmployment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CompensationComponent> compensationComponents = new ArrayList<>();

    public void addAgreement(InternalEmploymentAgreement agreement) {
        if (agreements == null) agreements = new ArrayList<>();
        agreement.setInternalEmployment(this);
        agreements.add(agreement);
    }

    public void removeAgreement(InternalEmploymentAgreement agreement) {
        if (agreements != null && !agreements.isEmpty())
            agreements.remove(agreement);
    }
    public void addCompensationComponent(CompensationComponent compensationComponent) {
        if (compensationComponents == null) compensationComponents = new ArrayList<>();
        compensationComponent.setInternalEmployment(this);
        compensationComponents.add(compensationComponent);
    }

    public void removeCompensationComponent(CompensationComponent compensationComponent) {
        if (compensationComponents != null && !compensationComponents.isEmpty())
            compensationComponents.remove(compensationComponent);
    }

}

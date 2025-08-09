package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employment.EmploymentHistory;
import com.fractal.domain.employee_management.employment.agreement.resource.AgreementResource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agreement", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agreement extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_history_id",referencedColumnName = "id")
    private EmploymentHistory employmentHistory;

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

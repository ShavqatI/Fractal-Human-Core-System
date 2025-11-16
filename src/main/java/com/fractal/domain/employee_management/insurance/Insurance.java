package com.fractal.domain.employee_management.insurance;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.insurance.coverage.InsuranceCoverage;
import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.insurance.type.InsuranceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "insurance", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_type_id", referencedColumnName = "id")
    private InsuranceType insuranceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_provider_id", referencedColumnName = "id")
    private InsuranceProvider insuranceProvider;

    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<InsuranceCoverage> coverages = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Transactional
    public void addCoverage(InsuranceCoverage coverage) {
        if (coverages == null) coverages = new ArrayList<>();
        coverage.setInsurance(this);
        coverages.add(coverage);
    }

    @Transactional
    public void removeCoverage(InsuranceCoverage coverage) {
        if (coverages != null && !coverages.isEmpty())
            coverages.remove(coverage);
    }
}

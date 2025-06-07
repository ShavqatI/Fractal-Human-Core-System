package com.fractal.domain.employee_management.military_service;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.military_service.resource.MilitaryServiceResource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "military_data", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MilitaryService extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "category_fund")
    private String categoryFund;

    @Column(name = "address")
    private String address;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "education",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MilitaryServiceResource> resources = new ArrayList<>();

    public void addResource(MilitaryServiceResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setMilitaryService(this);
        resources.add(resource);
    }
    public void removeResource(MilitaryServiceResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

}

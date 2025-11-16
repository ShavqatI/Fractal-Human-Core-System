package com.fractal.domain.military_service;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.military_service.resource.MilitaryServiceResource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "military_service", schema = "military_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class MilitaryService extends AbstractEntity {

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

    @OneToMany(mappedBy = "militaryService", cascade = CascadeType.ALL, orphanRemoval = true)
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

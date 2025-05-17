package com.fractal.domain.recruitment.vacncy;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.position.Position;
import com.fractal.domain.recruitment.candidate.Candidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacancy", schema = "recruitment_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @OneToMany(mappedBy = "vacancy",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Candidate> candidates = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "description")
    private String description;

    @Column(name = "open_date")
    private Date openDate;

    @Column(name = "close_date")
    private Date closeDate;

    @Column(name = "salary")
    private Double salary;



}




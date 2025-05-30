package com.fractal.domain.recruitment.vacncy;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.position.Position;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.vacncy.skill.Skill;
import com.fractal.domain.recruitment.vacncy.experience.Experience;
import com.fractal.domain.recruitment.vacncy.duty.Duty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacancy", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Vacancy extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @Column(name = "description")
    private String description;

    @Column(name = "open_date")
    private Date openDate;

    @Column(name = "close_date")
    private Date closeDate;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "vacancy",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "vacancy",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "vacancy",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Duty> responsibilities = new ArrayList<>();

    @OneToMany(mappedBy = "vacancy",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Candidate> candidates = new ArrayList<>();



}




package com.fractal.domain.employment.work_experience;


import com.fractal.domain.abstraction.AbstractEmploymentHistory;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_experience", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class WorkExperience extends AbstractEmploymentHistory {

    @ManyToOne
    @JoinColumn(name ="country_id", referencedColumnName = "id")
    protected Country country;

    @Column(name = "location")
    private String location;

    @Column(name = "organization")
    private String organization;

    @Column(name = "department")
    private String department;

    @Column(name = "division")
    private String division;

    @Column(name = "position")
    private String position;

    @Column(name = "responsibilities", columnDefinition = "TEXT")
    private String responsibilities;

    @Column(name = "achievements", columnDefinition = "TEXT")
    private String achievements;

    @Column(name = "leave_reason", columnDefinition = "TEXT")
    private String leaveReason;

    /*@OneToMany(mappedBy = "workExperience", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<SeparationReason> separationReasons = new ArrayList<>();


    @Transactional
    public void addSeparationReason(SeparationReason separationReason) {
        if (separationReasons == null) separationReasons = new ArrayList<>();
        separationReason.setWorkExperience(this);
        separationReasons.add(separationReason);
    }

    @Transactional
    public void removeSeparationReason(SeparationReason separationReason) {
        if (separationReasons != null && !separationReasons.isEmpty())
            separationReasons.remove(separationReason);
    }*/

}

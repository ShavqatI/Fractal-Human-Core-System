package com.fractal.domain.employment.work_experience;


import com.fractal.domain.abstraction.AbstractEmploymentHistory;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


}

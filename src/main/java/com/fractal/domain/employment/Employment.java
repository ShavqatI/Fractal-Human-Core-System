package com.fractal.domain.employment;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.agreement.employment.EmploymentAgreement;
import com.fractal.domain.employment.punishment.Punishment;
import com.fractal.domain.employment.separation_reason.SeparationReason;
import com.fractal.domain.employment.state.EmploymentState;
import com.fractal.domain.employment.type.EmploymentType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employment", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Employment extends ApprovalWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @Column(name = "start_date")
    protected LocalDate startDate;

    @Column(name = "end_date")
    protected LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_type_id", referencedColumnName = "id")
    protected EmploymentType employmentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    protected Status status;

    @OneToMany(mappedBy = "employment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SeparationReason> separationReasons = new ArrayList<>();

    @OneToMany(mappedBy = "employment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Punishment> punishments = new ArrayList<>();

    @OneToMany(mappedBy = "employment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmploymentAgreement> agreements = new ArrayList<>();


    @OneToMany(mappedBy = "employment", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<EmploymentState> states = new ArrayList<>();


    public void addSeparationReason(SeparationReason separationReason) {
        if (separationReasons == null) separationReasons = new ArrayList<>();
        separationReason.setEmployment(this);
        separationReasons.add(separationReason);
    }


    public void removeSeparationReason(SeparationReason separationReason) {
        if (separationReasons != null && !separationReasons.isEmpty())
            separationReasons.remove(separationReason);
    }

    public void addPunishment(Punishment punishment) {
        if (punishments == null) punishments = new ArrayList<>();
        punishment.setEmployment(this);
        punishments.add(punishment);
    }


    public void removePunishment(Punishment punishment) {
        if (punishments != null && !punishments.isEmpty())
            punishments.remove(punishment);
    }

    public void addAgreement(EmploymentAgreement agreement) {
        if (agreements == null) agreements = new ArrayList<>();
        agreement.setEmployment(this);
        agreements.add(agreement);
    }

    public void removeAgreement(EmploymentAgreement agreement) {
        if (agreements != null && !agreements.isEmpty())
            agreements.remove(agreement);
    }


}

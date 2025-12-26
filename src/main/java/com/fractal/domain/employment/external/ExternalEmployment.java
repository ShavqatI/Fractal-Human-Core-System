package com.fractal.domain.employment.external;

import com.fractal.domain.employment.Employment;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "external_employment", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExternalEmployment extends Employment {

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
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

}

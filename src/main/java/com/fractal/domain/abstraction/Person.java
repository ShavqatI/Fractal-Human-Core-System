package com.fractal.domain.abstraction;

import com.fractal.domain.dictionary.gender.Gender;
import com.fractal.domain.dictionary.marital_status.MaritalStatus;
import com.fractal.domain.dictionary.nationality.Nationality;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class Person extends AbstractEntity {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "patronymic_name")
    private String patronymicName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "tin")
    private String tin;

    @Column(name = "ssn")
    private String ssn;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "marital_status_id", referencedColumnName = "id")
    private MaritalStatus maritalStatus;

    @ManyToOne
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    private Nationality nationality;

}

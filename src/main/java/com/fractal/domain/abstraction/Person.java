package com.fractal.domain.abstraction;

import com.fractal.domain.dictionary.Gender;
import com.fractal.domain.dictionary.MaritalStatus;
import com.fractal.domain.dictionary.Nationality;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@MappedSuperclass
@Data
public abstract class Person extends AbstractEntity {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "patronymic_name")
    private String patronymicName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "tin")
    private Long tin;

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

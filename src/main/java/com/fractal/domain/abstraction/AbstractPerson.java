package com.fractal.domain.abstraction;

import com.fractal.domain.dictionary.Gender;
import com.fractal.domain.dictionary.MaritalStatus;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@MappedSuperclass
@Data
public abstract class AbstractPerson extends AbstractEntity {

    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "patronymic_name")
    private String patronymicName;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;
    @Basic
    @Column(name = "tin")
    private Long tin;
    @Basic
    @Column(name = "ssn")
    private String ssn;
    @Basic
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "marital_status_id", referencedColumnName = "id")
    private MaritalStatus maritalStatus;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
}

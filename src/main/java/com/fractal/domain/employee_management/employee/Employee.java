package com.fractal.domain.employee_management.employee;

import com.fractal.domain.abstraction.Person;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.citizenship.Citizenship;
import com.fractal.domain.employee_management.education.Education;
import com.fractal.domain.employee_management.employment.EmploymentHistory;
import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.employee_management.military_service.MilitaryService;
import com.fractal.domain.employee_management.performance.Performance;
import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.subordinate.Subordinate;
import com.fractal.domain.employee_management.vacation.Vacation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<IdentificationDocument> identificationDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<EmploymentHistory> employmentHistories  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Performance> performances  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<BusinessTrip> businessTrips  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Vacation> vacations  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<MilitaryService> militaryServices  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Relative> relatives  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Education> educations   = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Citizenship> citizenships   = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Subordinate> subordinates   = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<EmployeeAddress> addresses   = new ArrayList<>();

   /* @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts   = new ArrayList<>();*/


}

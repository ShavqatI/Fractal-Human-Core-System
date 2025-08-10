package com.fractal.domain.employee_management.employee;

import com.fractal.domain.abstraction.Person;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;
import com.fractal.domain.employee_management.contact.EmployeeContact;
import com.fractal.domain.employee_management.education.Education;
import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.employee_management.employment.EmploymentHistory;
import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.employee_management.military_service.MilitaryService;
import com.fractal.domain.employee_management.performance.Performance;
import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.subordinate.Subordinate;
import com.fractal.domain.employee_management.vacation.Vacation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<IdentificationDocument> identificationDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<EmployeeCitizenship> citizenships = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<EmployeeAddress> addresses   = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<EmployeeContact> contacts   = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Education> educations   = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Relative> relatives  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<MilitaryService> militaryServices  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<EmploymentHistory> employmentHistories  = new ArrayList<>();

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EmployeeResource> resources = new ArrayList<>();


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Performance> performances  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<BusinessTrip> businessTrips  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Vacation> vacations  = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Subordinate> subordinates   = new ArrayList<>();


    public void addIdentificationDocument(IdentificationDocument identificationDocument) {
        if (identificationDocuments == null) identificationDocuments = new ArrayList<>();
        identificationDocument.setEmployee(this);
        identificationDocuments.add(identificationDocument);
    }
    public void removeIdentificationDocument(IdentificationDocument identificationDocument) {
        if (identificationDocuments != null && !identificationDocuments.isEmpty())
            identificationDocuments.remove(identificationDocument);
    }
    public void addCitizenship(EmployeeCitizenship employeeCitizenship) {
        if (citizenships == null) citizenships = new ArrayList<>();
        employeeCitizenship.setEmployee(this);
        citizenships.add(employeeCitizenship);
    }
    public void removeCitizenship(EmployeeCitizenship employeeCitizenship) {
        if (citizenships != null && !citizenships.isEmpty())
            citizenships.remove(employeeCitizenship);
    }

    public void addAddress(EmployeeAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setEmployee(this);
        addresses.add(address);
    }
    public void removeAddress(EmployeeAddress address) {
        if (addresses != null && !addresses.isEmpty())
            addresses.remove(address);
    }
    public void addContact(EmployeeContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setEmployee(this);
        contacts.add(contact);
    }
    public void removeContact(EmployeeContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }

    public void addEducation(Education education) {
        if (educations == null) educations = new ArrayList<>();
        education.setEmployee(this);
        educations.add(education);
    }
    public void removeEducation(Education education) {
        if (educations != null && !educations.isEmpty())
            educations.remove(education);
    }

    public void addRelative(Relative relative) {
        if (relatives == null) relatives = new ArrayList<>();
        relative.setEmployee(this);
        relatives.add(relative);
    }
    public void removeRelative(Relative relative) {
        if (relatives != null && !relatives.isEmpty())
            relatives.remove(relative);
    }
    public void addMilitaryService(MilitaryService militaryService) {
        if (militaryServices == null) militaryServices = new ArrayList<>();
        militaryService.setEmployee(this);
        militaryServices.add(militaryService);
    }
    public void removeMilitaryService(MilitaryService militaryService) {
        if (militaryServices != null && !militaryServices.isEmpty())
            militaryServices.remove(militaryService);
    }
    public void addEmploymentHistory(EmploymentHistory employmentHistory) {
        if (employmentHistories == null) employmentHistories = new ArrayList<>();
        employmentHistory.setEmployee(this);
        employmentHistories.add(employmentHistory);
    }
    public void removeEmploymentHistory(EmploymentHistory employmentHistory) {
        if (employmentHistories != null && !employmentHistories.isEmpty())
            employmentHistories.remove(employmentHistory);
    }
    public void addResource(EmployeeResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setEmployee(this);
        resources.add(resource);
    }
    public void removeResource(EmployeeResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }



}

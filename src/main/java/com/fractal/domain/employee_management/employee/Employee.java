package com.fractal.domain.employee_management.employee;

import com.fractal.domain.abstraction.Person;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;
import com.fractal.domain.employee_management.contact.EmployeeContact;
import com.fractal.domain.employee_management.education.EmployeeEducation;
import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.employee_management.employee.state.EmployeeState;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkill;
import com.fractal.domain.employee_management.military_service.EmployeeMilitaryService;
import com.fractal.domain.employee_management.performance.Performance;
import com.fractal.domain.employee_management.professional_experience.EmployeeProfessionalExperience;
import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.subordinate.Subordinate;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.vacation.Vacation;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee", schema = "employee_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

    @Column(name = "reviewed_date")
    private LocalDateTime reviewedDate;

    @ManyToOne
    @JoinColumn(name = "reviewed_user_id")
    private User reviewedUser;

    @Column(name = "approved_date")
    private LocalDateTime approvedDate;

    @ManyToOne
    @JoinColumn(name = "approved_user_id")
    private User approvedUser;

    @Column(name = "uuid")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeIdentificationDocument> identificationDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeCitizenship> citizenships = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeAddress> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeContact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeEducation> educations = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeLanguageSkill> languageSkills = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Relative> relatives = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeMilitaryService> militaryServices = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeEmployment> employments = new ArrayList<>();


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeResource> resources = new ArrayList<>();


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<Performance> performances = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<BusinessTrip> businessTrips = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<Vacation> vacations = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<VacationAccrual> vacationAccruals = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<Subordinate> subordinates = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmployeeProfessionalExperience> professionalExperiences = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<EmployeeState> states = new ArrayList<>();


    public void addIdentificationDocument(EmployeeIdentificationDocument identificationDocument) {
        if (identificationDocuments == null) identificationDocuments = new ArrayList<>();
        identificationDocument.setEmployee(this);
        identificationDocuments.add(identificationDocument);
    }

    public void removeIdentificationDocument(EmployeeIdentificationDocument identificationDocument) {
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

    public void addEducation(EmployeeEducation education) {
        if (educations == null) educations = new ArrayList<>();
        education.setEmployee(this);
        educations.add(education);
    }

    public void removeEducation(EmployeeEducation education) {
        if (educations != null && !educations.isEmpty())
            educations.remove(education);
    }

    public void addLanguageSkill(EmployeeLanguageSkill languageSkill) {
        if (languageSkills == null) languageSkills = new ArrayList<>();
        languageSkill.setEmployee(this);
        languageSkills.add(languageSkill);
    }

    public void removeLanguageSkill(EmployeeLanguageSkill languageSkill) {
        if (languageSkills != null && !languageSkills.isEmpty())
            languageSkills.remove(languageSkill);
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

    public void addMilitaryService(EmployeeMilitaryService militaryService) {
        if (militaryServices == null) militaryServices = new ArrayList<>();
        militaryService.setEmployee(this);
        militaryServices.add(militaryService);
    }

    public void removeMilitaryService(EmployeeMilitaryService militaryService) {
        if (militaryServices != null && !militaryServices.isEmpty())
            militaryServices.remove(militaryService);
    }

    public void addEmployment(EmployeeEmployment employment) {
        if (employments == null) employments = new ArrayList<>();
        employment.setEmployee(this);
        employments.add(employment);
    }

    public void removeEmployment(EmployeeEmployment employment) {
        if (employments != null && !employments.isEmpty())
            employments.remove(employment);
    }

    public void addResource(EmployeeResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setEmployee(this);
        resources.add(resource);
    }

    public void removeResource(EmployeeResource resource) {
        if (resources != null && !resources.isEmpty()) {
            resources.remove(resource);
        }
    }

    public void addProfessionalExperience(EmployeeProfessionalExperience professionalExperience) {
        if (professionalExperiences == null) professionalExperiences = new ArrayList<>();
        professionalExperience.setEmployee(this);
        professionalExperiences.add(professionalExperience);
    }

    public void removeProfessionalExperience(EmployeeProfessionalExperience professionalExperience) {
        if (professionalExperiences != null && !professionalExperiences.isEmpty())
            professionalExperiences.remove(professionalExperience);
    }
}

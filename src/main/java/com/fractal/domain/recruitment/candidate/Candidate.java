package com.fractal.domain.recruitment.candidate;


import com.fractal.domain.abstraction.Person;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;
import com.fractal.domain.employee_management.contact.EmployeeContact;
import com.fractal.domain.employee_management.education.EmployeeEducation;
import com.fractal.domain.organization_management.organization.address.OrganizationAddress;
import com.fractal.domain.organization_management.organization.contact.OrganizationContact;
import com.fractal.domain.recruitment.candidate.address.CandidateAddress;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;
import com.fractal.domain.recruitment.candidate.contact.CandidateContact;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
import com.fractal.domain.recruitment.vacncy.Vacancy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidate", schema = "recruitment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends Person {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacancy_id", referencedColumnName = "id")
    private Vacancy vacancy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CandidateCitizenship> citizenships = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CandidateAddress> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CandidateContact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private  List<CandidateEducation> educations = new ArrayList<>();

    @Transactional
    public void addCitizenship(CandidateCitizenship citizenship) {
        if (citizenships == null) citizenships = new ArrayList<>();
        citizenship.setCandidate(this);
        citizenships.add(citizenship);
    }
    @Transactional
    public void removeCitizenship(CandidateCitizenship citizenship) {
        if (citizenships != null && !citizenships.isEmpty())
            citizenships.remove(citizenship);
    }
    @Transactional
    public void addAddress(CandidateAddress address) {
        if (addresses == null) addresses = new ArrayList<>();
        address.setCandidate(this);
        addresses.add(address);
    }
    @Transactional
    public void removeAddress(CandidateAddress address) {
        if (addresses != null && !addresses.isEmpty()) {
            addresses.remove(address);
        }

    }
    @Transactional
    public void addContact(CandidateContact contact) {
        if (contacts == null) contacts = new ArrayList<>();
        contact.setCandidate(this);
        contacts.add(contact);
    }
    @Transactional
    public void removeContact(CandidateContact contact) {
        if (contacts != null && !contacts.isEmpty())
            contacts.remove(contact);
    }

    @Transactional
    public void addEducation(CandidateEducation education) {
        if (educations == null) educations = new ArrayList<>();
        education.setCandidate(this);
        educations.add(education);
    }
    @Transactional
    public void removeEducation(CandidateEducation education) {
        if (educations != null && !educations.isEmpty())
            educations.remove(education);
    }

}

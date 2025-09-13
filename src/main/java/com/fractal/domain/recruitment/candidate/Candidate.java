package com.fractal.domain.recruitment.candidate;


import com.fractal.domain.abstraction.Person;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.recruitment.candidate.address.CandidateAddress;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;
import com.fractal.domain.recruitment.candidate.contact.CandidateContact;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocument;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkill;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryService;
import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.recruitment.candidate.work_experience.CandidateWorkExperience;
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

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private  List<CandidateIdentificationDocument> identificationDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CandidateCitizenship> citizenships = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CandidateAddress> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CandidateContact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private  List<CandidateEducation> educations = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private  List<CandidateLanguageSkill> languageSkills = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private  List<CandidateWorkExperience> workExperiences = new ArrayList<>();

    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CandidateResource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private  List<CandidateMilitaryService> militaryServices = new ArrayList<>();

    @Transactional
    public void addIdentificationDocument(CandidateIdentificationDocument identificationDocument) {
        if (identificationDocuments == null) identificationDocuments = new ArrayList<>();
        identificationDocument.setCandidate(this);
        identificationDocuments.add(identificationDocument);
    }
    @Transactional
    public void removeIdentificationDocument(CandidateIdentificationDocument identificationDocument) {
        if (identificationDocuments != null && !identificationDocuments.isEmpty())
            identificationDocuments.remove(identificationDocument);
    }

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
    @Transactional
    public void addLanguageSkill(CandidateLanguageSkill languageSkill) {
        if (languageSkills == null) languageSkills = new ArrayList<>();
        languageSkill.setCandidate(this);
        languageSkills.add(languageSkill);
    }
    @Transactional
    public void removeLanguageSkill(CandidateLanguageSkill languageSkill) {
        if (languageSkills != null && !languageSkills.isEmpty())
            languageSkills.remove(languageSkill);
    }

    @Transactional
    public void addWorkExperience(CandidateWorkExperience workExperience) {
        if (workExperiences == null) workExperiences = new ArrayList<>();
        workExperience.setCandidate(this);
        workExperiences.add(workExperience);
    }
    @Transactional
    public void removeWorkExperience(CandidateWorkExperience workExperience) {
        if (workExperiences != null && !workExperiences.isEmpty())
            workExperiences.remove(workExperience);
    }

    public void addResource(CandidateResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setCandidate(this);
        resources.add(resource);
    }
    public void removeResource(CandidateResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

    @Transactional
    public void addMilitaryService(CandidateMilitaryService militaryService) {
        if (militaryServices == null) militaryServices = new ArrayList<>();
        militaryService.setCandidate(this);
        militaryServices.add(militaryService);
    }
    @Transactional
    public void removeMilitaryService(CandidateMilitaryService militaryService) {
        if (militaryServices != null && !militaryServices.isEmpty())
            militaryServices.remove(militaryService);
    }

}

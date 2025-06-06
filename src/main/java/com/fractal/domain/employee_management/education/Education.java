package com.fractal.domain.employee_management.education;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.education.accreditation_status.AccreditationStatus;
import com.fractal.domain.employee_management.education.degree_type.DegreeType;
import com.fractal.domain.employee_management.education.document_type.EducationDocumentType;
import com.fractal.domain.employee_management.education.grade_point_average.GradePointAverage;
import com.fractal.domain.employee_management.education.resource.EducationResource;
import com.fractal.domain.employee_management.education.type.EducationType;
import com.fractal.domain.employee_management.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "education", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Education extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "education_type_id", referencedColumnName = "id")
    private EducationType educationType;

    @ManyToOne
    @JoinColumn(name = "education_document_type_id", referencedColumnName = "id")
    private EducationDocumentType educationDocumentType;


    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "institution_address")
    private String institutionAddress;

    @Column(name = "is_foreign_institution")
    private Boolean isForeignInstitution;

    @Column(name = "specialization")
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "degree_type_id", referencedColumnName = "id")
    private DegreeType degreeType;

    @ManyToOne
    @JoinColumn(name = "grade_point_average_id", referencedColumnName = "id")
    private GradePointAverage gradePointAverage;

    @ManyToOne
    @JoinColumn(name = "accreditation_status_id", referencedColumnName = "id")
    private AccreditationStatus accreditationStatus;

    @Column(name = "document_verified")
    private Boolean documentVerified;

    @Column(name = "verification_notes")
    private String verificationNotes;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "education",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EducationResource> resources = new ArrayList<>();

    public void addResource(EducationResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setEducation(this);
        resources.add(resource);
    }
    public void removeResource(EducationResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

}

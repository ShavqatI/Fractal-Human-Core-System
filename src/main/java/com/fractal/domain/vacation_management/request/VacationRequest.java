package com.fractal.domain.vacation_management.request;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.vacation_management.request.education.VacationRequestEducation;
import com.fractal.domain.vacation_management.request.medical_info.VacationRequestMedicalInfo;
import com.fractal.domain.vacation_management.request.responsibility.VacationRequestResponsibility;
import com.fractal.domain.vacation_management.request.state.VacationRequestState;
import com.fractal.domain.vacation_management.type.VacationType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacation_request", schema = "vacation_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequest extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "successor_employee_id", referencedColumnName = "id")
    private Employee successorEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_type_id", referencedColumnName = "id")
    private VacationType vacationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "days")
    private Integer days;

    @Column(name = "working_days")
    private Integer workingDays;

    @Column(name = "working_date")
    private LocalDate workingDate;

    @Column(name = "description")
    private String description;

    @Column(name = "canceled_date")
    private LocalDateTime canceledDate;

    @ManyToOne
    @JoinColumn(name = "canceled_user_id")
    private User canceledUser;

    @Column(name = "canceled_reason")
    private String canceledReason;

    @OneToMany(mappedBy = "vacationRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VacationRequestResponsibility> responsibilities = new ArrayList<>();

    @OneToMany(mappedBy = "vacationRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VacationRequestState> states = new ArrayList<>();

    @OneToMany(mappedBy = "vacationRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VacationRequestMedicalInfo> medicalInfos = new ArrayList<>();

    @OneToMany(mappedBy = "vacationRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VacationRequestEducation> educations = new ArrayList<>();

    public void addResponsibility(VacationRequestResponsibility responsibility) {
        if (responsibilities == null) responsibilities = new ArrayList<>();
        responsibility.setVacationRequest(this);
        responsibilities.add(responsibility);
    }

    public void removeResponsibility(VacationRequestResponsibility responsibility) {
        if (responsibilities != null && !responsibilities.isEmpty())
            responsibilities.remove(responsibility);
    }

    public void addMedicalInfo(VacationRequestMedicalInfo medicalInfo) {
        if (medicalInfos == null) medicalInfos = new ArrayList<>();
        medicalInfo.setVacationRequest(this);
        medicalInfos.add(medicalInfo);
    }

    public void removeMedicalInfo(VacationRequestMedicalInfo medicalInfo) {
        if (medicalInfos != null && !medicalInfos.isEmpty())
            medicalInfos.remove(medicalInfo);
    }
    public void addEducation(VacationRequestEducation education) {
        if (educations == null) educations = new ArrayList<>();
        education.setVacationRequest(this);
        educations.add(education);
    }

    public void removeEducation(VacationRequestEducation education) {
        if (educations != null && !educations.isEmpty())
            educations.remove(education);
    }

}

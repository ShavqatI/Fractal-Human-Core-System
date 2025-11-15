package com.fractal.domain.vacation_management.request;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.vacation_management.request.responsibility.VacationRequestResponsibility;
import com.fractal.domain.vacation_management.request.state.VacationRequestState;
import com.fractal.domain.vacation_management.type.VacationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacation_request", schema = "vacation_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequest extends AbstractEntity {

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

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "vacationRequest", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<VacationRequestResponsibility> responsibilities = new ArrayList<>();

    @OneToMany(mappedBy = "vacationRequest", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<VacationRequestState> states = new ArrayList<>();

    public void addResponsibility(VacationRequestResponsibility responsibility) {
        if (responsibilities == null) responsibilities = new ArrayList<>();
        responsibility.setVacationRequest(this);
        responsibilities.add(responsibility);
    }
    public void removeResponsibility(VacationRequestResponsibility responsibility) {
        if (responsibilities != null && !responsibilities.isEmpty())
            responsibilities.remove(responsibility);
    }

}

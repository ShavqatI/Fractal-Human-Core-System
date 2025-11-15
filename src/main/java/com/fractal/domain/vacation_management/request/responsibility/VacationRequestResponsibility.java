package com.fractal.domain.vacation_management.request.responsibility;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.vacation_management.request.VacationRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "vacation_request_responsibility", schema = "vacation_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequestResponsibility extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_request_id", referencedColumnName = "id")
    private VacationRequest vacationRequest;

    private String responsibility;


}

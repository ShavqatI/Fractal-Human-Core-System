package com.fractal.domain.vacation_management.request.state;

import com.fractal.domain.state.EntityState;
import com.fractal.domain.vacation_management.request.VacationRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "vacation_request_state", schema = "state_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequestState extends EntityState {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_request_id", referencedColumnName = "id")
    private VacationRequest vacationRequest;
}

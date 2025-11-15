package com.fractal.domain.vacation_management.request.state;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.state.EntityState;
import com.fractal.domain.vacation_management.request.VacationRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


public record VacationRequestStateResponse (
        Long id,
        StatusCompactResponse status,
        LocalDateTime createdDate

){

}

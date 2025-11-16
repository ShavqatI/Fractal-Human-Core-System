package com.fractal.domain.recruitment.vacncy.duty;

import com.fractal.domain.recruitment.vacncy.duty.dto.DutyRequest;
import com.fractal.domain.recruitment.vacncy.duty.dto.DutyResponse;

public interface DutyService {

    DutyResponse toDTO(Duty duty);

    Duty toEntity(DutyRequest dto);

    Duty findById(Long id);

    Duty update(Long id, DutyRequest dto);

    void delete(Duty duty);
}

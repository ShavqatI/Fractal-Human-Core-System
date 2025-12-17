package com.fractal.domain.employment.punishment.mapper;

import com.fractal.domain.employment.punishment.Punishment;
import com.fractal.domain.employment.punishment.dto.PunishmentCompactResponse;
import com.fractal.domain.employment.punishment.dto.PunishmentRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentResponse;

public interface PunishmentMapperService {
    PunishmentResponse toDTO(Punishment punishment);
    PunishmentCompactResponse toCompactDTO(Punishment punishment);

    Punishment toEntity(PunishmentRequest dto);

    Punishment toEntity(Punishment punishment, PunishmentRequest dto);
}



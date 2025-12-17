package com.fractal.domain.employment.punishment.type;

import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeCompactResponse;
import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeRequest;
import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeResponse;

import java.util.List;

public interface PunishmentTypeService {

    PunishmentType create(PunishmentTypeRequest dto);

    List<PunishmentType> getAll();

    PunishmentType getByCode(String code);

    PunishmentType getById(Long id);

    PunishmentType update(Long id, PunishmentTypeRequest dto);

    void deleteById(Long id);

    PunishmentTypeResponse toDTO(PunishmentType punishmentType);

    PunishmentTypeCompactResponse toCompactDTO(PunishmentType punishmentType);
}

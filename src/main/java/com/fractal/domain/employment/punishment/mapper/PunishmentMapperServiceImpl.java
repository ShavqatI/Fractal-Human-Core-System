package com.fractal.domain.employment.punishment.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.punishment.Punishment;
import com.fractal.domain.employment.punishment.dto.PunishmentCompactResponse;
import com.fractal.domain.employment.punishment.dto.PunishmentRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentResponse;
import com.fractal.domain.employment.punishment.type.PunishmentTypeService;
import com.fractal.domain.employment.separation_reason_type.SeparationReasonTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PunishmentMapperServiceImpl implements PunishmentMapperService {

    private final PunishmentTypeService punishmentTypeService;
    private final StatusService statusService;

    @Override
    public PunishmentResponse toDTO(Punishment punishment) {
        return new PunishmentResponse(
                punishment.getId(),
                punishmentTypeService.toDTO(punishment.getPunishmentType()),
                punishment.getDescription(),
                punishment.getAmount(),
                punishment.getStartDate(),
                punishment.getEndDate(),
                punishment.getCanceledDate(),
                punishment.getCanceledReason(),
                statusService.toCompactDTO(punishment.getStatus()),
                punishment.getCreatedDate()
        );
    }

    @Override
    public PunishmentCompactResponse toCompactDTO(Punishment punishment) {
        return new PunishmentCompactResponse(
                punishment.getId(),
                punishmentTypeService.toDTO(punishment.getPunishmentType()),
                punishment.getDescription(),
                punishment.getAmount(),
                punishment.getStartDate(),
                punishment.getEndDate(),
                punishment.getCanceledDate(),
                punishment.getCanceledReason(),
                statusService.toCompactDTO(punishment.getStatus()),
                punishment.getCreatedDate()
        );
    }



    @Override
    public Punishment toEntity(PunishmentRequest dto) {
        var punishment = mapToEntity(new Punishment(), dto);
        punishment.setStatus(statusService.getByCode("CREATE"));
        return punishment;
    }

    @Override
    public Punishment toEntity(Punishment punishment, PunishmentRequest dto) {
        return mapToEntity(punishment, dto);
    }

    private Punishment mapToEntity(Punishment punishment, PunishmentRequest dto) {
        punishment.setPunishmentType(punishmentTypeService.getById(dto.punishmentTypeId()));
        punishment.setDescription(punishment.getDescription());
        punishment.setAmount(dto.amount());
        punishment.setStartDate(dto.startDate());
        punishment.setEndDate(dto.endDate());
        return punishment;

    }


}

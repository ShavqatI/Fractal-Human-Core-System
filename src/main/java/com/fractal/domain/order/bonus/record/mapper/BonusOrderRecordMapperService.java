package com.fractal.domain.order.bonus.record.mapper;

import com.fractal.domain.order.bonus.record.BonusOrderRecord;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordRequest;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordResponse;

public interface BonusOrderRecordMapperService {
    BonusOrderRecordResponse toDTO(BonusOrderRecord record);

    BonusOrderRecord toEntity(BonusOrderRecordRequest dto);

    BonusOrderRecord toEntity(BonusOrderRecord record, BonusOrderRecordRequest dto);
}



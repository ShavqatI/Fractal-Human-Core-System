package com.fractal.domain.order.bonus.record;

import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordRequest;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordResponse;

import java.util.List;

public interface BonusOrderRecordService {

    BonusOrderRecord create(Long orderId, BonusOrderRecordRequest dto);

    List<BonusOrderRecord> getAllByBonusOrderId(Long orderId);

    BonusOrderRecord getById(Long orderId, Long id);

    BonusOrderRecord update(Long orderId, Long id, BonusOrderRecordRequest dto);

    void delete(Long orderId, Long id);

    BonusOrderRecordResponse toDTO(BonusOrderRecord record);

}

package com.fractal.domain.order.employment.record;

import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordResponse;

import java.util.List;

public interface InternalEmploymentOrderRecordService {

    InternalEmploymentOrderRecord create(Long orderId, InternalEmploymentOrderRecordRequest dto);

    List<InternalEmploymentOrderRecord> getAllByInternalEmploymentOrderId(Long orderId);

    InternalEmploymentOrderRecord getById(Long orderId, Long id);

    InternalEmploymentOrderRecord update(Long orderId, Long id, InternalEmploymentOrderRecordRequest dto);

    void delete(Long orderId, Long id);

    InternalEmploymentOrderRecordResponse toDTO(InternalEmploymentOrderRecord record);

}

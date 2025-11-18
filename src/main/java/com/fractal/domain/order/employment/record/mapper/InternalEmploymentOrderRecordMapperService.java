package com.fractal.domain.order.employment.record.mapper;

import com.fractal.domain.order.employment.record.InternalEmploymentOrderRecord;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordResponse;

public interface InternalEmploymentOrderRecordMapperService {
    InternalEmploymentOrderRecordResponse toDTO(InternalEmploymentOrderRecord record);

    InternalEmploymentOrderRecord toEntity(InternalEmploymentOrderRecordRequest dto);

    InternalEmploymentOrderRecord toEntity(InternalEmploymentOrderRecord record, InternalEmploymentOrderRecordRequest dto);
}



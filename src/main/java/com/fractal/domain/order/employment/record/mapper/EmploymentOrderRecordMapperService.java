package com.fractal.domain.order.employment.record.mapper;

import com.fractal.domain.order.employment.record.EmploymentOrderRecord;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordResponse;

public interface EmploymentOrderRecordMapperService {
    EmploymentOrderRecordResponse toDTO(EmploymentOrderRecord record);

    EmploymentOrderRecord toEntity(EmploymentOrderRecordRequest dto);

    EmploymentOrderRecord toEntity(EmploymentOrderRecord record, EmploymentOrderRecordRequest dto);
}



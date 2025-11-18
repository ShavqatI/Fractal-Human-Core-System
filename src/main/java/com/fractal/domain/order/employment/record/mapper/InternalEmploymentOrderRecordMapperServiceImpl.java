package com.fractal.domain.order.employment.record.mapper;

import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.order.employment.record.InternalEmploymentOrderRecord;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InternalEmploymentOrderRecordMapperServiceImpl implements InternalEmploymentOrderRecordMapperService {

    private final InternalEmploymentService employmentService;

    @Override
    public InternalEmploymentOrderRecordResponse toDTO(InternalEmploymentOrderRecord record) {
        return new InternalEmploymentOrderRecordResponse(
                record.getId(),
                employmentService.toDTO(record.getEmployment()),
                record.getCreatedDate()
        );
    }

    @Override
    public InternalEmploymentOrderRecord toEntity(InternalEmploymentOrderRecordRequest dto) {
        return mapToEntity(new InternalEmploymentOrderRecord(), dto);
    }

    @Override
    public InternalEmploymentOrderRecord toEntity(InternalEmploymentOrderRecord record, InternalEmploymentOrderRecordRequest dto) {
        return mapToEntity(record, dto);
    }

    private InternalEmploymentOrderRecord mapToEntity(InternalEmploymentOrderRecord record, InternalEmploymentOrderRecordRequest dto) {
        record.setEmployment(employmentService.getById(dto.employmentId()));
        return record;
    }

}

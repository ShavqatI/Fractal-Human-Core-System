package com.fractal.domain.order.bonus.record.mapper;

import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.order.bonus.record.BonusOrderRecord;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordRequest;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BonusOrderRecordMapperServiceImpl implements BonusOrderRecordMapperService {

    private final EmployeeEmploymentService employmentService;

    @Override
    public BonusOrderRecordResponse toDTO(BonusOrderRecord record) {
        return new BonusOrderRecordResponse(
                record.getId(),
                employmentService.toDTO(record.getEmployment()),
                record.getCreatedDate()
        );
    }

    @Override
    public BonusOrderRecord toEntity(BonusOrderRecordRequest dto) {
        return mapToEntity(new BonusOrderRecord(), dto);
    }

    @Override
    public BonusOrderRecord toEntity(BonusOrderRecord record, BonusOrderRecordRequest dto) {
        return mapToEntity(record, dto);
    }

    private BonusOrderRecord mapToEntity(BonusOrderRecord record, BonusOrderRecordRequest dto) {
        record.setEmployment(employmentService.getById(dto.employmentId()));
        return record;
    }

}

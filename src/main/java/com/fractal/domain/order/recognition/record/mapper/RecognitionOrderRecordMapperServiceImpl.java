package com.fractal.domain.order.recognition.record.mapper;

import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.order.recognition.record.RecognitionOrderRecord;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordRequest;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RecognitionOrderRecordMapperServiceImpl implements RecognitionOrderRecordMapperService {

    private final EmployeeEmploymentService employmentService;

    @Override
    public RecognitionOrderRecordResponse toDTO(RecognitionOrderRecord record) {
        return new RecognitionOrderRecordResponse(
                record.getId(),
                employmentService.toDTO(record.getEmployment()),
                record.getCreatedDate()
        );
    }

    @Override
    public RecognitionOrderRecord toEntity(RecognitionOrderRecordRequest dto) {
        return mapToEntity(new RecognitionOrderRecord(), dto);
    }

    @Override
    public RecognitionOrderRecord toEntity(RecognitionOrderRecord record, RecognitionOrderRecordRequest dto) {
        return mapToEntity(record, dto);
    }

    private RecognitionOrderRecord mapToEntity(RecognitionOrderRecord record, RecognitionOrderRecordRequest dto) {
        record.setEmployment(employmentService.getById(dto.employmentId()));
        return record;
    }

}

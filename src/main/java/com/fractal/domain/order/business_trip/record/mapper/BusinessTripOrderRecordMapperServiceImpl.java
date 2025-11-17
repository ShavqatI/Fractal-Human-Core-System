package com.fractal.domain.order.business_trip.record.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.order.business_trip.record.BusinessTripOrderRecord;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordRequest;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BusinessTripOrderRecordMapperServiceImpl implements BusinessTripOrderRecordMapperService {

    private final BusinessTripService businessTripService;

    @Override
    public BusinessTripOrderRecordResponse toDTO(BusinessTripOrderRecord record) {
        return new BusinessTripOrderRecordResponse(
                record.getId(),
                businessTripService.toDTO(record.getBusinessTrip()),
                record.getCreatedDate()
        );
    }

    @Override
    public BusinessTripOrderRecord toEntity(BusinessTripOrderRecordRequest dto) {
        return mapToEntity(new BusinessTripOrderRecord(), dto);
    }

    @Override
    public BusinessTripOrderRecord toEntity(BusinessTripOrderRecord record, BusinessTripOrderRecordRequest dto) {
        return mapToEntity(record, dto);
    }

    private BusinessTripOrderRecord mapToEntity(BusinessTripOrderRecord record, BusinessTripOrderRecordRequest dto) {
        record.setBusinessTrip(businessTripService.getById(dto.businessTripId()));
        return record;
    }

}

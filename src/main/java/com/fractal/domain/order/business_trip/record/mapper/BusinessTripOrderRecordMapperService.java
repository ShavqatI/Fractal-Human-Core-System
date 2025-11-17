package com.fractal.domain.order.business_trip.record.mapper;

import com.fractal.domain.order.business_trip.record.BusinessTripOrderRecord;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordRequest;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordResponse;

public interface BusinessTripOrderRecordMapperService {
    BusinessTripOrderRecordResponse toDTO(BusinessTripOrderRecord record);

    BusinessTripOrderRecord toEntity(BusinessTripOrderRecordRequest dto);

    BusinessTripOrderRecord toEntity(BusinessTripOrderRecord record, BusinessTripOrderRecordRequest dto);
}



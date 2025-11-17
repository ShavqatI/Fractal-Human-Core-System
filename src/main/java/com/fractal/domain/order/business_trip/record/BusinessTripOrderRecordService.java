package com.fractal.domain.order.business_trip.record;

import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordRequest;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordResponse;

import java.util.List;

public interface BusinessTripOrderRecordService {

    BusinessTripOrderRecord create(Long orderId, BusinessTripOrderRecordRequest dto);

    List<BusinessTripOrderRecord> getAllByBusinessTripOrderId(Long orderId);

    BusinessTripOrderRecord getById(Long orderId, Long id);

    BusinessTripOrderRecord update(Long orderId, Long id, BusinessTripOrderRecordRequest dto);

    void delete(Long orderId, Long id);

    BusinessTripOrderRecordResponse toDTO(BusinessTripOrderRecord record);

}

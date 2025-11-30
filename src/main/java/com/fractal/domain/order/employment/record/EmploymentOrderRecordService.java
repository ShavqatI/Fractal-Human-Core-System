package com.fractal.domain.order.employment.record;

import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordResponse;

import java.util.List;

public interface EmploymentOrderRecordService {

    EmploymentOrderRecord create(Long orderId, EmploymentOrderRecordRequest dto);

    List<EmploymentOrderRecord> getAllByInternalEmploymentOrderId(Long orderId);

    EmploymentOrderRecord getById(Long orderId, Long id);

    EmploymentOrderRecord update(Long orderId, Long id, EmploymentOrderRecordRequest dto);

    void delete(Long orderId, Long id);

    EmploymentOrderRecordResponse toDTO(EmploymentOrderRecord record);

}

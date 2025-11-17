package com.fractal.domain.order.business_trip.record;

import com.fractal.domain.order.business_trip.BusinessTripOrderService;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordRequest;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordResponse;
import com.fractal.domain.order.business_trip.record.mapper.BusinessTripOrderRecordMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripOrderRecordServiceImpl implements BusinessTripOrderRecordService {

    private final BusinessTripOrderRecordRepository recordRepository;
    private final BusinessTripOrderRecordMapperService mapperService;
    private final BusinessTripOrderService businessTripOrderService;


    @Override
    @Transactional
    public BusinessTripOrderRecord create(Long orderId, BusinessTripOrderRecordRequest dto) {
        var order = businessTripOrderService.getById(orderId);
        var record = mapperService.toEntity(dto);
        order.addRecord(record);
        businessTripOrderService.save(order);
        return record;
    }

    @Override
    public List<BusinessTripOrderRecord> getAllByBusinessTripOrderId(Long orderId) {
        return recordRepository.findAllByBusinessTripOrderId(orderId);
    }

    @Override
    public BusinessTripOrderRecord getById(Long orderId, Long id) {
        return recordRepository.findByBusinessTripOrderIdAndId(orderId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public BusinessTripOrderRecord update(Long orderId, Long id, BusinessTripOrderRecordRequest dto) {
        var order = businessTripOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        record = recordRepository.save(mapperService.toEntity(record, dto));
        businessTripOrderService.save(order);
        return record;
    }

    @Override
    @Transactional
    public void delete(Long orderId, Long id) {
        var order = businessTripOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order.removeRecord(record);
        businessTripOrderService.save(order);
    }

    @Override
    public BusinessTripOrderRecordResponse toDTO(BusinessTripOrderRecord record) {
        return mapperService.toDTO(record);
    }


}

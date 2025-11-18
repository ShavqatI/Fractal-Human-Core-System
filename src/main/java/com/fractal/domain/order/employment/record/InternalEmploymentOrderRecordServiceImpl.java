package com.fractal.domain.order.employment.record;

import com.fractal.domain.order.employment.InternalEmploymentOrderService;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordResponse;
import com.fractal.domain.order.employment.record.mapper.InternalEmploymentOrderRecordMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalEmploymentOrderRecordServiceImpl implements InternalEmploymentOrderRecordService {

    private final InternalEmploymentOrderRecordRepository recordRepository;
    private final InternalEmploymentOrderRecordMapperService mapperService;
    private final InternalEmploymentOrderService internalEmploymentOrderService;


    @Override
    @Transactional
    public InternalEmploymentOrderRecord create(Long orderId, InternalEmploymentOrderRecordRequest dto) {
        var order = internalEmploymentOrderService.getById(orderId);
        var record = mapperService.toEntity(dto);
        order.addRecord(record);
        internalEmploymentOrderService.save(order);
        return record;
    }

    @Override
    public List<InternalEmploymentOrderRecord> getAllByInternalEmploymentOrderId(Long orderId) {
        return recordRepository.findAllByInternalEmploymentOrderId(orderId);
    }

    @Override
    public InternalEmploymentOrderRecord getById(Long orderId, Long id) {
        return recordRepository.findByInternalEmploymentOrderIdAndId(orderId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InternalEmploymentOrderRecord update(Long orderId, Long id, InternalEmploymentOrderRecordRequest dto) {
        var order = internalEmploymentOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        record = recordRepository.save(mapperService.toEntity(record, dto));
        internalEmploymentOrderService.save(order);
        return record;
    }

    @Override
    @Transactional
    public void delete(Long orderId, Long id) {
        var order = internalEmploymentOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order.removeRecord(record);
        internalEmploymentOrderService.save(order);
    }

    @Override
    public InternalEmploymentOrderRecordResponse toDTO(InternalEmploymentOrderRecord record) {
        return mapperService.toDTO(record);
    }


}

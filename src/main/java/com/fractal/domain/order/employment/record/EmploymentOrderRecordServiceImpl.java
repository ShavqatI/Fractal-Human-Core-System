package com.fractal.domain.order.employment.record;

import com.fractal.domain.order.employment.EmploymentOrderService;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordResponse;
import com.fractal.domain.order.employment.record.mapper.EmploymentOrderRecordMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentOrderRecordServiceImpl implements EmploymentOrderRecordService {

    private final EmploymentOrderRecordRepository recordRepository;
    private final EmploymentOrderRecordMapperService mapperService;
    private final EmploymentOrderService employmentOrderService;


    @Override
    @Transactional
    public EmploymentOrderRecord create(Long orderId, EmploymentOrderRecordRequest dto) {
        var order = employmentOrderService.getById(orderId);
        var record = mapperService.toEntity(dto);
        order.addRecord(record);
        employmentOrderService.save(order);
        return record;
    }

    @Override
    public List<EmploymentOrderRecord> getAllByInternalEmploymentOrderId(Long orderId) {
        return recordRepository.findAllByEmploymentOrderId(orderId);
    }

    @Override
    public EmploymentOrderRecord getById(Long orderId, Long id) {
        return recordRepository.findByEmploymentOrderIdAndId(orderId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmploymentOrderRecord update(Long orderId, Long id, EmploymentOrderRecordRequest dto) {
        var order = employmentOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        record = recordRepository.save(mapperService.toEntity(record, dto));
        employmentOrderService.save(order);
        return record;
    }

    @Override
    @Transactional
    public void delete(Long orderId, Long id) {
        var order = employmentOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order.removeRecord(record);
        employmentOrderService.save(order);
    }

    @Override
    public EmploymentOrderRecordResponse toDTO(EmploymentOrderRecord record) {
        return mapperService.toDTO(record);
    }


}

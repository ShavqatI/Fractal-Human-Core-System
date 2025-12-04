package com.fractal.domain.order.bonus.record;

import com.fractal.domain.order.bonus.BonusOrderService;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordRequest;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordResponse;
import com.fractal.domain.order.bonus.record.mapper.BonusOrderRecordMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BonusOrderRecordServiceImpl implements BonusOrderRecordService {

    private final BonusOrderRecordRepository recordRepository;
    private final BonusOrderRecordMapperService mapperService;
    private final BonusOrderService bonusOrderService;


    @Override
    @Transactional
    public BonusOrderRecord create(Long orderId, BonusOrderRecordRequest dto) {
        var order = bonusOrderService.getById(orderId);
        var record = mapperService.toEntity(dto);
        order.addRecord(record);
        bonusOrderService.save(order);
        return record;
    }

    @Override
    public List<BonusOrderRecord> getAllByBonusOrderId(Long orderId) {
        return recordRepository.findAllByBonusOrderId(orderId);
    }

    @Override
    public BonusOrderRecord getById(Long orderId, Long id) {
        return recordRepository.findByBonusOrderIdAndId(orderId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public BonusOrderRecord update(Long orderId, Long id, BonusOrderRecordRequest dto) {
        var order = bonusOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        record = recordRepository.save(mapperService.toEntity(record, dto));
        bonusOrderService.save(order);
        return record;
    }

    @Override
    @Transactional
    public void delete(Long orderId, Long id) {
        var order = bonusOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order.removeRecord(record);
        bonusOrderService.save(order);
    }

    @Override
    public BonusOrderRecordResponse toDTO(BonusOrderRecord record) {
        return mapperService.toDTO(record);
    }


}

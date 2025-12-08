package com.fractal.domain.order.recognition.record;

import com.fractal.domain.order.recognition.RecognitionOrderService;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordRequest;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordResponse;
import com.fractal.domain.order.recognition.record.mapper.RecognitionOrderRecordMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecognitionOrderRecordServiceImpl implements RecognitionOrderRecordService {

    private final RecognitionOrderRecordRepository recordRepository;
    private final RecognitionOrderRecordMapperService mapperService;
    private final RecognitionOrderService recognitionOrderService;


    @Override
    @Transactional
    public RecognitionOrderRecord create(Long orderId, RecognitionOrderRecordRequest dto) {
        var order = recognitionOrderService.getById(orderId);
        var record = mapperService.toEntity(dto);
        order.addRecord(record);
        recognitionOrderService.save(order);
        return record;
    }

    @Override
    public List<RecognitionOrderRecord> getAllByBonusOrderId(Long orderId) {
        return recordRepository.findAllByRecognitionOrderId(orderId);
    }

    @Override
    public RecognitionOrderRecord getById(Long orderId, Long id) {
        return recordRepository.findByRecognitionOrderIdAndId(orderId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public RecognitionOrderRecord update(Long orderId, Long id, RecognitionOrderRecordRequest dto) {
        var order = recognitionOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        record = recordRepository.save(mapperService.toEntity(record, dto));
        recognitionOrderService.save(order);
        return record;
    }

    @Override
    @Transactional
    public void delete(Long orderId, Long id) {
        var order = recognitionOrderService.getById(orderId);
        var record = order.getRecords()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order.removeRecord(record);
        recognitionOrderService.save(order);
    }

    @Override
    public RecognitionOrderRecordResponse toDTO(RecognitionOrderRecord record) {
        return mapperService.toDTO(record);
    }


}

package com.fractal.domain.order.recognition.record;

import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordRequest;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordResponse;

import java.util.List;

public interface RecognitionOrderRecordService {

    RecognitionOrderRecord create(Long orderId, RecognitionOrderRecordRequest dto);

    List<RecognitionOrderRecord> getAllByBonusOrderId(Long orderId);

    RecognitionOrderRecord getById(Long orderId, Long id);

    RecognitionOrderRecord update(Long orderId, Long id, RecognitionOrderRecordRequest dto);

    void delete(Long orderId, Long id);

    RecognitionOrderRecordResponse toDTO(RecognitionOrderRecord record);

}

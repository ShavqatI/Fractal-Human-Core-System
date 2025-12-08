package com.fractal.domain.order.recognition.record.mapper;

import com.fractal.domain.order.recognition.record.RecognitionOrderRecord;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordRequest;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordResponse;

public interface RecognitionOrderRecordMapperService {
    RecognitionOrderRecordResponse toDTO(RecognitionOrderRecord record);

    RecognitionOrderRecord toEntity(RecognitionOrderRecordRequest dto);

    RecognitionOrderRecord toEntity(RecognitionOrderRecord record, RecognitionOrderRecordRequest dto);
}



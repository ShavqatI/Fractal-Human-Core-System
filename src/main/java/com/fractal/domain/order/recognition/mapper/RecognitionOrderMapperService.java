package com.fractal.domain.order.recognition.mapper;

import com.fractal.domain.order.recognition.RecognitionOrder;
import com.fractal.domain.order.recognition.dto.RecognitionOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;

public interface RecognitionOrderMapperService {
    RecognitionOrderResponse toDTO(RecognitionOrder order);

    RecognitionOrder toEntity(RecognitionOrderRequest dto);

    RecognitionOrder toEntity(RecognitionOrder order, RecognitionOrderRequest dto);
}



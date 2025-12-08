package com.fractal.domain.order.recognition.mapper;

import com.fractal.domain.order.recognition.RecognitionOrder;
import com.fractal.domain.order.recognition.dto.EmploymentOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;

public interface RecognitionOrderMapperService {
    RecognitionOrderResponse toDTO(RecognitionOrder order);

    RecognitionOrder toEntity(EmploymentOrderRequest dto);

    RecognitionOrder toEntity(RecognitionOrder order, EmploymentOrderRequest dto);
}



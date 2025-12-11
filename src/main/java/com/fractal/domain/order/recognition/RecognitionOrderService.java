package com.fractal.domain.order.recognition;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.order.recognition.dto.RecognitionOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;
import com.fractal.domain.order.recognition.dto.RecognitionOrderSalaryRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderUploadExcelRequest;

import java.nio.file.Path;
import java.util.List;

public interface RecognitionOrderService extends ApprovalWorkflowAware<Long, RecognitionOrder> , Cancelable<Long, RecognitionOrder> {

    RecognitionOrder create(RecognitionOrderRequest dto);

    List<RecognitionOrder> getAll();

    RecognitionOrder getById(Long id);

    RecognitionOrder update(Long id, RecognitionOrderRequest dto);

    void delete(Long id);

    List<RecognitionOrder> createFromExcelFile(RecognitionOrderUploadExcelRequest dto);
    RecognitionOrder decreaseSalary(RecognitionOrderSalaryRequest dto);
    RecognitionOrder increaseSalary(RecognitionOrderSalaryRequest dto);
    RecognitionOrder surcharge(RecognitionOrderSalaryRequest dto);
    RecognitionOrderResponse toDTO(RecognitionOrder recognitionOrder);

    RecognitionOrder save(RecognitionOrder order);

    Path print(Long id);
}

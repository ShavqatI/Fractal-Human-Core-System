package com.fractal.domain.order.recognition;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.order.employment.EmploymentOrder;
import com.fractal.domain.order.recognition.dto.EmploymentOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface RecognitionOrderService extends ApprovalWorkflowAware<Long, RecognitionOrder> , Cancelable<Long, RecognitionOrder> {

    RecognitionOrder create(EmploymentOrderRequest dto);

    List<RecognitionOrder> getAll();

    RecognitionOrder getById(Long id);

    RecognitionOrder update(Long id, EmploymentOrderRequest dto);

    void delete(Long id);

    List<RecognitionOrder> createFromExcelFile(MultipartFile file);


    RecognitionOrderResponse toDTO(RecognitionOrder recognitionOrder);

    RecognitionOrder save(RecognitionOrder order);

    Path print(Long id);
}

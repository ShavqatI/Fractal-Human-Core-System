package com.fractal.domain.learning_develpment.learning.delivery_mode;

import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeRequest;
import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeResponse;

import java.util.List;

public interface LearningDeliveryModeService {

    LearningDeliveryMode create(LearningDeliveryModeRequest dto);
    List<LearningDeliveryMode> getAll();
    LearningDeliveryMode getByCode(String code);
    LearningDeliveryMode getById(Long id);
    LearningDeliveryMode update(Long id, LearningDeliveryModeRequest dto);
    void deleteById(Long id);
    LearningDeliveryModeResponse toDTO(LearningDeliveryMode learningDeliveryMode);
}

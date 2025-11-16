package com.fractal.domain.learning_develpment.learning.session.location.offline.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressResponse;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record OfflineLearningLocationResponse(
        Long id,
        LearningLocationTypeResponse locationTypeResponse,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer capacity,
        List<OfflineLearningLocationAddressResponse> addresses,
        StatusCompactResponse status,
        LocalDateTime createdDate

) implements LearningLocationResponse {
}

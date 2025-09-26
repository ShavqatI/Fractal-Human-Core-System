package com.fractal.domain.learning_develpment.learning.session.location.offline.dto;

import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressRequest;

import java.time.LocalDateTime;
import java.util.List;

public record OfflineLearningLocationRequest(
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer capacity,
        List<OfflineLearningLocationAddressRequest> addresses,
        Long statusId
) implements LearningLocationRequest { }

package com.fractal.domain.learning_develpment.learning.session.location.dto;


import java.time.LocalDateTime;


public interface LearningLocationRequest {
     Integer capacity();
     LocalDateTime startTime();
     LocalDateTime endTime();
     Long statusId();
}

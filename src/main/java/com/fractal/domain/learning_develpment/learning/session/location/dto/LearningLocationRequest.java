package com.fractal.domain.learning_develpment.learning.session.location.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;

import java.time.LocalDateTime;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,       // Use a type name in JSON
        property = "learningLocationType",      // JSON must include this field
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OfflineLearningLocationRequest.class, name = "offline"),
        @JsonSubTypes.Type(value = OnlineLearningLocationRequest.class, name = "online")
})
public interface LearningLocationRequest {
    Integer capacity();

    LocalDateTime startTime();

    LocalDateTime endTime();

    Long statusId();
}

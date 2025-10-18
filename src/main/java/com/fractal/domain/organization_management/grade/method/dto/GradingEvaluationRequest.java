package com.fractal.domain.organization_management.grade.method.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationRequest;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,       // Use a type name in JSON
        property = "evaluationMethod",      // JSON must include this field
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HayEvaluationRequest.class, name = "HAY")

})
public interface GradingEvaluationRequest {
}

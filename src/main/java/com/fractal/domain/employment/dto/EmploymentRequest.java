package com.fractal.domain.employment.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,       // Use a type name in JSON
        property = "employmentKind",      // JSON must include this field
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExternalEmploymentRequest.class, name = "EXTERNAL"),
        @JsonSubTypes.Type(value = InternalEmploymentRequest.class, name = "INTERNAL")
})
public interface EmploymentRequest {
}

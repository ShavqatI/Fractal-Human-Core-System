package com.fractal.domain.employment.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,       // Use a type name in JSON
        include = JsonTypeInfo.As.PROPERTY,
        property = "employmentKind",      // JSON must include this field
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExternalEmploymentRequest.class, name = "external"),
        @JsonSubTypes.Type(value = InternalEmploymentRequest.class, name = "internal")
})
public interface EmploymentRequest {
}

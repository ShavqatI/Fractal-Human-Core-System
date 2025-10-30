package com.fractal.domain.employee_management.business_trip.location.address.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,       // Use a type name in JSON
        property = "locationType",      // JSON must include this field
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExternalBusinessTripLocationAddressRequest.class, name = "EXTERNAL"),
        @JsonSubTypes.Type(value = InternalBusinessTripLocationAddressRequest.class, name = "INTERNAL")
})
public interface BusinessTripLocationAddressRequest {
}

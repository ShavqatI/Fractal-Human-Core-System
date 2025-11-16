package com.fractal.domain.location.address.mapper;

import com.fractal.domain.location.address.Address;
import com.fractal.domain.location.address.dto.AddressRequest;
import com.fractal.domain.location.address.dto.AddressResponse;

public interface AddressMapperService {
    AddressResponse toDTO(Address address);

    Address toEntity(AddressRequest dto);

    Address toEntity(Address address, AddressRequest dto);
}

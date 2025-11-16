package com.fractal.domain.employee_management.relative.address.mapper;

import com.fractal.domain.employee_management.relative.address.RelativeAddress;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;

public interface RelativeAddressMapperService {
    RelativeAddressResponse toDTO(RelativeAddress address);

    RelativeAddress toEntity(RelativeAddressRequest dto);

    RelativeAddress toEntity(RelativeAddress address, RelativeAddressRequest dto);
}



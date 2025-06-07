package com.fractal.domain.employee_management.relative.address;

import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;

public interface RelativeAddressService {
    RelativeAddressResponse toDTO(RelativeAddress address);
    RelativeAddress toEntity(RelativeAddressRequest dto);
    RelativeAddress update(RelativeAddress address, RelativeAddressRequest dto);
    void delete(RelativeAddress address);
}

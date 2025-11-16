package com.fractal.domain.employee_management.relative.address;

import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;

import java.util.List;

public interface RelativeAddressService {

    RelativeAddress create(Long relativeId, RelativeAddressRequest dto);

    RelativeAddress getById(Long relativeId, Long id);

    List<RelativeAddress> getAllByRelativeId(Long relativeId);

    RelativeAddress update(Long relativeId, Long id, RelativeAddressRequest dto);

    void delete(Long relativeId, Long id);

    RelativeAddressResponse toDTO(RelativeAddress address);

}

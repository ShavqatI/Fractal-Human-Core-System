package com.fractal.domain.location.address.type;

import com.fractal.domain.location.address.type.dto.AddressTypeRequest;
import com.fractal.domain.location.address.type.dto.AddressTypeResponse;

import java.util.List;

public interface AddressTypeService {
    AddressType create(AddressTypeRequest dto);

    List<AddressType> getAll();

    AddressType getByCode(String code);

    AddressType getById(Long id);

    AddressType update(Long id, AddressTypeRequest dto);

    void deleteById(Long id);

    AddressTypeResponse toDTO(AddressType addressType);
}

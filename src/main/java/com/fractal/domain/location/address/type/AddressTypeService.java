package com.fractal.domain.location.address.type;

import com.fractal.domain.location.address.type.dto.AddressTypeCreate;
import com.fractal.domain.location.address.type.dto.AddressTypeResponse;

import java.util.List;

public interface AddressTypeService {
   AddressType create(AddressTypeCreate dto);
   List<AddressType> getAll();
   AddressType getByCode(String code);
   AddressType getById(Long id);
   AddressType update(Long id, AddressTypeCreate dto);
   void deleteById(Long id);
   AddressTypeResponse toDTO(AddressType addressType);
}

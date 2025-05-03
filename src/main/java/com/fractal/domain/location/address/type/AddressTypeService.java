package com.fractal.domain.location.address.type;

import java.util.List;

public interface AddressTypeService {
   AddressTypeDto create(AddressTypeDto dto);
   List<AddressTypeDto> getAll();
   AddressTypeDto getByCode(String code);
   AddressTypeDto getById(Long id);
   AddressTypeDto update(Long id, AddressTypeDto addressTypeDTO);
   void deleteById(Long id);
}

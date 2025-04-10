package com.fractal.domain.location.address.type;

import java.util.List;

public interface AddressTypeService {
   AddressTypeDTO create(AddressTypeDTO dto);
   List<AddressTypeDTO> getAll();
   AddressTypeDTO getByCode(String code);
   AddressTypeDTO getById(Long id);
   AddressTypeDTO update(Long id,AddressTypeDTO addressTypeDTO);
   void deleteById(Long id);
}

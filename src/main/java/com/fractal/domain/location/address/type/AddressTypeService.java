package com.fractal.domain.location.address.type;

import com.fractal.domain.location.address.type.dto.AddressTypeDTO;

import java.util.List;

public interface AddressTypeService {
   List<AddressType> findAll();
   AddressType findByCode(String code);

   AddressType findById(Long id);
   AddressType create(AddressTypeDTO dto);
   AddressType update(Long id,AddressType newAddressType);

}

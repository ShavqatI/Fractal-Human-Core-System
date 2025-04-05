package com.fractal.domain.location.address.type;

import java.util.List;

public interface AddressTypeService {
   List<AddressType> findAll();
   AddressType findByCode(String code);

   AddressType findById(Long id);
   AddressType create(AddressType addressType);
   AddressType update(Long id,AddressType newAddressType);
}

package com.fractal.domain.employee_management.relative;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;


public interface RelativeService {
    Relative create(RelativeRequest dto);
    RelativeResponse toDTO(Relative relative);
    Relative toEntity(RelativeRequest dto);
    Relative update(Long id, RelativeRequest dto);
    void delete(Relative relative);

    Relative addAddress(Long id, RelativeAddressRequest dto);
    Relative updateAddress(Long id,Long addressId, RelativeAddressRequest dto);
    Relative deleteAddress(Long id,Long addressId);

    Relative addContact(Long id, ContactRequest dto);
    Relative updateContact(Long id,Long contactId, ContactRequest dto);
    Relative deleteContact(Long id,Long contactId);

}

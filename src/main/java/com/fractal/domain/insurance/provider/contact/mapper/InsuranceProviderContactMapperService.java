package com.fractal.domain.insurance.provider.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.insurance.provider.contact.InsuranceProviderContact;

public interface InsuranceProviderContactMapperService {
    ContactResponse toDTO(InsuranceProviderContact contact);
    InsuranceProviderContact toEntity(ContactRequest dto);
    InsuranceProviderContact toEntity(InsuranceProviderContact contact, ContactRequest dto);
}



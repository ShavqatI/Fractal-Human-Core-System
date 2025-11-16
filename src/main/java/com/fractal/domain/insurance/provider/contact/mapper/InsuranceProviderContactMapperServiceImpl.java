package com.fractal.domain.insurance.provider.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.insurance.provider.contact.InsuranceProviderContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InsuranceProviderContactMapperServiceImpl implements InsuranceProviderContactMapperService {
    private final ContactMapperService mapperService;

    @Override
    public ContactResponse toDTO(InsuranceProviderContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public InsuranceProviderContact toEntity(ContactRequest dto) {
        return mapToEntity(new InsuranceProviderContact(), mapperService.toEntity(dto));
    }

    @Override
    public InsuranceProviderContact toEntity(InsuranceProviderContact contact, ContactRequest dto) {
        return mapToEntity(contact, mapperService.toEntity(contact, dto));
    }

    private InsuranceProviderContact mapToEntity(InsuranceProviderContact insuranceProviderContact, Contact contact) {
        insuranceProviderContact.setContactType(contact.getContactType());
        insuranceProviderContact.setValue(contact.getValue());
        return insuranceProviderContact;
    }
}

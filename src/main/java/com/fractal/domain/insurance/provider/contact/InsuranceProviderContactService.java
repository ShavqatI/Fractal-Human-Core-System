package com.fractal.domain.insurance.provider.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface InsuranceProviderContactService {

    InsuranceProviderContact create(Long insuranceProviderId, ContactRequest dto);
    List<InsuranceProviderContact> getAllByInsuranceProviderId(Long insuranceProviderId);
    InsuranceProviderContact getById(Long insuranceProviderId , Long id);
    InsuranceProviderContact update(Long insuranceProviderId, Long id, ContactRequest dto);
    void delete(Long insuranceProviderId,Long id);
    ContactResponse toDTO(InsuranceProviderContact contact);

}

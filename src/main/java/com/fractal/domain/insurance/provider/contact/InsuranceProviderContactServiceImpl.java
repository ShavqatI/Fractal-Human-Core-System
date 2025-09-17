package com.fractal.domain.insurance.provider.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.insurance.provider.InsuranceProviderService;
import com.fractal.domain.insurance.provider.contact.mapper.InsuranceProviderContactMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceProviderContactServiceImpl implements InsuranceProviderContactService {

    private final InsuranceProviderContactRepository contactRepository;
    private final InsuranceProviderService insuranceProviderContactService;
    private final InsuranceProviderContactMapperService contactMapperService;


    @Override
    @Transactional
    public InsuranceProviderContact create(Long insuranceProviderId, ContactRequest dto) {
        var insuranceProvider = insuranceProviderContactService.getById(insuranceProviderId);
        var contact = contactMapperService.toEntity(dto);
        insuranceProvider.addContact(contact);
        insuranceProviderContactService.save(insuranceProvider);
        return contact;
    }

    @Override
    public List<InsuranceProviderContact> getAllByInsuranceProviderId(Long insuranceProviderId) {
        return contactRepository.findAllByInsuranceProviderId(insuranceProviderId);
    }

    @Override
    public InsuranceProviderContact getById(Long insuranceProviderId, Long id) {
        return contactRepository.findByInsuranceProviderIdAndId(insuranceProviderId,id).orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InsuranceProviderContact update(Long insuranceProviderId, Long id, ContactRequest dto) {
        var insuranceProvider = insuranceProviderContactService.getById(insuranceProviderId);
        var contact = insuranceProvider.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        contact = contactMapperService.toEntity(contact,dto);
        contactRepository.save(contact);
        insuranceProviderContactService.save(insuranceProvider);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long insuranceProviderId, Long id) {
        var insuranceProvider = insuranceProviderContactService.getById(insuranceProviderId);
        var contact = insuranceProvider.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        insuranceProvider.removeContact(contact);
        insuranceProviderContactService.save(insuranceProvider);
    }

    @Override
    public ContactResponse toDTO(InsuranceProviderContact contact) {
        return contactMapperService.toDTO(contact);
    }

}

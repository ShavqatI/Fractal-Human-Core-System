package com.fractal.domain.organization_management.organization.address;

import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;
import com.fractal.domain.organization_management.organization.address.mapper.OrganizationAddressMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationAddressServiceImpl implements OrganizationAddressService {

    private final OrganizationAddressRepository organizationAddressRepository;
    private final OrganizationAddressMapperService addressMapperService;
    private final OrganizationService organizationService;


    @Override
    public OrganizationAddress create(Long organizationId, OrganizationAddressRequest dto) {
        var organization = organizationService.getById(organizationId);
        var address = addressMapperService.toEntity(dto);
        organization.addAddress(address);
        organizationService.save(organization);
        return address;
    }



    @Override
    public List<OrganizationAddress> getAllByOrganizationId(Long organizationId) {
        return organizationAddressRepository.findAllByOrganizationId(organizationId);
    }

    @Override
    public OrganizationAddress getById(Long organizationId, Long id) {
        return organizationAddressRepository.findByOrganizationIdAndId(organizationId,id).orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + id + " not found"));
    }

    @Override
    public OrganizationAddress update(Long organizationId, Long id, OrganizationAddressRequest dto) {
        var organization = organizationService.getById(organizationId);
        var address = organization.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + id + " not found"));
        address = organizationAddressRepository.save(addressMapperService.toEntity(address,dto));
        organizationService.save(organization);
        return address;
    }

    @Override
    public void delete(Long organizationId, Long id) {
        var organization = organizationService.getById(organizationId);
        var address = organization.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + id + " not found"));
        organization.removeAddress(address);
        organizationAddressRepository.delete(address);
        organizationService.save(organization);
    }

    @Override
    public OrganizationAddressResponse toDTO(OrganizationAddress address) {
        return addressMapperService.toDTO(address);
    }
}

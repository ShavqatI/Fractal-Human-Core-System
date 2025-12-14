package com.fractal.domain.employee_management.business_trip.location.address.mapper;

import com.fractal.domain.employee_management.business_trip.location.address.BusinessTripLocationAddress;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressRequest;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressResponse;
import com.fractal.domain.employee_management.business_trip.location.address.dto.ExternalBusinessTripLocationAddressRequest;
import com.fractal.domain.employee_management.business_trip.location.address.dto.InternalBusinessTripLocationAddressRequest;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.address.OrganizationAddress;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BusinessTripLocationAddressMapperServiceImpl implements BusinessTripLocationAddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;
    private final OrganizationService organizationService;


    @Override
    public BusinessTripLocationAddressResponse toDTO(BusinessTripLocationAddress address) {
        return new BusinessTripLocationAddressResponse(
                address.getId(),
                addressTypeService.toDTO(address.getAddressType()),
                countryService.toCompactDTO(address.getCountry()),
                regionService.toCompactDTO(address.getRegion()),
                cityService.toCompactDTO(address.getCity()),
                districtService.toCompactDTO(address.getDistrict()),
                address.getStreet(),
                address.getCreatedDate(),
                address.getUpdatedDate()
        );
    }

    @Override
    public BusinessTripLocationAddress toEntity(ExternalBusinessTripLocationAddressRequest dto) {
        return mapToEntity(new BusinessTripLocationAddress(), dto);
    }

    @Override
    public BusinessTripLocationAddress toEntity(InternalBusinessTripLocationAddressRequest dto) {
        var organizationAddress = organizationService.getById(dto.organizationId()).getAddresses().stream().filter(address -> address.getEndDate() == null).findFirst().orElseThrow(() -> new ResourceNotFoundException("The organization with id : + " + dto.organizationId() + " does not have active  address"));
        var offlineLearningLocationAddress = convert(new BusinessTripLocationAddress(), (OrganizationAddress) Hibernate.unproxy(organizationAddress));
        return offlineLearningLocationAddress;
    }

    @Override
    public BusinessTripLocationAddress toEntity(BusinessTripLocationAddressRequest dto) {
        if (dto instanceof InternalBusinessTripLocationAddressRequest) {
            return toEntity((InternalBusinessTripLocationAddressRequest) dto);
        } else if (dto instanceof ExternalBusinessTripLocationAddressRequest) {
            return toEntity((ExternalBusinessTripLocationAddressRequest) dto);
        }
        return null;
    }

    @Override
    public BusinessTripLocationAddress toEntity(BusinessTripLocationAddress address, BusinessTripLocationAddressRequest dto) {
        if (dto instanceof InternalBusinessTripLocationAddressRequest) {
            return mapToEntity(address, (InternalBusinessTripLocationAddressRequest) dto);
        } else if (dto instanceof ExternalBusinessTripLocationAddressRequest) {
            return mapToEntity(address, (ExternalBusinessTripLocationAddressRequest) dto);
        }
        return null;
    }

    @Override
    public BusinessTripLocationAddress copy(BusinessTripLocationAddress address) {
        var copy = BusinessTripLocationAddress.builder()
                .businessTripLocation(address.getBusinessTripLocation())
                .addressType(address.getAddressType())
                .country(address.getCountry())
                .region(address.getRegion())
                .city(address.getCity())
                .district(address.getDistrict())
                .street(address.getStreet())
                .house(address.getHouse())
                .apartment(address.getApartment())
                .postalCode(address.getPostalCode())
                .buildingNumber(address.getBuildingNumber())
                .floorNumber(address.getFloorNumber())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .startDate(address.getStartDate())
                .endDate(address.getEndDate())
                .build();
        return copy;
    }

    private BusinessTripLocationAddress mapToEntity(BusinessTripLocationAddress address, ExternalBusinessTripLocationAddressRequest dto) {
        address.setAddressType(addressTypeService.getById(dto.addressTypeId()));
        address.setCountry(countryService.getById(dto.countryId()));
        address.setRegion(dto.regionId() != null ? regionService.getById(dto.regionId()) : null);
        address.setCity(dto.cityId() != null ? cityService.getById(dto.cityId()) : null);
        address.setDistrict(dto.districtId() != null ? districtService.getById(dto.districtId()) : null);
        address.setStreet(dto.street());
        return address;
    }

    private BusinessTripLocationAddress mapToEntity(BusinessTripLocationAddress address, InternalBusinessTripLocationAddressRequest dto) {
        var organizationAddress = organizationService.getById(dto.organizationId()).getAddresses().stream().filter(address1 -> address1.getEndDate() == null).findFirst().orElseThrow(() -> new ResourceNotFoundException("The organization with id : + " + dto.organizationId() + " does not have active  address"));
        var offlineLearningLocationAddress = convert(address, (OrganizationAddress) Hibernate.unproxy(organizationAddress));
        return offlineLearningLocationAddress;
    }

    private BusinessTripLocationAddress convert(BusinessTripLocationAddress address, OrganizationAddress organizationAddress) {
        address.setAddressType(organizationAddress.getAddressType());
        address.setCountry(organizationAddress.getCountry());
        address.setRegion(organizationAddress.getRegion());
        address.setCity(organizationAddress.getCity());
        address.setDistrict(organizationAddress.getDistrict());
        address.setStreet(organizationAddress.getStreet());
        address.setHouse(organizationAddress.getHouse());
        address.setApartment(organizationAddress.getApartment());
        address.setPostalCode(organizationAddress.getPostalCode());
        address.setBuildingNumber(organizationAddress.getBuildingNumber());
        address.setFloorNumber(organizationAddress.getFloorNumber());
        address.setLatitude(organizationAddress.getLatitude());
        address.setLongitude(organizationAddress.getLongitude());
        address.setStartDate(organizationAddress.getStartDate());
        address.setEndDate(organizationAddress.getEndDate());
        return address;
    }


}

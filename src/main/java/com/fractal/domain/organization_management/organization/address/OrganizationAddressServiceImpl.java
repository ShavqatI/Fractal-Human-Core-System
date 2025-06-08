package com.fractal.domain.organization_management.organization.address;

import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationAddressServiceImpl implements OrganizationAddressService {

    private final OrganizationAddressRepository organizationAddressRepository;
    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;

    @Override
    public OrganizationAddressResponse toDTO(OrganizationAddress address) {
        return new OrganizationAddressResponse(
                address.getId(),
                address.getAddressType().getName(),
                address.getCountry().getName(),
                address.getRegion().getName(),
                address.getCity().getName(),
                address.getDistrict().getName(),
                address.getStreet(),
                address.getHouse(),
                address.getApartment(),
                address.getPostalCode(),
                address.getBuildingNumber(),
                address.getFloorNumber(),
                address.getLatitude(),
                address.getLongitude(),
                address.getStartDate(),
                address.getEndDate(),
                address.getCreatedDate()
        );
    }

    @Override
    public OrganizationAddress toEntity(OrganizationAddressRequest dto) {
        return OrganizationAddress.builder()
                .addressType(addressTypeService.getById(dto.addressTypeId()))
                .country(countryService.getById(dto.countryId()))
                .region(regionService.getById(dto.regionId()))
                .city(cityService.getById(dto.cityId()))
                .district(districtService.getById(dto.districtId()))
                .street(dto.street())
                .house(dto.house())
                .apartment(dto.apartment())
                .postalCode(dto.postalCode())
                .buildingNumber(dto.buildingNumber())
                .floorNumber(dto.floorNumber())
                .latitude(dto.latitude())
                .longitude(dto.longitude())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .build();
    }

    @Override
    public OrganizationAddress update(OrganizationAddress address, OrganizationAddressRequest dto) {
        try {
            address.setAddressType(addressTypeService.getById(dto.addressTypeId()));
            address.setCountry(countryService.getById(dto.countryId()));
            address.setRegion(regionService.getById(dto.regionId()));
            address.setCity(cityService.getById(dto.cityId()));
            address.setDistrict(districtService.getById(dto.districtId()));
            address.setStreet(dto.street());
            address.setHouse(dto.house());
            address.setApartment(dto.apartment());
            address.setPostalCode(dto.postalCode());
            address.setBuildingNumber(dto.buildingNumber());
            address.setFloorNumber(dto.floorNumber());
            address.setLatitude(dto.latitude());
            address.setLongitude(dto.longitude());
            address.setStartDate(dto.startDate());
            address.setEndDate(dto.endDate());
            organizationAddressRepository.save(address);
            return address;
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void delete(OrganizationAddress address) {
        organizationAddressRepository.delete(address);
    }

    @Override
    public List<OrganizationAddress> getByOrganizationId(Long organizationId) {
        return organizationAddressRepository.findAllByOrganizationId(organizationId);
    }
}

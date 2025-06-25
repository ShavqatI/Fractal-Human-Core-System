package com.fractal.domain.location.address.mapper;

import com.fractal.domain.location.address.Address;
import com.fractal.domain.location.address.dto.AddressRequest;
import com.fractal.domain.location.address.dto.AddressResponse;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AddressMapperServiceImpl implements AddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;

    @Override
    public AddressResponse toDTO(Address address) {
        return new AddressResponse(
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
                address.getCreatedDate(),
                address.getUpdatedDate()
        );
    }

    @Override
    public Address toEntity(AddressRequest dto) {
        return mapToEntity(new Address(),dto);
    }

    @Override
    public Address toEntity(Address address, AddressRequest dto) {
       return mapToEntity(address,dto);
    }

    private Address mapToEntity(Address address, AddressRequest dto) {
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
        return address;
    }

}

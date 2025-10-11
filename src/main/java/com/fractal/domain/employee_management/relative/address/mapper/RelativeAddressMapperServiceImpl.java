package com.fractal.domain.employee_management.relative.address.mapper;

import com.fractal.domain.employee_management.relative.address.RelativeAddress;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class RelativeAddressMapperServiceImpl implements RelativeAddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;

    @Override
    public RelativeAddressResponse toDTO(RelativeAddress address) {
        return new RelativeAddressResponse(
                address.getId(),
                addressTypeService.toDTO(address.getAddressType()),
                countryService.toCompactDTO(address.getCountry()),
                regionService.toCompactDTO(address.getRegion()),
                cityService.toCompactDTO(address.getCity()),
                districtService.toCompactDTO(address.getDistrict()),
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
    public RelativeAddress toEntity(RelativeAddressRequest dto) {
        return mapToEntity(new RelativeAddress(),dto);
    }

    @Override
    public RelativeAddress toEntity(RelativeAddress address, RelativeAddressRequest dto) {
       return mapToEntity(address,dto);
    }

    private RelativeAddress mapToEntity(RelativeAddress address, RelativeAddressRequest dto) {
        address.setAddressType(addressTypeService.getById(dto.addressTypeId()));
        address.setCountry(countryService.getById(dto.countryId()));
        address.setRegion(Optional.of(regionService.getById(dto.regionId())).orElse(null));
        address.setCity(Optional.of(cityService.getById(dto.cityId())).orElse(null));
        address.setDistrict(Optional.of(districtService.getById(dto.districtId())).orElse(null));
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

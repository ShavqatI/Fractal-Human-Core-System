package com.fractal.domain.employee_management.relative.address;

import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelativeAddressServiceImpl implements RelativeAddressService {

    private final RelativeAddressRepository relativeAddressRepository;
    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;

    @Override
    public RelativeAddressResponse toDTO(RelativeAddress address) {
        return new RelativeAddressResponse(
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
    public RelativeAddress toEntity(RelativeAddressRequest dto) {
        return RelativeAddress.builder()
                .addressType(addressTypeService.getByCode(dto.addressType()))
                .country(countryService.getById(dto.country()))
                .region(regionService.getById(dto.region()))
                .city(cityService.getById(dto.city()))
                .district(districtService.getById(dto.district()))
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
    public RelativeAddress update(RelativeAddress address, RelativeAddressRequest dto) {
        address.setAddressType(addressTypeService.getByCode(dto.addressType()));
        address.setCountry(countryService.getById(dto.country()));
        address.setRegion(regionService.getById(dto.region()));
        address.setCity(cityService.getById(dto.city()));
        address.setDistrict(districtService.getById(dto.district()));
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
      relativeAddressRepository.save(address);
      return address;
    }

    @Override
    public void delete(RelativeAddress address) {
        relativeAddressRepository.delete(address);
    }
}

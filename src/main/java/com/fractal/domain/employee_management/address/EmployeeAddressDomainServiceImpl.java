package com.fractal.domain.employee_management.address;

import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeAddressDomainServiceImpl implements EmployeeAddressDomainService {
    private final EmployeeAddressRepository employeeAddressRepository;
    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;

    @Override
    public EmployeeAddressResponse toDTO(EmployeeAddress address) {
        return new EmployeeAddressResponse(
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
    public EmployeeAddress toEntity(EmployeeAddressRequest dto) {
        return EmployeeAddress.builder()
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
    public EmployeeAddress update(EmployeeAddress address, EmployeeAddressRequest dto) {
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
       return employeeAddressRepository.save(address);
    }

    @Override
    public void delete(EmployeeAddress address) {
        employeeAddressRepository.delete(address);
    }
}

package com.fractal.domain.employee_management.address.mapper;

import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.location.address.Address;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeAddressMapperServiceImpl implements EmployeeAddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;

    @Override
    public EmployeeAddressResponse toDTO(EmployeeAddress address) {
        return new EmployeeAddressResponse(
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
    public EmployeeAddress toEntity(EmployeeAddressRequest dto) {
        return mapToEntity(new EmployeeAddress(), dto);
    }

    @Override
    public EmployeeAddress toEntity(EmployeeAddress address, EmployeeAddressRequest dto) {
        return mapToEntity(address, dto);
    }

    @Override
    public EmployeeAddress convert(EmployeeAddress employeeAddress, Address address) {
        employeeAddress.setAddressType(address.getAddressType());
        employeeAddress.setCountry(address.getCountry());
        employeeAddress.setRegion(address.getRegion());
        employeeAddress.setCity(address.getCity());
        employeeAddress.setDistrict(address.getDistrict());
        employeeAddress.setStreet(address.getStreet());
        employeeAddress.setHouse(address.getHouse());
        employeeAddress.setApartment(address.getApartment());
        employeeAddress.setPostalCode(address.getPostalCode());
        employeeAddress.setBuildingNumber(address.getBuildingNumber());
        employeeAddress.setFloorNumber(address.getFloorNumber());
        employeeAddress.setLatitude(address.getLatitude());
        employeeAddress.setLongitude(address.getLongitude());
        employeeAddress.setStartDate(address.getStartDate());
        employeeAddress.setEndDate(address.getEndDate());
        return employeeAddress;
    }

    private EmployeeAddress mapToEntity(EmployeeAddress address, EmployeeAddressRequest dto) {
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

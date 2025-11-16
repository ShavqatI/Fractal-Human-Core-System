package com.fractal.domain.insurance.provider.address.mapper;

import com.fractal.domain.insurance.provider.address.InsuranceProviderAddress;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressRequest;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressResponse;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InsuranceProviderAddressMapperServiceImpl implements InsuranceProviderAddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;


    @Override
    public InsuranceProviderAddressResponse toDTO(InsuranceProviderAddress address) {
        return new InsuranceProviderAddressResponse(
                address.getId(),
                addressTypeService.toDTO(address.getAddressType()),
                countryService.toCompactDTO(address.getCountry()),
                regionService.toCompactDTO(address.getRegion()),
                cityService.toCompactDTO(address.getCity()),
                districtService.toCompactDTO(address.getDistrict()),
                address.getStreet(),
                address.getHouse(),
                address.getApartment(),
                address.getCreatedDate(),
                address.getUpdatedDate()
        );
    }

    @Override
    public InsuranceProviderAddress toEntity(InsuranceProviderAddressRequest dto) {
        return mapToEntity(new InsuranceProviderAddress(), dto);
    }

    @Override
    public InsuranceProviderAddress toEntity(InsuranceProviderAddress address, InsuranceProviderAddressRequest dto) {
        return mapToEntity(address, dto);
    }

    private InsuranceProviderAddress mapToEntity(InsuranceProviderAddress address, InsuranceProviderAddressRequest dto) {
        address.setAddressType(addressTypeService.getById(dto.addressTypeId()));
        address.setCountry(countryService.getById(dto.countryId()));
        address.setRegion(regionService.getById(dto.regionId()));
        address.setCity(cityService.getById(dto.cityId()));
        address.setDistrict(districtService.getById(dto.districtId()));
        address.setStreet(dto.street());
        address.setHouse(dto.house());
        address.setApartment(dto.apartment());
        return address;
    }

}

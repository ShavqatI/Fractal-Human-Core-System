package com.fractal.domain.training_management.training.location.offline.external.address.mapper;

import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import com.fractal.domain.training_management.training.location.offline.external.address.ExternalTrainingLocationAddress;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressRequest;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ExternalTrainingLocationAddressMapperServiceImpl implements ExternalTrainingLocationAddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;


    @Override
    public ExternalTrainingLocationAddressResponse toDTO(ExternalTrainingLocationAddress address) {
        return new ExternalTrainingLocationAddressResponse(
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
                address.getCreatedDate(),
                address.getUpdatedDate()
        );
    }

    @Override
    public ExternalTrainingLocationAddress toEntity(ExternalTrainingLocationAddressRequest dto) {
        return mapToEntity(new ExternalTrainingLocationAddress(),dto);
    }

    @Override
    public ExternalTrainingLocationAddress toEntity(ExternalTrainingLocationAddress address, ExternalTrainingLocationAddressRequest dto) {
       return mapToEntity(address,dto);
    }

    private ExternalTrainingLocationAddress mapToEntity(ExternalTrainingLocationAddress address, ExternalTrainingLocationAddressRequest dto) {
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
        return address;
    }

}

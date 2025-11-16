package com.fractal.domain.recruitment.candidate.address.mapper;

import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import com.fractal.domain.recruitment.candidate.address.CandidateAddress;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateAddressMapperServiceImpl implements CandidateAddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;


    @Override
    public CandidateAddressResponse toDTO(CandidateAddress address) {
        return new CandidateAddressResponse(
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
    public CandidateAddress toEntity(CandidateAddressRequest dto) {
        return mapToEntity(new CandidateAddress(), dto);
    }

    @Override
    public CandidateAddress toEntity(CandidateAddress address, CandidateAddressRequest dto) {
        return mapToEntity(address, dto);
    }

    private CandidateAddress mapToEntity(CandidateAddress address, CandidateAddressRequest dto) {
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

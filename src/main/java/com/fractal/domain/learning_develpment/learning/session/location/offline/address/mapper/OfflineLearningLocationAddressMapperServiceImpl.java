package com.fractal.domain.learning_develpment.learning.session.location.offline.address.mapper;

import com.fractal.domain.learning_develpment.learning.session.location.offline.address.OfflineLearningLocationAddress;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.ExternalOfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.InternalOfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressResponse;
import com.fractal.domain.location.address.Address;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OfflineLearningLocationAddressMapperServiceImpl implements OfflineLearningLocationAddressMapperService {

    private final AddressTypeService addressTypeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final CityService cityService;
    private final DistrictService districtService;
    private final OrganizationService organizationService;


    @Override
    public OfflineLearningLocationAddressResponse toDTO(OfflineLearningLocationAddress address) {
        return new OfflineLearningLocationAddressResponse(
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
                address.getRoomNumber(),
                address.getLatitude(),
                address.getLongitude(),
                address.getCreatedDate(),
                address.getUpdatedDate()
        );
    }

    @Override
    public OfflineLearningLocationAddress toEntity(ExternalOfflineLearningLocationAddressRequest dto) {
        return mapToEntity(new OfflineLearningLocationAddress(), dto);
    }

    @Override
    public OfflineLearningLocationAddress toEntity(InternalOfflineLearningLocationAddressRequest dto) {
        var organizationAddress = organizationService.getById(dto.organizationId()).getAddresses().stream().filter(address -> address.getEndDate() == null).findFirst().orElseThrow(() -> new ResourceNotFoundException("The organization with id : + " + dto.organizationId() + " does not have active  address"));
        var address = (Address) organizationAddress;
        var offlineLearningLocationAddress = (OfflineLearningLocationAddress) address;
        offlineLearningLocationAddress.setRoomNumber(dto.roomNumber());
        return offlineLearningLocationAddress;
    }

    @Override
    public OfflineLearningLocationAddress toEntity(OfflineLearningLocationAddressRequest dto) {
        if (dto instanceof InternalOfflineLearningLocationAddressRequest) {
            return toEntity((InternalOfflineLearningLocationAddressRequest) dto);
        } else if (dto instanceof ExternalOfflineLearningLocationAddressRequest) {
            return toEntity((ExternalOfflineLearningLocationAddressRequest) dto);
        }
        return null;
    }

    @Override
    public OfflineLearningLocationAddress toEntity(OfflineLearningLocationAddress address, OfflineLearningLocationAddressRequest dto) {
        if (dto instanceof InternalOfflineLearningLocationAddressRequest) {
            return mapToEntity(address, (InternalOfflineLearningLocationAddressRequest) dto);
        } else if (dto instanceof ExternalOfflineLearningLocationAddressRequest) {
            return mapToEntity(address, (ExternalOfflineLearningLocationAddressRequest) dto);
        }
        return null;
    }

    private OfflineLearningLocationAddress mapToEntity(OfflineLearningLocationAddress address, ExternalOfflineLearningLocationAddressRequest dto) {
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
        address.setRoomNumber(dto.roomNumber());
        address.setLatitude(dto.latitude());
        address.setLongitude(dto.longitude());
        return address;
    }

    private OfflineLearningLocationAddress mapToEntity(OfflineLearningLocationAddress address, InternalOfflineLearningLocationAddressRequest dto) {
        var organizationAddress = organizationService.getById(dto.organizationId()).getAddresses().stream().filter(address1 -> address1.getEndDate() == null).findFirst().orElseThrow(() -> new ResourceNotFoundException("The organization with id : + " + dto.organizationId() + " does not have active  address"));
        var address2 = (Address) organizationAddress;
        var offlineLearningLocationAddress = (OfflineLearningLocationAddress) address2;
        offlineLearningLocationAddress.setRoomNumber(dto.roomNumber());
        return offlineLearningLocationAddress;
    }

}

package com.fractal.domain.learning_develpment.learning.session.location.offline.address;

import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocationService;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.ExternalOfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressResponse;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.mapper.OfflineLearningLocationAddressMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfflineLearningLocationAddressServiceImpl implements OfflineLearningLocationAddressService {

    private final OfflineLearningLocationAddressRepository offlineLearningLocationAddressRepository;
    private final OfflineLearningLocationAddressMapperService addressMapperService;
    private final OfflineLearningLocationService locationService;


    @Override
    @Transactional
    public OfflineLearningLocationAddress create(Long locationId, OfflineLearningLocationAddressRequest dto) {
        var location = locationService.getById(locationId);
        var address = addressMapperService.toEntity(dto);
        location.addAddress(address);
        locationService.save(location);
        return address;
    }



    @Override
    public List<OfflineLearningLocationAddress> getAllByOfflineLearningLocationId(Long locationId) {
        return offlineLearningLocationAddressRepository.findAllByOfflineLearningLocationId(locationId);
    }

    @Override
    public OfflineLearningLocationAddress getById(Long locationId, Long id) {
        return offlineLearningLocationAddressRepository.findByOfflineLearningLocationIdAndId(locationId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public OfflineLearningLocationAddress update(Long locationId, Long id, OfflineLearningLocationAddressRequest dto) {
        var location = locationService.getById(locationId);
        var address = location.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        address = offlineLearningLocationAddressRepository.save(addressMapperService.toEntity(address,dto));
        locationService.save(location);
        return address;
    }

    @Override
    public void delete(Long externalTrainingLocationId, Long id) {
        var location = locationService.getById(externalTrainingLocationId);
        var address = location.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        location.removeAddress(address);
        locationService.save(location);
    }

    @Override
    public OfflineLearningLocationAddressResponse toDTO(OfflineLearningLocationAddress address) {
        return addressMapperService.toDTO(address);
    }
}

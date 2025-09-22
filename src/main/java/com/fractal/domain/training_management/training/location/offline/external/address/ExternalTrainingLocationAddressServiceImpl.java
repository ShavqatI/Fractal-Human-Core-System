package com.fractal.domain.training_management.training.location.offline.external.address;

import com.fractal.domain.training_management.training.location.offline.external.ExternalTrainingLocationService;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressRequest;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressResponse;
import com.fractal.domain.training_management.training.location.offline.external.address.mapper.ExternalTrainingLocationAddressMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalTrainingLocationAddressServiceImpl implements ExternalTrainingLocationAddressService {

    private final ExternalTrainingLocationAddressRepository externalTrainingLocationAddressRepository;
    private final ExternalTrainingLocationAddressMapperService addressMapperService;
    private final ExternalTrainingLocationService locationService;


    @Override
    @Transactional
    public ExternalTrainingLocationAddress create(Long externalTrainingLocationId, ExternalTrainingLocationAddressRequest dto) {
        var trainingLocation = locationService.getById(externalTrainingLocationId);
        var address = addressMapperService.toEntity(dto);
        trainingLocation.addAddress(address);
        locationService.save(trainingLocation);
        return address;
    }



    @Override
    public List<ExternalTrainingLocationAddress> getAllByExternalTrainingLocationId(Long externalTrainingLocationId) {
        return externalTrainingLocationAddressRepository.findAllByExternalTrainingLocationId(externalTrainingLocationId);
    }

    @Override
    public ExternalTrainingLocationAddress getById(Long externalTrainingLocationId, Long id) {
        return externalTrainingLocationAddressRepository.findByExternalTrainingLocationIdAndId(externalTrainingLocationId,id).orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public ExternalTrainingLocationAddress update(Long externalTrainingLocationId, Long id, ExternalTrainingLocationAddressRequest dto) {
        var trainingLocation = locationService.getById(externalTrainingLocationId);
        var address = trainingLocation.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + id + " not found"));
        address = externalTrainingLocationAddressRepository.save(addressMapperService.toEntity(address,dto));
        locationService.save(trainingLocation);
        return address;
    }

    @Override
    public void delete(Long externalTrainingLocationId, Long id) {
        var trainingLocation = locationService.getById(externalTrainingLocationId);
        var address = trainingLocation.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + id + " not found"));
        trainingLocation.removeAddress(address);
        locationService.save(trainingLocation);
    }

    @Override
    public ExternalTrainingLocationAddressResponse toDTO(ExternalTrainingLocationAddress address) {
        return addressMapperService.toDTO(address);
    }
}

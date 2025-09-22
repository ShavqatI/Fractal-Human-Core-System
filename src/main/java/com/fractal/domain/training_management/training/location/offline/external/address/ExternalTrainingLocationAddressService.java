package com.fractal.domain.training_management.training.location.offline.external.address;

import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressRequest;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressResponse;

import java.util.List;

public interface ExternalTrainingLocationAddressService {

    ExternalTrainingLocationAddress create(Long externalTrainingLocationId, ExternalTrainingLocationAddressRequest dto);
    ExternalTrainingLocationAddress getById(Long externalTrainingLocationId, Long id);
    List<ExternalTrainingLocationAddress> getAllByExternalTrainingLocationId(Long externalTrainingLocationId);
    ExternalTrainingLocationAddress update(Long externalTrainingLocationId, Long id, ExternalTrainingLocationAddressRequest dto);
    void delete(Long externalTrainingLocationId, Long id);
    ExternalTrainingLocationAddressResponse toDTO(ExternalTrainingLocationAddress address);
}

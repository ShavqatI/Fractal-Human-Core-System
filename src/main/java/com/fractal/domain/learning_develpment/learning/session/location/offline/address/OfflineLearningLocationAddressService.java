package com.fractal.domain.learning_develpment.learning.session.location.offline.address;

import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressResponse;

import java.util.List;

public interface OfflineLearningLocationAddressService {

    OfflineLearningLocationAddress create(Long locationId, OfflineLearningLocationAddressRequest dto);
    OfflineLearningLocationAddress getById(Long locationId, Long id);
    List<OfflineLearningLocationAddress> getAllByOfflineLearningLocationId(Long locationId);
    OfflineLearningLocationAddress update(Long locationId, Long id, OfflineLearningLocationAddressRequest dto);
    void delete(Long externalTrainingLocationId, Long id);
    OfflineLearningLocationAddressResponse toDTO(OfflineLearningLocationAddress address);
}

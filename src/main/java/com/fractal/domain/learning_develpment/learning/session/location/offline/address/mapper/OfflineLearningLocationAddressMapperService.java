package com.fractal.domain.learning_develpment.learning.session.location.offline.address.mapper;

import com.fractal.domain.learning_develpment.learning.session.location.offline.address.OfflineLearningLocationAddress;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.ExternalOfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.InternalOfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressResponse;

public interface OfflineLearningLocationAddressMapperService {
    OfflineLearningLocationAddressResponse toDTO(OfflineLearningLocationAddress address);
    OfflineLearningLocationAddress toEntity(ExternalOfflineLearningLocationAddressRequest dto);
    OfflineLearningLocationAddress toEntity(InternalOfflineLearningLocationAddressRequest dto);
    OfflineLearningLocationAddress toEntity(OfflineLearningLocationAddressRequest dto);
    //OfflineLearningLocationAddress toEntity(OfflineLearningLocationAddress address, ExternalOfflineLearningLocationAddressRequest dto);
    //OfflineLearningLocationAddress toEntity(OfflineLearningLocationAddress address, InternalOfflineLearningLocationAddressRequest dto);
    OfflineLearningLocationAddress toEntity(OfflineLearningLocationAddress address, OfflineLearningLocationAddressRequest dto);
}



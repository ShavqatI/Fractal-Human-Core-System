package com.fractal.domain.training_management.training.location.offline.external.address.mapper;

import com.fractal.domain.training_management.training.location.offline.external.address.ExternalTrainingLocationAddress;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressRequest;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressResponse;

public interface ExternalTrainingLocationAddressMapperService {
    ExternalTrainingLocationAddressResponse toDTO(ExternalTrainingLocationAddress address);
    ExternalTrainingLocationAddress toEntity(ExternalTrainingLocationAddressRequest dto);
    ExternalTrainingLocationAddress toEntity(ExternalTrainingLocationAddress address, ExternalTrainingLocationAddressRequest dto);
}



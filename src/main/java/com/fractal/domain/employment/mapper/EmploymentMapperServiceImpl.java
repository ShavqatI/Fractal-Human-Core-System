package com.fractal.domain.employment.mapper;

import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.ExternalEmployment;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.mapper.ExternalEmploymentMapperService;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.mapper.InternalEmploymentMapperService;
import com.fractal.domain.learning_develpment.learning.session.location.LearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.OnlineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmploymentMapperServiceImpl implements EmploymentMapperService {

    private final InternalEmploymentMapperService internalEmploymentMapperService;
    private final ExternalEmploymentMapperService externalEmploymentMapperService;

    @Override
    public EmploymentResponse toDTO(Employment employment) {
        if (employment instanceof InternalEmployment)
            return internalEmploymentMapperService.toDTO((InternalEmployment) employment);
        else return externalEmploymentMapperService.toDTO((ExternalEmployment) employment);
    }

    @Override
    public Employment toEntity(EmploymentRequest dto) {
        if (dto instanceof InternalEmploymentRequest)
            return internalEmploymentMapperService.toEntity((InternalEmploymentRequest) dto);
        else return externalEmploymentMapperService.toEntity((ExternalEmploymentRequest) dto);
    }
}

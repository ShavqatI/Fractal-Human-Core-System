package com.fractal.domain.vacation_management.request.medical_info.mapper;

import com.fractal.domain.vacation_management.request.medical_info.VacationRequestMedicalInfo;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoResponse;

public interface VacationRequestMedicalInfoMapperService {
    VacationRequestMedicalInfoResponse toDTO(VacationRequestMedicalInfo medicalInfo);

    VacationRequestMedicalInfo toEntity(VacationRequestMedicalInfoRequest dto);

    VacationRequestMedicalInfo toEntity(VacationRequestMedicalInfo medicalInfo, VacationRequestMedicalInfoRequest dto);
}



package com.fractal.domain.vacation_management.request.medical_info;

import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoResponse;

import java.util.List;

public interface VacationRequestMedicalInfoService {

    VacationRequestMedicalInfo create(Long vacationRequestId, VacationRequestMedicalInfoRequest dto);

    List<VacationRequestMedicalInfo> getAllByVacationRequestId(Long vacationRequestId);

    VacationRequestMedicalInfo getById(Long vacationRequestId, Long id);

    VacationRequestMedicalInfo update(Long vacationRequestId, Long id, VacationRequestMedicalInfoRequest dto);

    void delete(Long vacationRequestId, Long id);

    VacationRequestMedicalInfoResponse toDTO(VacationRequestMedicalInfo vacationRequestMedicalInfo);

}

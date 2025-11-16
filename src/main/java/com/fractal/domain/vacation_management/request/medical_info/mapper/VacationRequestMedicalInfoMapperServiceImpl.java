package com.fractal.domain.vacation_management.request.medical_info.mapper;

import com.fractal.domain.vacation_management.request.medical_info.VacationRequestMedicalInfo;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VacationRequestMedicalInfoMapperServiceImpl implements VacationRequestMedicalInfoMapperService {
    @Override
    public VacationRequestMedicalInfoResponse toDTO(VacationRequestMedicalInfo medicalInfo) {
        return new VacationRequestMedicalInfoResponse(
                medicalInfo.getId(),
                medicalInfo.getCertificateNumber(),
                medicalInfo.getIssueDate(),
                medicalInfo.getStartDate(),
                medicalInfo.getEndDate(),
                medicalInfo.getDoctorName(),
                medicalInfo.getMedicalInstitution(),
                medicalInfo.getDiagnosis(),
                medicalInfo.getNotes(),
                medicalInfo.getCreatedDate()

        );
    }

    @Override
    public VacationRequestMedicalInfo toEntity(VacationRequestMedicalInfoRequest dto) {
        return mapToEntity(new VacationRequestMedicalInfo(), dto);
    }

    @Override
    public VacationRequestMedicalInfo toEntity(VacationRequestMedicalInfo medicalInfo, VacationRequestMedicalInfoRequest dto) {
        return mapToEntity(medicalInfo, dto);
    }

    private VacationRequestMedicalInfo mapToEntity(VacationRequestMedicalInfo medicalInfo, VacationRequestMedicalInfoRequest dto) {
        medicalInfo.setCertificateNumber(dto.certificateNumber());
        medicalInfo.setIssueDate(dto.issueDate());
        medicalInfo.setStartDate(dto.startDate());
        medicalInfo.setEndDate(dto.endDate());
        medicalInfo.setDoctorName(dto.doctorName());
        medicalInfo.setMedicalInstitution(dto.medicalInstitution());
        medicalInfo.setDiagnosis(dto.diagnosis());
        medicalInfo.setNotes(dto.notes());
        return medicalInfo;
    }

}

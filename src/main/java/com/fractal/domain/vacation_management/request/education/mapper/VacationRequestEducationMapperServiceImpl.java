package com.fractal.domain.vacation_management.request.education.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.request.education.VacationRequestEducation;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationRequest;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VacationRequestEducationMapperServiceImpl implements VacationRequestEducationMapperService {

    private final StatusService statusService;
    @Override
    public VacationRequestEducationResponse toDTO(VacationRequestEducation education) {
        return new VacationRequestEducationResponse(
                education.getId(),
                education.getBeginDate(),
                education.getEndDate(),
                education.getInstitutionName(),
                education.getInstitutionAddress(),
                education.getIsForeignInstitution(),
                education.getSpecialization(),
                education.getCreatedDate()
        );
    }

    @Override
    public VacationRequestEducation toEntity(VacationRequestEducationRequest dto) {
        return mapToEntity(new VacationRequestEducation(), dto);
    }

    @Override
    public VacationRequestEducation toEntity(VacationRequestEducation education, VacationRequestEducationRequest dto) {
        return mapToEntity(education, dto);
    }

    private VacationRequestEducation mapToEntity(VacationRequestEducation education, VacationRequestEducationRequest dto) {
        education.setBeginDate(dto.beginDate());
        education.setEndDate(dto.endDate());
        education.setInstitutionName(dto.institutionName());
        education.setInstitutionAddress(dto.institutionAddress());
        education.setIsForeignInstitution(dto.isForeignInstitution());
        education.setSpecialization(dto.specialization());
        education.setStatus(statusService.getByCode("CREATED"));
        return education;
    }
}

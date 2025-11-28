package com.fractal.domain.vacation_management.request.education;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationRequest;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationResponse;
import com.fractal.domain.vacation_management.request.education.mapper.VacationRequestEducationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class VacationRequestEducationServiceImpl implements VacationRequestEducationService {

    private final VacationRequestEducationRepository vacationRequestEducationRepository;
    private final VacationRequestEducationMapperService mapperService;
    private final VacationRequestService vacationRequestService;

    @Override
    @Transactional
    public VacationRequestEducation create(Long vacationRequestId, VacationRequestEducationRequest dto) {
        var employee = vacationRequestService.getById(vacationRequestId);
        var education = mapperService.toEntity(dto);
        employee.addEducation(education);
        vacationRequestService.save(employee);
        return education;
    }

    @Override
    public List<VacationRequestEducation> getAllByVacationRequestId(Long vacationRequestId) {
        return vacationRequestEducationRepository.findAllByEmployeeId(vacationRequestId);
    }

    @Override
    public VacationRequestEducation getById(Long vacationRequestId, Long id) {
        return vacationRequestEducationRepository.findByEmployeeIdAndId(vacationRequestId, id).orElseThrow(() -> new ResourceNotFoundException("Education with id: " + id + " not found"));
    }

    @Override
    public VacationRequestEducation getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public VacationRequestEducation update(Long vacationRequestId, Long id, VacationRequestEducationRequest dto) {
        var employee = vacationRequestService.getById(vacationRequestId);
        var education = employee.getEducations()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Education with id: " + id + " not found"));
        education = vacationRequestEducationRepository.save(mapperService.toEntity(education, dto));
        vacationRequestService.save(employee);
        return education;
    }

    @Override
    @Transactional
    public void delete(Long vacationRequestId, Long id) {
        var employee = vacationRequestService.getById(vacationRequestId);
        var education = employee.getEducations()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Education with id: " + id + " not found"));
        employee.removeEducation(education);
        vacationRequestService.save(employee);
    }

    @Override
    public VacationRequestEducationResponse toDTO(VacationRequestEducation vacationRequestEducation) {
        return mapperService.toDTO(vacationRequestEducation);
    }

    private VacationRequestEducation findById(Long id) {
        return vacationRequestEducationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Education History with id: " + id + " not found"));
    }
}

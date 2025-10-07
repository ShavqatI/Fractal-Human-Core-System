package com.fractal.domain.employment.separation_reason;

import com.fractal.domain.employment.EmploymentService;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonResponse;
import com.fractal.domain.employment.separation_reason.mapper.SeparationReasonMapperService;
import com.fractal.domain.employment.separation_reason_type.SeparationReasonTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SeparationReasonServiceImpl implements SeparationReasonService {

    private final SeparationReasonRepository separationReasonRepository;
    private final SeparationReasonMapperService mapperService;
    private final EmploymentService employmentService;
    private final SeparationReasonTypeService separationReasonTypeService;

    @Override
    public SeparationReason create(Long employmentId, SeparationReasonRequest dto) {
        var workExperience = employmentService.getById(employmentId);
        var separationReason = mapperService.toEntity(dto);
        workExperience.addSeparationReason(separationReason);
        employmentService.save(workExperience);
        return separationReason;
    }

    @Override
    public List<SeparationReason> getAllByEmploymentId(Long employmentId) {
        return separationReasonRepository.findAllByEmploymentId(employmentId);
    }

    @Override
    public SeparationReason getById(Long employmentId, Long id) {
        return separationReasonRepository.findByEmploymentIdAndId(employmentId,id).orElseThrow(()-> new ResourceNotFoundException("Separation Reason with id: " + id + " not found"));
    }

    @Override
    public SeparationReason update(Long employmentId, Long id, SeparationReasonRequest dto) {
        var workExperience = employmentService.getById(employmentId);
        var separationReason = workExperience.getSeparationReasons()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Separation Reason  with id: " + id + " not found"));
        separationReason = separationReasonRepository.save(mapperService.toEntity(separationReason,dto));
        employmentService.save(workExperience);
        return separationReason;

    }

    @Override
    public void delete(Long employmentId, Long id) {
        var workExperience = employmentService.getById(employmentId);
        var separationReason = workExperience.getSeparationReasons()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Separation Reason  with id: " + id + " not found"));
        workExperience.removeSeparationReason(separationReason);
        employmentService.save(workExperience);
    }

    @Override
    public SeparationReasonResponse toDTO(SeparationReason separationReason) {
        return new SeparationReasonResponse(
                separationReason.getId(),
                separationReasonTypeService.toCompactDTO(separationReason.getSeparationReasonType()),
                separationReason.getCreatedDate()
        );
    }
}

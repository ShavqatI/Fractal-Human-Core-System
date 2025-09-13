package com.fractal.domain.employment.work_experience.separation_reason;

import com.fractal.domain.employment.separation_reason_type.SeparationReasonTypeService;
import com.fractal.domain.employment.work_experience.WorkExperienceService;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonResponse;
import com.fractal.domain.employment.work_experience.separation_reason.mapper.SeparationReasonMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SeparationReasonServiceImpl implements SeparationReasonService {

    private final SeparationReasonRepository separationReasonRepository;
    private final SeparationReasonMapperService mapperService;
    private final WorkExperienceService workExperienceService;
    private final SeparationReasonTypeService separationReasonTypeService;

    @Override
    public SeparationReason create(Long workExperienceId, SeparationReasonRequest dto) {
        var workExperience = workExperienceService.getById(workExperienceId);
        var separationReason = mapperService.toEntity(dto);
        workExperience.addSeparationReason(separationReason);
        workExperienceService.save(workExperience);
        return separationReason;
    }

    @Override
    public List<SeparationReason> getAllByWorkExperienceId(Long workExperienceId) {
        return separationReasonRepository.findAllByWorkExperienceId(workExperienceId);
    }

    @Override
    public SeparationReason getById(Long workExperienceId, Long id) {
        return separationReasonRepository.findByWorkExperienceIdAndId(workExperienceId,id).orElseThrow(()-> new ResourceNotFoundException("Separation Reason with id: " + id + " not found"));
    }

    @Override
    public SeparationReason update(Long workExperienceId, Long id, SeparationReasonRequest dto) {
        var workExperience = workExperienceService.getById(workExperienceId);
        var separationReason = workExperience.getSeparationReasons()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Separation Reason  with id: " + id + " not found"));
        separationReason = separationReasonRepository.save(mapperService.toEntity(separationReason,dto));
        workExperienceService.save(workExperience);
        return separationReason;

    }

    @Override
    public void delete(Long workExperienceId, Long id) {
        var workExperience = workExperienceService.getById(workExperienceId);
        var separationReason = workExperience.getSeparationReasons()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Separation Reason  with id: " + id + " not found"));
        workExperience.removeSeparationReason(separationReason);
        workExperienceService.save(workExperience);
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

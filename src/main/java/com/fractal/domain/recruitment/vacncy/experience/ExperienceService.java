package com.fractal.domain.recruitment.vacncy.experience;

import com.fractal.domain.recruitment.vacncy.experience.dto.ExperienceRequest;
import com.fractal.domain.recruitment.vacncy.experience.dto.ExperienceResponse;

public interface ExperienceService {
    ExperienceResponse toDTO(Experience experience);
    Experience toEntity(ExperienceRequest dto);

    Experience findById(Long id);
    Experience update(Long id, ExperienceRequest dto);

     void delete(Experience experience);
}

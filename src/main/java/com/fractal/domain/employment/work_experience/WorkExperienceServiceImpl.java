package com.fractal.domain.employment.work_experience;

import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class WorkExperienceServiceImpl implements WorkExperienceService {

    private final WorkExperienceRepository workExperienceRepository;

    @Override
    public WorkExperience getById(Long id) {
        return workExperienceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Work Experience with id: " + id + " not found"));
    }

    @Override
    public WorkExperience save(WorkExperience workExperience) {
        try {
            return workExperienceRepository.save(workExperience);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}

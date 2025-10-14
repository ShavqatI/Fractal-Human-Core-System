package com.fractal.domain.learning_develpment.learning.instructor.external;

import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.mapper.ExternalInstructorMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ExternalInstructorServiceImpl implements ExternalInstructorService {

    private final ExternalInstructorRepository instructorRepository;
    private final ExternalInstructorMapperService mapperService;

    @Override
    @Transactional
    public ExternalInstructor create(ExternalInstructorRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<ExternalInstructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public ExternalInstructor getById(Long id) {
        return findById(id);
    }



    @Override
    @Transactional
    public ExternalInstructor update(Long id, ExternalInstructorRequest dto) {
        try {
            ExternalInstructor trainer = mapperService.toEntity(findById(id),dto);
            return save(trainer);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      instructorRepository.delete(findById(id));
    }

    @Override
    public ExternalInstructorResponse toDTO(ExternalInstructor instructor) {
        return mapperService.toDTO(instructor);
    }

    @Override
    public ExternalInstructorCompactResponse toCompactDTO(ExternalInstructor instructor) {
        return mapperService.toCompactDTO(instructor);
    }

    /*@Override
    public InstructorCompactResponse toCompactDTO(Instructor instructor) {
        return mapperService.toCompactDTO(instructor);
    }*/


    @Override
    @Transactional
    public ExternalInstructor save(ExternalInstructor instructor) {
        try {
            return instructorRepository.save(instructor);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ExternalInstructor findById(Long id) {
        return instructorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("External Instructor with id: " + id + " not found"));
    }
}

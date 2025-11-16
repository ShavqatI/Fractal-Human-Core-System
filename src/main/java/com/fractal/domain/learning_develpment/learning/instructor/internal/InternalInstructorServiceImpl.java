package com.fractal.domain.learning_develpment.learning.instructor.internal;

import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorResponse;
import com.fractal.domain.learning_develpment.learning.instructor.internal.mapper.InternalInstructorMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
class InternalInstructorServiceImpl implements InternalInstructorService {

    private final InternalInstructorRepository instructorRepository;
    private final InternalInstructorMapperService mapperService;

    @Override
    @Transactional
    public InternalInstructor create(InternalInstructorRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InternalInstructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public InternalInstructor getById(Long id) {
        return findById(id);
    }

    /*@Override
    public InstructorCompactResponse toCompactDTO(Instructor instructor) {
        return mapperService.toCompactDTO(instructor);
    }*/

    @Override
    public InternalInstructor update(Long id, InternalInstructorRequest dto) {
        try {
            InternalInstructor trainer = mapperService.toEntity(findById(id), dto);
            return save(trainer);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        instructorRepository.delete(findById(id));
    }

    @Override
    public InternalInstructorResponse toDTO(InternalInstructor instructor) {
        return mapperService.toDTO(instructor);
    }

    @Override
    public InternalInstructorCompactResponse toCompactDTO(InternalInstructor instructor) {
        return mapperService.toCompactDTO(instructor);
    }


    private InternalInstructor save(InternalInstructor trainer) {
        try {
            return instructorRepository.save(trainer);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InternalInstructor findById(Long id) {
        return instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Internal Instructor with id: " + id + " not found"));
    }
}

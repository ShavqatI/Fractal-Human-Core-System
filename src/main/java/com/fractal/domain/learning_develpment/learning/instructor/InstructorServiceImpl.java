package com.fractal.domain.learning_develpment.learning.instructor;

import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.mapper.InstructorMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapperService mapperService;
    @Override
    public Instructor getById(Long id) {
        return instructorRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));

    }
    @Override
    public InstructorCompactResponse toCompactDTO(Instructor instructor) {
        return mapperService.toCompactDTO(instructor);
    }
}

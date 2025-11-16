package com.fractal.domain.learning_develpment.learning.session.instructor.type;

import com.fractal.domain.learning_develpment.learning.session.instructor.type.dto.InstructorAssignmentTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.type.dto.InstructorAssignmentTypeResponse;

import java.util.List;

public interface InstructorAssignmentTypeService {

    InstructorAssignmentType create(InstructorAssignmentTypeRequest dto);

    List<InstructorAssignmentType> getAll();

    InstructorAssignmentType getByCode(String code);

    InstructorAssignmentType getById(Long id);

    InstructorAssignmentType update(Long id, InstructorAssignmentTypeRequest dto);

    void deleteById(Long id);

    InstructorAssignmentTypeResponse toDTO(InstructorAssignmentType instructorAssignmentType);
}

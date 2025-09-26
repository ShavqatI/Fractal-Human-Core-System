package com.fractal.domain.learning_develpment.learning.session.instructor.type;

import com.fractal.domain.learning_develpment.learning.session.instructor.type.dto.InstructorAssignmentTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.type.dto.InstructorAssignmentTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class InstructorAssignmentTypeServiceImpl implements InstructorAssignmentTypeService {

    private final InstructorAssignmentTypeRepository instructorAssignmentTypeRepository;

    @Override
    public InstructorAssignmentType create(InstructorAssignmentTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<InstructorAssignmentType> getAll() {
        return instructorAssignmentTypeRepository.findAll();
    }

    @Override
    public InstructorAssignmentType getByCode(String code) {
        return instructorAssignmentTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Instructor Assignment Type with code: " + code + " not found"));
    }

    @Override
    public InstructorAssignmentType getById(Long id) {
        return findById(id);
    }

    @Override
    public InstructorAssignmentType update(Long id, InstructorAssignmentTypeRequest dto) {
        try {
            InstructorAssignmentType instructorAssignmentType = findById(id);
            instructorAssignmentType.setCode(dto.code());
            instructorAssignmentType.setName(dto.name());
            return save(instructorAssignmentType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        instructorAssignmentTypeRepository.delete(findById(id));
    }

    @Override
    public InstructorAssignmentTypeResponse toDTO(InstructorAssignmentType instructorAssignmentType) {
        return new InstructorAssignmentTypeResponse(
                instructorAssignmentType.getId(),
                instructorAssignmentType.getCode(),
                instructorAssignmentType.getName(),
                instructorAssignmentType.getCreatedDate()
        );
    }

    private InstructorAssignmentType toEntity(InstructorAssignmentTypeRequest dto) {
        return InstructorAssignmentType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private InstructorAssignmentType save(InstructorAssignmentType instructorAssignmentType) {
        try {
            return instructorAssignmentTypeRepository.save(instructorAssignmentType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InstructorAssignmentType findById(Long id) {
        return instructorAssignmentTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Instructor Assignment Type with id: " + id + " not found"));
    }
}

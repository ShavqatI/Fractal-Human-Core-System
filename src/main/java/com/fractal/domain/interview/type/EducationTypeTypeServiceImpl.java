package com.fractal.domain.interview.type;

import com.fractal.domain.interview.type.dto.InterviewTypeRequest;
import com.fractal.domain.interview.type.dto.InterviewTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class EducationTypeTypeServiceImpl implements InterviewTypeService {

    private final InterviewTypeRepository interviewTypeRepository;

    @Override
    public InterviewType create(InterviewTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<InterviewType> getAll() {
        return interviewTypeRepository.findAll();
    }

    @Override
    public InterviewType getByCode(String code) {
        return interviewTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Interview Type with code: " + code + " not found"));
    }

    @Override
    public InterviewType getById(Long id) {
        return findById(id);
    }

    @Override
    public InterviewType update(Long id, InterviewTypeRequest dto) {
        try {
            InterviewType interviewType = findById(id);
            interviewType.setCode(dto.code());
            interviewType.setName(dto.name());
            return save(interviewType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      interviewTypeRepository.delete(findById(id));
    }

    @Override
    public InterviewTypeResponse toDTO(InterviewType interviewType) {
        return new InterviewTypeResponse(
                interviewType.getId(),
                interviewType.getCode(),
                interviewType.getName(),
                interviewType.getCreatedDate()
        );
    }

    private InterviewType toEntity(InterviewTypeRequest dto) {
        return InterviewType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private InterviewType save(InterviewType interviewType) {
        try {
            return interviewTypeRepository.save(interviewType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InterviewType findById(Long id) {
        return interviewTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Type with id: " + id + " not found"));
    }

}

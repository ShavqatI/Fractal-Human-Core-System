package com.fractal.domain.organization_management.grade.method.type;

import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeCompactResponse;
import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeRequest;
import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeResponse;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class GradingEvaluationTypeServiceImpl implements GradingEvaluationTypeService {

    private final GradingEvaluationTypeRepository gradingEvaluationTypeRepository;

    @Override
    public GradingEvaluationType create(GradingEvaluationTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<GradingEvaluationType> getAll() {
        return gradingEvaluationTypeRepository.findAll();
    }

    @Override
    public GradingEvaluationType getByCode(String code) {
        return gradingEvaluationTypeRepository.findByCode(code).orElseThrow(()-> new ResourceWithCodeNotFoundException(this,code));
    }

    @Override
    public GradingEvaluationType getById(Long id) {
        return findById(id);
    }

    @Override
    public GradingEvaluationType update(Long id, GradingEvaluationTypeRequest dto) {
        try {
            GradingEvaluationType gradingEvaluationType = findById(id);
            gradingEvaluationType.setCode(dto.code());
            gradingEvaluationType.setName(dto.name());
            return save(gradingEvaluationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      gradingEvaluationTypeRepository.delete(findById(id));
    }

    @Override
    public GradingEvaluationTypeResponse toDTO(GradingEvaluationType gradingEvaluationType) {
        return new GradingEvaluationTypeResponse(
                gradingEvaluationType.getId(),
                gradingEvaluationType.getCode(),
                gradingEvaluationType.getName(),
                gradingEvaluationType.getCreatedDate()
        );
    }

    @Override
    public GradingEvaluationTypeCompactResponse toCompactDTO(GradingEvaluationType gradingEvaluationType) {
        return new GradingEvaluationTypeCompactResponse(
                gradingEvaluationType.getId(),
                gradingEvaluationType.getCode(),
                gradingEvaluationType.getName()
        );
    }

    private GradingEvaluationType toEntity(GradingEvaluationTypeRequest dto) {
        return GradingEvaluationType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private GradingEvaluationType save(GradingEvaluationType gradingEvaluationType) {
        try {
            return gradingEvaluationTypeRepository.save(gradingEvaluationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private GradingEvaluationType findById(Long id) {
        return gradingEvaluationTypeRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

}

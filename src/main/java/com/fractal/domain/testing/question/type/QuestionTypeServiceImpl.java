package com.fractal.domain.testing.question.type;

import com.fractal.domain.testing.question.type.dto.QuestionTypeRequest;
import com.fractal.domain.testing.question.type.dto.QuestionTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class QuestionTypeServiceImpl implements QuestionTypeService {

    private final QuestionTypeRepository questionTypeRepository;
    @Override
    public QuestionType create(QuestionTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public QuestionType update(Long id, QuestionTypeRequest dto) {
        try {
            QuestionType questionType = findById(id);
            questionType.setCode(dto.code());
            questionType.setName(dto.name());
            return save(questionType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<QuestionType> getAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public QuestionType getByCode(String code) {
        return questionTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Question Type with code: " + code + " not found"));
    }

    @Override
    public QuestionType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       questionTypeRepository.delete(findById(id));
    }

    @Override
    public QuestionTypeResponse toDTO(QuestionType questionType) {
        return new QuestionTypeResponse(
                questionType.getId(),
                questionType.getCode(),
                questionType.getName(),
                questionType.getCreatedDate()
        );
    }
    private QuestionType toEntity(QuestionTypeRequest dto) {
        return QuestionType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private QuestionType save(QuestionType questionType) {
        try {
            return questionTypeRepository.save(questionType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private QuestionType findById(Long id) {
        return questionTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question Type with id: " + id + " not found"));
    }

}

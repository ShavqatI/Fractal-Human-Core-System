package com.fractal.domain.employee_management.relative.type;

import com.fractal.domain.employee_management.relative.type.dto.RelationTypeRequest;
import com.fractal.domain.employee_management.relative.type.dto.RelationTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class RelationTypeServiceImpl implements RelationTypeService {

    private final RelationTypeRepository relationTypeRepository;

    @Override
    public RelationType create(RelationTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<RelationType> getAll() {
        return relationTypeRepository.findAll();
    }

    @Override
    public RelationType getByCode(String code) {
        return relationTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public RelationType getById(Long id) {
        return findById(id);
    }

    @Override
    public RelationType update(Long id, RelationTypeRequest dto) {
        try {
            RelationType relationType = findById(id);
            relationType.setCode(dto.code());
            relationType.setName(dto.name());
            return save(relationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      relationTypeRepository.delete(findById(id));
    }

    @Override
    public RelationTypeResponse toDTO(RelationType relationType) {
        return new RelationTypeResponse(
                relationType.getId(),
                relationType.getCode(),
                relationType.getName(),
                relationType.getCreatedDate()
        );
    }

    private RelationType toEntity(RelationTypeRequest dto) {
        return RelationType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private RelationType save(RelationType relationType) {
        try {
            return relationTypeRepository.save(relationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private RelationType findById(Long id) {
        return relationTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Relation Type with id: " + id + " not found"));
    }

}

package com.fractal.domain.navigation.action.type;

import com.fractal.domain.navigation.action.type.dto.ActionTypeRequest;
import com.fractal.domain.navigation.action.type.dto.ActionTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class ActionTypeServiceImpl implements ActionTypeService {

    private final ActionTypeRepository actionTypeRepository;

    @Override
    public ActionType create(ActionTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ActionType> getAll() {
        return actionTypeRepository.findAll();
    }

    @Override
    public ActionType getByCode(String code) {
        return actionTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Action Type with code: " + code + " not found"));
    }

    @Override
    public ActionType getById(Long id) {
        return findById(id);
    }

    @Override
    public ActionType update(Long id, ActionTypeRequest dto) {
        try {
            ActionType actionType = findById(id);
            actionType.setCode(dto.code());
            actionType.setName(dto.name());
            return save(actionType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      actionTypeRepository.delete(findById(id));
    }

    @Override
    public ActionTypeResponse toDTO(ActionType actionType) {
        return new ActionTypeResponse(
                actionType.getId(),
                actionType.getCode(),
                actionType.getName(),
                actionType.getCreatedDate()
        );
    }

    private ActionType toEntity(ActionTypeRequest dto) {
        return ActionType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private ActionType save(ActionType actionType) {
        try {
            return actionTypeRepository.save(actionType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ActionType findById(Long id) {
        return actionTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Action Type with id: " + id + " not found"));
    }

}

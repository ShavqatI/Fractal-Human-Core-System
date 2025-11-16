package com.fractal.domain.navigation.action;

import com.fractal.domain.navigation.action.dto.ActionCompactResponse;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;
import com.fractal.domain.navigation.action.mapper.ActionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ActionServiceImpl implements ActionService {

    private final ActionMapperService mapperService;
    private final ActionRepository actionRepository;

    @Override
    @Transactional
    public Action create(ActionRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Action> getAll() {
        return actionRepository.findAll();
    }

    @Override
    public Action getByUrl(String url) {
        return actionRepository.findByUrl(url).orElseThrow(() -> new ResourceNotFoundException("Action with url: " + url + " not found"));
    }

    @Override
    public Action getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Action update(Long id, ActionRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id), dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        actionRepository.delete(findById(id));
    }

    @Override
    public ActionResponse toDTO(Action action) {
        return mapperService.toDTO(action);
    }

    @Override
    public ActionCompactResponse toCompactDTO(Action action) {
        return mapperService.toCompactDTO(action);
    }

    public Action save(Action action) {
        try {
            return actionRepository.save(action);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Action findById(Long id) {
        return actionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Action with id: " + id + " not found"));
    }
}

package com.fractal.domain.learning_develpment.learning.learner.external;

import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.mapper.ExternalLearnerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ExternalLearnerServiceImpl implements ExternalLearnerService {

    private final ExternalLearnerRepository participantRepository;
    private final ExternalLearnerMapperService mapperService;

    @Override
    @Transactional
    public ExternalLearner create(ExternalLearnerRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<ExternalLearner> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public ExternalLearner getById(Long id) {
        return findById(id);
    }


    @Override
    @Transactional
    public ExternalLearner update(Long id, ExternalLearnerRequest dto) {
        try {
            ExternalLearner participant = mapperService.toEntity(findById(id), dto);
            return save(participant);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        participantRepository.delete(findById(id));
    }

    @Override
    public ExternalLearnerResponse toDTO(ExternalLearner learner) {
        return mapperService.toDTO(learner);
    }

    @Override
    public ExternalLearnerCompactResponse toCompactDTO(ExternalLearner learner) {
        return mapperService.toCompactDTO(learner);
    }

    @Override
    @Transactional
    public ExternalLearner save(ExternalLearner learner) {
        try {
            return participantRepository.save(learner);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ExternalLearner findById(Long id) {
        return participantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("External Learner with id: " + id + " not found"));
    }
}

package com.fractal.domain.training_management.participant.external;

import com.fractal.domain.training_management.participant.Participant;
import com.fractal.domain.training_management.participant.ParticipantService;
import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantRequest;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantResponse;
import com.fractal.domain.training_management.participant.external.mapper.ExternalParticipantMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ExternalParticipantServiceImpl implements ExternalParticipantService, ParticipantService {

    private final ExternalParticipantRepository participantRepository;
    private final ExternalParticipantMapperService mapperService;

    @Override
    @Transactional
    public ExternalParticipant create(ExternalParticipantRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<ExternalParticipant> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public ExternalParticipant getById(Long id) {
        return findById(id);
    }



    @Override
    @Transactional
    public ExternalParticipant update(Long id, ExternalParticipantRequest dto) {
        try {
            ExternalParticipant participant = mapperService.toEntity(findById(id),dto);
            return save(participant);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      participantRepository.delete(findById(id));
    }

    @Override
    public ExternalParticipantResponse toDTO(ExternalParticipant trainer) {
        return mapperService.toDTO(trainer);
    }

    @Override
    public ExternalParticipantCompactResponse toCompactDTO(ExternalParticipant trainer) {
        return mapperService.toCompactDTO(trainer);
    }

    @Override
    public ParticipantCompactResponse toCompactDTO(Participant participant) {
        return mapperService.toCompactDTO(participant);
    }


    @Override
    @Transactional
    public ExternalParticipant save(ExternalParticipant trainer) {
        try {
            return participantRepository.save(trainer);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ExternalParticipant findById(Long id) {
        return participantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("External Trainer with id: " + id + " not found"));
    }
}

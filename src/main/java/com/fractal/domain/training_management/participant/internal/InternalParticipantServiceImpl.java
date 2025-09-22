package com.fractal.domain.training_management.participant.internal;

import com.fractal.domain.training_management.participant.Participant;
import com.fractal.domain.training_management.participant.ParticipantService;
import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantRequest;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantResponse;
import com.fractal.domain.training_management.participant.internal.mapper.InternalParticipantMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
class InternalParticipantServiceImpl implements InternalParticipantService, ParticipantService {

    private final InternalParticipantRepository participantRepository;
    private final InternalParticipantMapperService mapperService;

    @Override
    @Transactional
    public InternalParticipant create(InternalParticipantRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InternalParticipant> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public InternalParticipant getById(Long id) {
        return findById(id);
    }

    @Override
    public ParticipantCompactResponse toCompactDTO(Participant participant) {
        return mapperService.toCompactDTO(participant);
    }

    @Override
    public InternalParticipant update(Long id, InternalParticipantRequest dto) {
        try {
            InternalParticipant participant = mapperService.toEntity(findById(id),dto);
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
    public InternalParticipantResponse toDTO(InternalParticipant trainer) {
        return mapperService.toDTO(trainer);
    }

    @Override
    public InternalParticipantCompactResponse toCompactDTO(InternalParticipant trainer) {
        return mapperService.toCompactDTO(trainer);
    }


    private InternalParticipant save(InternalParticipant trainer) {
        try {
            return participantRepository.save(trainer);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InternalParticipant findById(Long id) {
        return participantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Internal Trainer with id: " + id + " not found"));
    }
}

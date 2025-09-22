package com.fractal.domain.training_management.participant.external.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExternalParticipantContactRepository extends JpaRepository<ExternalParticipantContact,Long> {

    List<ExternalParticipantContact> findAllByExternalParticipantId(Long participantId);
    Optional<ExternalParticipantContact> findByExternalParticipantIdAndId(Long participantId, Long id);
}

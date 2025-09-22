package com.fractal.domain.training_management.participant.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExternalParticipantRepository extends JpaRepository<ExternalParticipant,Long> {

}

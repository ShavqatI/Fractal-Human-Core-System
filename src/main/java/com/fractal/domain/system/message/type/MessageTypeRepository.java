package com.fractal.domain.system.message.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface MessageTypeRepository extends JpaRepository<MessageType, Long> {
    Optional<MessageType> findByCode(String code);

}

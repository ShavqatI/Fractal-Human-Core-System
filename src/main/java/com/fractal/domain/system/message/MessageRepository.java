package com.fractal.domain.system.message;

import com.fractal.domain.system.message.type.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findByCode(String code);

}

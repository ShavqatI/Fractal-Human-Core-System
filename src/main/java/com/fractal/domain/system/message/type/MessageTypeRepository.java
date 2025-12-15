package com.fractal.domain.system.message.type;

import com.fractal.domain.insurance.type.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface MessageTypeRepository extends JpaRepository<MessageType, Long> {
    Optional<MessageType> findByCode(String code);

}

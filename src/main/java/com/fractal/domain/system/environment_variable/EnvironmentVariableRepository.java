package com.fractal.domain.system.environment_variable;

import com.fractal.domain.system.message.type.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface EnvironmentVariableRepository extends JpaRepository<EnvironmentVariable, Long> {
    Optional<EnvironmentVariable> findByCode(String code);

}

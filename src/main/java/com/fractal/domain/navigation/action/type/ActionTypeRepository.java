package com.fractal.domain.navigation.action.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ActionTypeRepository extends JpaRepository<ActionType, Long> {
    Optional<ActionType> findByCode(String code);

}

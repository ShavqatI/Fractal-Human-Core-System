package com.fractal.domain.navigation.action.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ActionCategoryRepository extends JpaRepository<ActionCategory, Long> {
    Optional<ActionCategory> findByCode(String code);

}

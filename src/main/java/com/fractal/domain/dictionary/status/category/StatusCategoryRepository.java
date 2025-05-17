package com.fractal.domain.dictionary.status.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface StatusCategoryRepository extends JpaRepository<StatusCategory,Long> {
    Optional<StatusCategory> findById(Long id);
    Optional<StatusCategory> findByCode(String code);
    List<StatusCategory> findAll();
}

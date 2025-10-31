package com.fractal.domain.dictionary.industry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface IndustryRepository extends JpaRepository<Industry,Long> {
    Optional<Industry> findById(Long id);
    Optional<Industry> findByCode(String code);
    List<Industry> findAll();
}

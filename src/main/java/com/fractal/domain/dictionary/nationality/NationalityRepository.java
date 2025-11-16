package com.fractal.domain.dictionary.nationality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface NationalityRepository extends JpaRepository<Nationality, Long> {
    Optional<Nationality> findById(Long id);

    Optional<Nationality> findByCode(String code);

    List<Nationality> findAll();
}

package com.fractal.domain.localization.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface LanguageRepository extends JpaRepository<Language,Long> {
    Optional<Language> findByCode(String code);
}

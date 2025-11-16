package com.fractal.domain.education.language_skill.proficiency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface LanguageProficiencyRepository extends JpaRepository<LanguageProficiency, Long> {

    Optional<LanguageProficiency> findByCode(String code);

}

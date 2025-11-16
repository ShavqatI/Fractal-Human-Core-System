package com.fractal.domain.testing.question.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {

    QuestionType save(QuestionType questionType);

    List<QuestionType> findAll();

    Optional<QuestionType> findByCode(String code);

    Optional<QuestionType> findById(Long id);

}

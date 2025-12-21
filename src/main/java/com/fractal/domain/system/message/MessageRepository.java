package com.fractal.domain.system.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findByCode(String code);
    Optional<Message> findByCodeAndLanguageAndCode(String code,String languageCode);

}

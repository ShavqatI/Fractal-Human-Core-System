package com.fractal.domain.system.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findByCode(String code);
    @Query("""
select m from Message m 
where m.code = :code 
and m.language.code = :languageCode
""")
    Optional<Message> findByCodeAndLanguageCode(String code,String languageCode);

    List<Message> findByCodeInAndLanguageCode(List<String> codes, String languageCode);
}

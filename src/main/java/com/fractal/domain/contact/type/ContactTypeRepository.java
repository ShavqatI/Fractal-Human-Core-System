package com.fractal.domain.contact.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface ContactTypeRepository extends JpaRepository<ContactType,Long> {
    Optional<ContactType> findById(Long id);
    Optional<ContactType> findByCode(String code);
    List<ContactType> findAll();
}

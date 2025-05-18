package com.fractal.domain.dictionary.marital_status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface MaritalStatusRepository extends JpaRepository<MaritalStatus,Long> {
    Optional<MaritalStatus> findById(Long id);
    Optional<MaritalStatus> findByCode(String code);
    List<MaritalStatus> findAll();
}

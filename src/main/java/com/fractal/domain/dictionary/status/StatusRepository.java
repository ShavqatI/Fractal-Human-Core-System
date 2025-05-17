package com.fractal.domain.dictionary.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface StatusRepository extends JpaRepository<Status,Long> {

    Optional<Status> findById(Long id);
    Optional<Status> findByCode(String code);
    List<Status> findAll();
}

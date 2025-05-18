package com.fractal.domain.dictionary.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CurrencyRepository extends JpaRepository<Currency,Long> {
    Optional<Currency> findById(Long id);
    Optional<Currency> findByCode(String code);
    List<Currency> findAll();
}

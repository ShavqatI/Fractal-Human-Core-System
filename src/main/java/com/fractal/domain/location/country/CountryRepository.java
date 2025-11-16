package com.fractal.domain.location.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CountryRepository extends JpaRepository<Country, Long> {

    Country save(Country country);

    List<Country> findAll();

    Optional<Country> findByCode(String code);

    Optional<Country> findById(Long id);

}

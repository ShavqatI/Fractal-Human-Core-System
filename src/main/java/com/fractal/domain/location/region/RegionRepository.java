package com.fractal.domain.location.region;

import com.fractal.domain.location.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface RegionRepository extends JpaRepository<Region,Long> {

    Region save(Region region);
    List<Region> findAll();
    List<Region> findByCountry(Country country);
    Optional<Region> findByCode(String code);
    Optional<Region> findById(Long id);

}

package com.fractal.domain.location.city;

import com.fractal.domain.location.region.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CityRepository extends JpaRepository<City,Long> {

    City save(City city);
    List<City> findAll();
    List<City> findByRegion(Region region);
    Optional<City> findByCode(String code);
    Optional<City> findById(Long id);

}

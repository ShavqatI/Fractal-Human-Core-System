package com.fractal.domain.location.district;

import com.fractal.domain.location.city.City;
import com.fractal.domain.location.region.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DistrictRepository extends JpaRepository<District, Long> {

    District save(District district);

    List<District> findAll();

    List<District> findByRegion(Region region);

    List<District> findByCity(City region);

    Optional<District> findByCode(String code);

    Optional<District> findById(Long id);

}

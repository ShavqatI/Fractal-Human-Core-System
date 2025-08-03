package com.fractal.domain.location.city;

import com.fractal.domain.location.city.dto.CityCompactResponse;
import com.fractal.domain.location.city.dto.CityRequest;
import com.fractal.domain.location.city.dto.CityResponse;

import java.util.List;

public interface CityService {
   City create(CityRequest dto);
   List<City> getAll();
   List<City> getByRegionId(Long regionId);
   City getByCode(String code);
   City getById(Long id);
   City update(Long id, CityRequest dto);
   void deleteById(Long id);
   CityResponse toDTO(City city);
   CityCompactResponse toCompactDTO(City city);
}

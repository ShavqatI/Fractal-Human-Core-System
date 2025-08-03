package com.fractal.domain.location.city;

import com.fractal.domain.location.city.dto.CityCompactResponse;
import com.fractal.domain.location.city.dto.CityRequest;
import com.fractal.domain.location.city.dto.CityResponse;
import com.fractal.domain.location.region.RegionService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final RegionService regionService;

    @Override
    public City create(CityRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> getByRegionId(Long regionId) {
        return cityRepository.findByRegion(regionService.getById(regionId));
    }

    @Override
    public City getByCode(String code) {
        return cityRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("City with code: " + code + " not found"));
    }

    @Override
    public City getById(Long id) {
      return findById(id);
    }

    @Override
    public City update(Long id, CityRequest dto) {
        try {
            City city = findById(id);
            city.setCode(dto.code());
            city.setName(dto.name());
            city.setRegion(regionService.getById(dto.regionId()));
            return save(city);
        }
        catch (DataAccessException e){
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       cityRepository.delete(findById(id));
    }

    @Override
    public CityResponse toDTO(City city) {
        return new CityResponse(
                city.getId(),
                city.getCode(),
                city.getName(),
                regionService.toDTO(city.getRegion()),
                city.getCreatedDate()
        );
    }

    @Override
    public CityCompactResponse toCompactDTO(City city) {
        return new CityCompactResponse(
                city.getId(),
                city.getCode(),
                city.getName()
        );
    }

    private City toEntity(CityRequest dto) {
        return City.builder()
                .code(dto.code())
                .name(dto.name())
                .region(regionService.getById(dto.regionId()))
                .build();
    }

    private City save(City city) {
        try {
            return cityRepository.save(city);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("City with id: " + id + " not found"));
    }
}

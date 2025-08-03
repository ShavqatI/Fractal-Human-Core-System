package com.fractal.domain.location.region;


import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.region.dto.RegionCompactResponse;
import com.fractal.domain.location.region.dto.RegionRequest;
import com.fractal.domain.location.region.dto.RegionResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final CountryService countryService;

    @Override
    public Region create(RegionRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @Override
    public List<Region> getByCountryId(Long countryId) {
        return regionRepository.findByCountry(countryService.getById(countryId));
    }

    @Override
    public Region getByCode(String code) {
        return regionRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Region with code: " + code + " not found"));
    }

    @Override
    public Region getById(Long id) {
        return findById(id);
    }

    @Override
    public Region update(Long id, RegionRequest dto) {
        try {
            Region region = findById(id);
            region.setCode(dto.code());
            region.setName(dto.name());
            region.setCountry(countryService.getById(dto.countryId()));
            return save(region);
        }
        catch (DataAccessException e){
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      regionRepository.delete(findById(id));
    }

    @Override
    public RegionResponse toDTO(Region region) {
        return new RegionResponse(
                region.getId(),
                region.getCode(),
                region.getName(),
                countryService.toDTO(region.getCountry()),
                region.getCreatedDate()
        );
    }

    @Override
    public RegionCompactResponse toCompactDTO(Region region) {
        return new RegionCompactResponse(
                region.getId(),
                region.getCode(),
                region.getName()
        );
    }

    private Region toEntity(RegionRequest dto) {
        return Region.builder()
                .code(dto.code())
                .name(dto.name())
                .country(countryService.getById(dto.countryId()))
                .build();
    }

    private Region save(Region region) {
        try {
            return regionRepository.save(region);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Region findById(Long id) {
        return regionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Region with id: " + id + " not found"));
    }
}

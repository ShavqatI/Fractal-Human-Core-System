package com.fractal.domain.location.region;


import com.fractal.domain.location.country.CountryService;
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
    public Region getByCode(String code) {
        return regionRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Region with code: " + code + " not found"));
    }

    @Override
    public Region getById(Long id) {
        return findById(id);
    }

    @Override
    public Region update(Long id, RegionRequest dto) {
        return null;
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
                region.getCountry().getName(),
                region.getCreatedDate()
        );
    }

    private Region toEntity(RegionRequest dto) {
        return Region.builder()
                .code(dto.code())
                .name(dto.name())
                .country(countryService.getById(dto.country()))
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

package com.fractal.domain.location.district;

import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.district.dto.DistrictCompactResponse;
import com.fractal.domain.location.district.dto.DistrictRequest;
import com.fractal.domain.location.district.dto.DistrictResponse;
import com.fractal.domain.location.area_type.AreaTypeService;
import com.fractal.domain.location.region.RegionService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final RegionService regionService;
    private final CityService cityService;
    private final AreaTypeService areaTypeService;

    @Override
    public District create(DistrictRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<District> getAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<District> getByRegionId(Long regionId) {
        return districtRepository.findByRegion(regionService.getById(regionId));
    }

    @Override
    public List<District> getByCityId(Long cityId) {
        return districtRepository.findByCity(cityService.getById(cityId));
    }

    @Override
    public District getByCode(String code) {
        return districtRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("District with code: " + code + " not found"));
    }

    @Override
    public District getById(Long id) {
        return findById(id);
    }

    @Override
    public District update(Long id, DistrictRequest dto) {
        try {
            District district = findById(id);
            district.setCode(dto.code());
            district.setName(dto.name());
            district.setCity(dto.cityId() != null ? cityService.getById(dto.cityId()) : null);
            district.setRegion(regionService.getById(dto.regionId()));
            district.setAreaType(areaTypeService.getById(dto.areaTypeId()));
            return save(district);
        }
        catch (DataAccessException e){
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      districtRepository.delete(findById(id));
    }

    @Override
    public DistrictResponse toDTO(District district) {
        return new DistrictResponse(
                district.getId(),
                district.getCode(),
                district.getName(),
                Optional.ofNullable(district.getCity())
                        .map(cityService::toDTO)
                        .orElse(null),
                regionService.toDTO(district.getRegion()),
                areaTypeService.toDTO(district.getAreaType()),
                district.getCreatedDate()
        );
    }

    @Override
    public DistrictCompactResponse toCompactDTO(District district) {
        return new DistrictCompactResponse(
                district.getId(),
                district.getCode(),
                district.getName()
        );
    }

    private District toEntity(DistrictRequest dto) {
        return District.builder()
                .code(dto.code())
                .name(dto.name())
                .city(dto.cityId() != null ? cityService.getById(dto.cityId()) : null)
                .region(regionService.getById(dto.regionId()))
                .build();
    }

    private District save(District district) {
        try {
            return districtRepository.save(district);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private District findById(Long id) {
        return districtRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("District with id: " + id + " not found"));
    }
}

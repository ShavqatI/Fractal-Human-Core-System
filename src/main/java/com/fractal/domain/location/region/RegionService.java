package com.fractal.domain.location.region;

import com.fractal.domain.location.region.dto.RegionRequest;
import com.fractal.domain.location.region.dto.RegionResponse;

import java.util.List;

public interface RegionService {
   Region create(RegionRequest dto);
   List<Region> getAll();
   Region getByCode(String code);
   Region getById(Long id);
   Region update(Long id, RegionRequest dto);
   void deleteById(Long id);
   RegionResponse toDTO(Region region);
}

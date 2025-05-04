package com.fractal.domain.location.district;

import com.fractal.domain.location.district.dto.DistrictRequest;
import com.fractal.domain.location.district.dto.DistrictResponse;

import java.util.List;

public interface DistrictService {
   District create(DistrictRequest dto);
   List<District> getAll();
   List<District> getByRegionId(Long regionId);
   List<District> getByCityId(Long cityId);
   District getByCode(String code);
   District getById(Long id);
   District update(Long id, DistrictRequest dto);
   void deleteById(Long id);
   DistrictResponse toDTO(District district);
}

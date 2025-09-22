package com.fractal.domain.training_management.training.location.online.platform;

import com.fractal.domain.training_management.training.location.online.platform.dto.OnlinePlatformRequest;
import com.fractal.domain.training_management.training.location.online.platform.dto.OnlinePlatformResponse;

import java.util.List;

public interface OnlinePlatformService {
   OnlinePlatform create(OnlinePlatformRequest dto);
   List<OnlinePlatform> getAll();
   OnlinePlatform getByCode(String code);
   OnlinePlatform getById(Long id);
   OnlinePlatform update(Long id, OnlinePlatformRequest dto);
   void deleteById(Long id);
   OnlinePlatformResponse toDTO(OnlinePlatform onlinePlatform);
}

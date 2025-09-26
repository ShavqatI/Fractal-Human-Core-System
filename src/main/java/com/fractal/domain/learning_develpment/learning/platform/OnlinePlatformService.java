package com.fractal.domain.learning_develpment.learning.platform;

import com.fractal.domain.learning_develpment.learning.platform.dto.OnlinePlatformRequest;
import com.fractal.domain.learning_develpment.learning.platform.dto.OnlinePlatformResponse;

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

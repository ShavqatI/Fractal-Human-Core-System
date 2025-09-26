package com.fractal.domain.learning_develpment.learning.platform.type;

import com.fractal.domain.learning_develpment.learning.platform.type.dto.OnlinePlatformTypeRequest;
import com.fractal.domain.learning_develpment.learning.platform.type.dto.OnlinePlatformTypeResponse;

import java.util.List;

public interface OnlinePlatformTypeService {
   OnlinePlatformType create(OnlinePlatformTypeRequest dto);
   List<OnlinePlatformType> getAll();
   OnlinePlatformType getByCode(String code);
   OnlinePlatformType getById(Long id);
   OnlinePlatformType update(Long id, OnlinePlatformTypeRequest dto);
   void deleteById(Long id);
   OnlinePlatformTypeResponse toDTO(OnlinePlatformType onlinePlatformType);
}

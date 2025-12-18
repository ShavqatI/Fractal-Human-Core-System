package com.fractal.domain.profile.relative;

import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;

import java.util.List;

public interface ProfileRelativeService {
    List<Relative> getAll();


    Relative getById(Long id);

    RelativeResponse toDTO(Relative relative);


}

package com.fractal.domain.employment.kind;

import com.fractal.domain.employment.kind.dto.EmploymentKindRequest;
import com.fractal.domain.employment.kind.dto.EmploymentKindResponse;

import java.util.List;

public interface EmploymentKindService {
   EmploymentKind create(EmploymentKindRequest dto);
   List<EmploymentKind> getAll();
   EmploymentKind getByCode(String code);
   EmploymentKind getById(Long id);
   EmploymentKind update(Long id, EmploymentKindRequest dto);
   void deleteById(Long id);
   EmploymentKindResponse toDTO(EmploymentKind employmentKind);
}

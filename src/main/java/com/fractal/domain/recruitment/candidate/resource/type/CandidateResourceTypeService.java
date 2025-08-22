package com.fractal.domain.recruitment.candidate.resource.type;

import com.fractal.domain.recruitment.candidate.resource.type.dto.CandidateResourceTypeRequest;
import com.fractal.domain.recruitment.candidate.resource.type.dto.CandidateResourceTypeResponse;

import java.util.List;

public interface CandidateResourceTypeService {
   CandidateResourceType create(CandidateResourceTypeRequest dto);
   List<CandidateResourceType> getAll();
   CandidateResourceType getByCode(String code);
   CandidateResourceType getById(Long id);
   CandidateResourceType update(Long id, CandidateResourceTypeRequest dto);
   void deleteById(Long id);
   CandidateResourceTypeResponse toDTO(CandidateResourceType candidateResourceType);
}

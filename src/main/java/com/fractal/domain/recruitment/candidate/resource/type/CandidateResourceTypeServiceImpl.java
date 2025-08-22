package com.fractal.domain.recruitment.candidate.resource.type;

import com.fractal.domain.recruitment.candidate.resource.type.dto.CandidateResourceTypeRequest;
import com.fractal.domain.recruitment.candidate.resource.type.dto.CandidateResourceTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateResourceTypeServiceImpl implements CandidateResourceTypeService {

    private final CandidateResourceTypeRepository candidateResourceTypeRepository;
    @Override
    public CandidateResourceType create(CandidateResourceTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public CandidateResourceType update(Long id, CandidateResourceTypeRequest dto) {
        try {
            CandidateResourceType candidateResourceType = findById(id);
            candidateResourceType.setCode(dto.code());
            candidateResourceType.setName(dto.name());
            return save(candidateResourceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<CandidateResourceType> getAll() {
        return candidateResourceTypeRepository.findAll();
    }

    @Override
    public CandidateResourceType getByCode(String code) {
        return candidateResourceTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public CandidateResourceType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       candidateResourceTypeRepository.delete(findById(id));
    }

    @Override
    public CandidateResourceTypeResponse toDTO(CandidateResourceType candidateResourceType) {
        return new CandidateResourceTypeResponse(
                candidateResourceType.getId(),
                candidateResourceType.getCode(),
                candidateResourceType.getName(),
                candidateResourceType.getCreatedDate()
        );
    }
    private CandidateResourceType toEntity(CandidateResourceTypeRequest dto) {
        return CandidateResourceType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private CandidateResourceType save(CandidateResourceType candidateResourceType) {
        try {
            return candidateResourceTypeRepository.save(candidateResourceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private CandidateResourceType findById(Long id) {
        return candidateResourceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}

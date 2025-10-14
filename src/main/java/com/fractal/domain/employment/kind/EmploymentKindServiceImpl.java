package com.fractal.domain.employment.kind;

import com.fractal.domain.employment.kind.dto.EmploymentKindRequest;
import com.fractal.domain.employment.kind.dto.EmploymentKindResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmploymentKindServiceImpl implements EmploymentKindService {

    private final EmploymentKindRepository employmentKindRepository;
    @Override
    public EmploymentKind create(EmploymentKindRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public EmploymentKind update(Long id, EmploymentKindRequest dto) {
        try {
            EmploymentKind employmentKind = findById(id);
            employmentKind.setCode(dto.code());
            employmentKind.setName(dto.name());
            return save(employmentKind);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<EmploymentKind> getAll() {
        return employmentKindRepository.findAll();
    }

    @Override
    public EmploymentKind getByCode(String code) {
        return employmentKindRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public EmploymentKind getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       employmentKindRepository.delete(findById(id));
    }

    @Override
    public EmploymentKindResponse toDTO(EmploymentKind employmentKind) {
        return new EmploymentKindResponse(
                employmentKind.getId(),
                employmentKind.getCode(),
                employmentKind.getName(),
                employmentKind.getCreatedDate()
        );
    }
    private EmploymentKind toEntity(EmploymentKindRequest dto) {
        return EmploymentKind.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private EmploymentKind save(EmploymentKind employmentKind) {
        try {
            return employmentKindRepository.save(employmentKind);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmploymentKind findById(Long id) {
        return employmentKindRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}

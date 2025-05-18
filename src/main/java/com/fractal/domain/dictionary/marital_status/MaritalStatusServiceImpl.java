package com.fractal.domain.dictionary.marital_status;

import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusRequest;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class MaritalStatusServiceImpl implements MaritalStatusService {

    private final MaritalStatusRepository maritalStatusRepository;

    @Override
    public MaritalStatus create(MaritalStatusRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<MaritalStatus> getAll() {
        return maritalStatusRepository.findAll();
    }

    @Override
    public MaritalStatus getByCode(String code) {
        return maritalStatusRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Marital Status with code: " + code + " not found"));
    }

    @Override
    public MaritalStatus getById(Long id) {
        return findById(id);
    }

    @Override
    public MaritalStatus update(Long id, MaritalStatusRequest dto) {
        try {
            MaritalStatus maritalStatus = findById(id);
            maritalStatus.setCode(dto.code());
            maritalStatus.setName(dto.name());
            return save(maritalStatus);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       maritalStatusRepository.delete(findById(id));
    }

    @Override
    public MaritalStatusResponse toDTO(MaritalStatus maritalStatus) {
        return null;
    }

    private MaritalStatus toEntity(MaritalStatusRequest dto) {
        return MaritalStatus.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private MaritalStatus save(MaritalStatus maritalStatus) {
        try {
            return maritalStatusRepository.save(maritalStatus);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private MaritalStatus findById(Long id) {
        return maritalStatusRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Marital Status with id: " + id + " not found"));
    }
}

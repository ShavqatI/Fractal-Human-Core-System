package com.fractal.domain.dictionary.nationality;

import com.fractal.domain.dictionary.nationality.dto.NationalityRequest;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class NationalityServiceImpl implements NationalityService {

    private final NationalityRepository nationalityRepository;

    @Override
    public Nationality create(NationalityRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Nationality> getAll() {
        return nationalityRepository.findAll();
    }

    @Override
    public Nationality getByCode(String code) {
        return nationalityRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Nationality with code: " + code + " not found"));
    }

    @Override
    public Nationality getById(Long id) {
        return findById(id);
    }

    @Override
    public Nationality update(Long id, NationalityRequest dto) {
        try {
            Nationality nationality = findById(id);
            nationality.setCode(dto.code());
            nationality.setName(dto.name());
            return save(nationality);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      nationalityRepository.delete(findById(id));
    }

    @Override
    public NationalityResponse toDTO(Nationality nationality) {
        return new NationalityResponse(
                nationality.getId(),
                nationality.getCode(),
                nationality.getName(),
                nationality.getCreatedDate()
        );
    }

    private Nationality toEntity(NationalityRequest dto) {
        return Nationality.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private Nationality save(Nationality nationality) {
        try {
            return nationalityRepository.save(nationality);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Nationality findById(Long id) {
        return nationalityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Nationality with id: " + id + " not found"));
    }
}

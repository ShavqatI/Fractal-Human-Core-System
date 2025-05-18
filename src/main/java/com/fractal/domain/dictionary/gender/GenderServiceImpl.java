package com.fractal.domain.dictionary.gender;

import com.fractal.domain.dictionary.gender.dto.GenderRequest;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;

    @Override
    public Gender create(GenderRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Gender> getAll() {
        return genderRepository.findAll();
    }

    @Override
    public Gender getByCode(String code) {
        return genderRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public Gender getById(Long id) {
        return findById(id);
    }

    @Override
    public Gender update(Long id, GenderRequest dto) {
        try {
            Gender gender = findById(id);
            gender.setCode(dto.code());
            gender.setName(dto.name());
            return save(gender);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        genderRepository.delete(findById(id));
    }

    @Override
    public GenderResponse toDTO(Gender gender) {
        return new GenderResponse(
                gender.getId(),
                gender.getCode(),
                gender.getName(),
                gender.getCreatedDate()
        );
    }

    private Gender toEntity(GenderRequest dto) {
        return Gender.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private Gender save(Gender gender) {
        try {
            return genderRepository.save(gender);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Gender findById(Long id) {
        return genderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}

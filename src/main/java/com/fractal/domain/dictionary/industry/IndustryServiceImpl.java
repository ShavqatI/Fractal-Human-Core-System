package com.fractal.domain.dictionary.industry;

import com.fractal.domain.dictionary.industry.dto.IndustryRequest;
import com.fractal.domain.dictionary.industry.dto.IndustryResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class IndustryServiceImpl implements IndustryService {

    private final IndustryRepository industryRepository;

    @Override
    public Industry create(IndustryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Industry> getAll() {
        return industryRepository.findAll();
    }

    @Override
    public Industry getByCode(String code) {
        return industryRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Nationality with code: " + code + " not found"));
    }

    @Override
    public Industry getById(Long id) {
        return findById(id);
    }

    @Override
    public Industry update(Long id, IndustryRequest dto) {
        try {
            Industry industry = findById(id);
            industry.setCode(dto.code());
            industry.setName(dto.name());
            return save(industry);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      industryRepository.delete(findById(id));
    }

    @Override
    public IndustryResponse toDTO(Industry industry) {
        return new IndustryResponse(
                industry.getId(),
                industry.getCode(),
                industry.getName(),
                industry.getCreatedDate()
        );
    }

    private Industry toEntity(IndustryRequest dto) {
        return Industry.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private Industry save(Industry industry) {
        try {
            return industryRepository.save(industry);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Industry findById(Long id) {
        return industryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Nationality with id: " + id + " not found"));
    }
}

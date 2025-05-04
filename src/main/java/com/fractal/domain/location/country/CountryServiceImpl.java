package com.fractal.domain.location.country;

import com.fractal.domain.location.country.dto.CountryRequest;
import com.fractal.domain.location.country.dto.CountryResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country create(CountryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getByCode(String code) {
        return countryRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Country Type with id: " + code + " not found"));

    }

    @Override
    public Country getById(Long id) {
        return findById(id);
    }

    @Override
    public Country update(Long id, CountryRequest dto) {
        try {
            Country country = findById(id);
            country.setCode(dto.code());
            country.setName(dto.name());
            country.setIso3Code(dto.iso3Code());
            country.setNumericCode(dto.numericCode());
            country.setPhonePrefix(dto.phonePrefix());
            return save(country);
        }
        catch (DataAccessException e){
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       countryRepository.delete(findById(id));
    }

    @Override
    public CountryResponse toDTO(Country country) {
        return new CountryResponse(
                country.getId(),
                country.getCode(),
                country.getName(),
                country.getIso3Code(),
                country.getNumericCode(),
                country.getPhonePrefix(),
                country.getCreatedDate()
        );
    }

    private Country toEntity(CountryRequest dto) {
        return Country.builder()
                .code(dto.code())
                .name(dto.name())
                .iso3Code(dto.iso3Code())
                .numericCode(dto.numericCode())
                .phonePrefix(dto.phonePrefix())
                .build();
    }

    private Country save(Country country) {
        try {
            return countryRepository.save(country);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country Type with id: " + id + " not found"));
    }
}

package com.fractal.domain.employee_management.citizenship;

import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.location.country.CountryService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CitizenshipServiceImpl implements CitizenshipService {

    private final CitizenshipRepository citizenshipRepository;
    private final CountryService countryService;

    @Override
    public CitizenshipResponse toDTO(Citizenship citizenship) {
        return new CitizenshipResponse(citizenship.getCountry().getName());
    }

    @Override
    public Citizenship toEntity(CitizenshipRequest dto) {
        return Citizenship.builder().country(countryService.getById(dto.countryId())).build();
    }

    @Override
    public Citizenship update(Long id, CitizenshipRequest dto) {
        try {
            var citizenship = citizenshipRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
            citizenship.setCountry(countryService.getById(dto.countryId()));
            return citizenshipRepository.save(citizenship);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void delete(Citizenship citizenship) {
       citizenshipRepository.delete(citizenship);
    }
}

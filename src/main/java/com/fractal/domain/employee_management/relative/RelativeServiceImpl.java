package com.fractal.domain.employee_management.relative;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.employee_management.relative.address.RelativeAddressService;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.employee_management.relative.type.RelationTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class RelativeServiceImpl implements RelativeService {

    private final RelativeRepository relativeRepository;
    private final RelationTypeService relationTypeService;
    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final RelativeAddressService addressService;

    @Override
    public Relative create(RelativeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public RelativeResponse toDTO(Relative relative) {
        return new RelativeResponse(
                relative.getId(),
                relative.getLastName(),
                relative.getFirstName(),
                relative.getPatronymicName(),
                relative.getBirthDate(),
                relative.getTin(),
                relative.getSsn(),
                relative.getGender().getName(),
                relative.getMaritalStatus().getName(),
                relative.getNationality().getName(),
                relative.getRelationType().getName(),
                Optional.ofNullable(relative.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressService::toDTO)
                        .collect(Collectors.toList()),
                relative.getCreatedDate()
        );
    }

    @Override
    public Relative toEntity(RelativeRequest dto) {
        var relative = Relative.builder()
                        .lastName(dto.lastName())
                        .firstName(dto.firstName())
                        .patronymicName(dto.patronymicName())
                        .birthDate(dto.birthDate())
                        .tin(dto.tin())
                        .ssn(dto.ssn())
                        .gender(genderService.getById(dto.genderId()))
                        .maritalStatus(maritalStatusService.getById(dto.maritalStatusId()))
                        .nationality(nationalityService.getById(dto.nationalityId()))
                        .relationType(relationTypeService.getById(dto.relationTypeId()))
                       .build();
        dto.addresses().forEach(address->relative.addAddress(addressService.toEntity(address)));
        return relative;
    }

    @Override
    public Relative update(Long id, RelativeRequest dto) {
       var relative = findById(id);
        relative.setLastName(dto.lastName());
        relative.setFirstName(dto.firstName());
        relative.setPatronymicName(dto.patronymicName());
        relative.setBirthDate(dto.birthDate());
        relative.setTin(dto.tin());
        relative.setSsn(dto.ssn());
        relative.setGender(genderService.getById(dto.genderId()));
        relative.setMaritalStatus(maritalStatusService.getById(dto.maritalStatusId()));
        relative.setNationality(nationalityService.getById(dto.nationalityId()));
        relative.setRelationType(relationTypeService.getById(dto.relationTypeId()));
        dto.addresses().forEach(address->relative.addAddress(addressService.toEntity(address)));
       return relative;
    }

    @Override
    public void delete(Relative relative) {
       relativeRepository.delete(relative);
    }

    @Override
    public Relative addAddress(Long id, RelativeAddressRequest dto) {
        var relative = findById(id);
        relative.addAddress(addressService.toEntity(dto));
        return save(relative);
    }

    @Override
    public Relative updateAddress(Long id, Long addressId, RelativeAddressRequest dto) {
        var relative = findById(id);
        var address = relative.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative address with id: " + addressId + " not found"));
        addressService.update(address,dto);
        return save(relative);
    }

    @Override
    public Relative deleteAddress(Long id, Long addressId) {
        var relative = findById(id);
        var address = relative.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative address with id: " + addressId + " not found"));
        relative.removeAddress(address);
        addressService.delete(address);
        return save(relative);
    }


    private Relative save(Relative relative) {
        try {
            return relativeRepository.save(relative);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Relative findById(Long id) {
        return relativeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + id + " not found"));
    }
}

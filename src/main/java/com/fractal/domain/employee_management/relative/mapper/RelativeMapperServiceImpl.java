package com.fractal.domain.employee_management.relative.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.relative.address.mapper.RelativeAddressMapperService;
import com.fractal.domain.employee_management.relative.contact.mapper.RelativeContactMapperService;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.employee_management.relative.type.RelationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class RelativeMapperServiceImpl implements RelativeMapperService {

    private final RelationTypeService relationTypeService;
    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final RelativeAddressMapperService addressMapperService;
    private final RelativeContactMapperService contactMapperService;

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
                genderService.toDTO(relative.getGender()),
                maritalStatusService.toDTO(relative.getMaritalStatus()),
                nationalityService.toDTO(relative.getNationality()),
                relationTypeService.toDTO(relative.getRelationType()),
                Optional.ofNullable(relative.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(relative.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                relative.getCreatedDate()
        );
    }

    @Override
    public Relative toEntity(RelativeRequest dto) {
        return mapToEntity(new Relative(), dto);
    }

    @Override
    public Relative toEntity(Relative relative, RelativeRequest dto) {
        return mapToEntity(relative, dto);
    }

    private Relative mapToEntity(Relative relative, RelativeRequest dto) {
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
        dto.addresses().forEach(address -> relative.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact -> relative.addContact(contactMapperService.toEntity(contact)));
        return relative;
    }
}

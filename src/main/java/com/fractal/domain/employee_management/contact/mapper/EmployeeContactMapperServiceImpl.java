package com.fractal.domain.employee_management.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.employee_management.contact.EmployeeContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeContactMapperServiceImpl implements EmployeeContactMapperService {
    private final ContactMapperService mapperService;
    @Override
    public ContactResponse toDTO(EmployeeContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public EmployeeContact toEntity(ContactRequest dto) {
        return (EmployeeContact) mapperService.toEntity(dto);
    }

    @Override
    public EmployeeContact toEntity(EmployeeContact contact, ContactRequest dto) {
        return (EmployeeContact) mapperService.toEntity(contact,dto);
    }
}

package com.fractal.domain.employee_management.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeContactServiceImpl implements EmployeeContactService {

    private final EmployeeContactRepository contactRepository;
    private final EmployeeService employeeService;
    private final EmployeeContactMapperService contactMapperService;


    @Override
    @Transactional
    public EmployeeContact create(Long employeeId, ContactRequest dto) {
        var employee = employeeService.getById(employeeId);
        var contact = contactMapperService.toEntity(dto);
        employee.addContact(contact);
        employeeService.save(employee);
        return contact;
    }

    @Override
    public List<EmployeeContact> getAllByEmployeeId(Long employeeId) {
        return contactRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeContact getById(Long employeeId, Long id) {
        return contactRepository.findByEmployeeIdAndId(employeeId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmployeeContact update(Long employeeId, Long id, ContactRequest dto) {
        var employee = employeeService.getById(employeeId);
        var contact = employee.getContacts()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        contact = contactMapperService.toEntity(contact, dto);
        contactRepository.save(contact);
        employeeService.save(employee);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var contact = employee.getContacts()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        employee.removeContact(contact);
        employeeService.save(employee);
    }

    @Override
    public ContactResponse toDTO(EmployeeContact contact) {
        return contactMapperService.toDTO(contact);
    }


}

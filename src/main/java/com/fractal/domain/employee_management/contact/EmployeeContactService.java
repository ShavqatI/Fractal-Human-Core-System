package com.fractal.domain.employee_management.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface EmployeeContactService {

    EmployeeContact create(Long employeeId, ContactRequest dto);

    List<EmployeeContact> getAllByEmployeeId(Long employeeId);

    EmployeeContact getById(Long employeeId, Long id);

    EmployeeContact update(Long employeeId, Long id, ContactRequest dto);

    void delete(Long employeeId, Long id);

    ContactResponse toDTO(EmployeeContact contact);

}

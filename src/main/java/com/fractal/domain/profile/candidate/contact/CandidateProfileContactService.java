package com.fractal.domain.profile.candidate.contact;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.contact.EmployeeContact;

import java.util.List;

public interface CandidateProfileContactService {
    List<EmployeeContact> getAll();

    EmployeeContact getById(Long id);
    ContactResponse toDTO(EmployeeContact contact);


}

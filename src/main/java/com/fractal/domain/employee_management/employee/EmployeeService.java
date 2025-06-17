package com.fractal.domain.employee_management.employee;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    Employee create(EmployeeRequest dto);
    List<Employee> getAll();
    Employee getByTin(String tin);
    Employee getById(Long id);
    Employee update(Long id, EmployeeRequest dto);
    void deleteById(Long id);
    EmployeeResponse toDTO(Employee employee);
    Employee save(Employee employee);

    Employee addIdentificationDocument(Long id, IdentificationDocumentRequest dto);
    Employee updateIdentificationDocument(Long id,Long identificationDocumentId, IdentificationDocumentRequest dto);
    Employee deleteIdentificationDocument(Long id,Long identificationDocumentId);

    Employee addCitizenship(Long id, CitizenshipRequest dto);
    Employee updateCitizenship(Long id,Long citizenshipId, CitizenshipRequest dto);
    Employee deleteCitizenship(Long id,Long citizenshipId);


    Employee addContact(Long id, ContactRequest dto);
    Employee updateContact(Long id,Long contactId, ContactRequest dto);
    Employee deleteContact(Long id,Long contactId);

    Employee addEducation(Long id, EducationRequest dto);
    Employee updateEducation(Long id,Long educationId, EducationRequest dto);
    Employee deleteEducation(Long id,Long educationId);

    Employee addRelative(Long id, RelativeRequest dto);
    Employee updateRelative(Long id,Long relativeId, RelativeRequest dto);
    Employee deleteRelative(Long id,Long relativeId);

    Employee addMilitaryService(Long id, MilitaryServiceRequest dto);
    Employee updateMilitaryService(Long id,Long militaryServiceId, MilitaryServiceRequest dto);
    Employee deleteMilitaryService(Long id,Long militaryServiceId);

    Employee addEmploymentHistory(Long id, EmploymentHistoryRequest dto);
    Employee updateEmploymentHistory(Long id,Long employmentHistoryId, EmploymentHistoryRequest dto);
    Employee deleteEmploymentHistory(Long id,Long employmentHistoryId);

    Employee addResource(Long id, MultipartFile file, String url);
    Employee updateResource(Long id, Long resourceId, MultipartFile file);
    Employee deleteResource(Long id, Long resourceId);
}

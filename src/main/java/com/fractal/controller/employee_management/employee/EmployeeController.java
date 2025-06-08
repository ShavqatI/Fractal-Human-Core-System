package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@RequestBody @Valid EmployeeRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(employeeService.getAll().stream().map(employeeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.getById(id)));
    }
    @GetMapping("/tin/{tin}")
    public ResponseEntity<EmployeeResponse> getByTin(@PathVariable String tin) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.getByTin(tin)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @RequestBody @Valid EmployeeRequest dto) {
      return  ResponseEntity.ok(employeeService.toDTO(employeeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    /*@PostMapping("/{id}/identification-document")
    public ResponseEntity<EmployeeResponse> addIdentificationDocument(@PathVariable Long id, @RequestBody @Valid IdentificationDocumentRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addIdentificationDocument(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/identification-document/{identificationDocumentId}")
    public ResponseEntity<EmployeeResponse> updateIdentificationDocument(@PathVariable Long id, @PathVariable Long identificationDocumentId, @RequestBody @Valid IdentificationDocumentRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateIdentificationDocument(id,identificationDocumentId, dto)));
    }
    @DeleteMapping("/{id}/identification-document/{identificationDocumentId}")
    public ResponseEntity<Void> deleteIdentificationDocument(@PathVariable Long id, @PathVariable Long identificationDocumentId) {
        employeeService.deleteIdentificationDocument(id,identificationDocumentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/citizenship")
    public ResponseEntity<EmployeeResponse> addCitizenship(@PathVariable Long id, @RequestBody @Valid CitizenshipRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addCitizenship(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/citizenship/{citizenshipId}")
    public ResponseEntity<EmployeeResponse> updateCitizenship(@PathVariable Long id, @PathVariable Long citizenshipId, @RequestBody @Valid CitizenshipRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateCitizenship(id,citizenshipId, dto)));
    }
    @DeleteMapping("/{id}/citizenship/{citizenshipId}")
    public ResponseEntity<Void> deleteCitizenship(@PathVariable Long id, @PathVariable Long citizenshipId) {
        employeeService.deleteCitizenship(id,citizenshipId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/address")
    public ResponseEntity<EmployeeResponse> addAddress(@PathVariable Long id, @RequestBody @Valid EmployeeAddressRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addAddress(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/address/{addressId}")
    public ResponseEntity<EmployeeResponse> updateAddress(@PathVariable Long id, @PathVariable Long addressId, @RequestBody @Valid EmployeeAddressRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateAddress(id,addressId, dto)));
    }
    @DeleteMapping("/{id}/address/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id, @PathVariable Long addressId) {
        employeeService.deleteAddress(id,addressId);
        return ResponseEntity.noContent().build();
    }



    @PostMapping("/{id}/contact")
    public ResponseEntity<EmployeeResponse> addContact(@PathVariable Long id, @RequestBody @Valid ContactRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addContact(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/contact/{contactId}")
    public ResponseEntity<EmployeeResponse> updateContact(@PathVariable Long id, @PathVariable Long contactId, @RequestBody @Valid ContactRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateContact(id,contactId, dto)));
    }
    @DeleteMapping("/{id}/contact/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id, @PathVariable Long contactId) {
        employeeService.deleteContact(id,contactId);
        return ResponseEntity.noContent().build();
    }




    @PostMapping("/{id}/education")
    public ResponseEntity<EmployeeResponse> addEducation(@PathVariable Long id, @RequestBody @Valid EducationRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addEducation(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/education/{educationId}")
    public ResponseEntity<EmployeeResponse> updateEducation(@PathVariable Long id, @PathVariable Long educationId, @RequestBody @Valid EducationRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateEducation(id,educationId, dto)));
    }
    @DeleteMapping("/{id}/education/{educationId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id, @PathVariable Long educationId) {
        employeeService.deleteEducation(id,educationId);
        return ResponseEntity.noContent().build();
    }



    @PostMapping("/{id}/relative")
    public ResponseEntity<EmployeeResponse> addRelative(@PathVariable Long id, @RequestBody @Valid RelativeRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addRelative(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/relative/{relativeId}")
    public ResponseEntity<EmployeeResponse> updateRelative(@PathVariable Long id, @PathVariable Long relativeId, @RequestBody @Valid RelativeRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateRelative(id,relativeId, dto)));
    }
    @DeleteMapping("/{id}/relative/{relativeId}")
    public ResponseEntity<Void> deleteRelative(@PathVariable Long id, @PathVariable Long relativeId) {
        employeeService.deleteRelative(id,relativeId);
        return ResponseEntity.noContent().build();
    }



    @PostMapping("/{id}/military-service")
    public ResponseEntity<EmployeeResponse> addMilitaryService(@PathVariable Long id, @RequestBody @Valid MilitaryServiceRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addMilitaryService(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/military-service/{militaryServiceId}")
    public ResponseEntity<EmployeeResponse> updateMilitaryService(@PathVariable Long id, @PathVariable Long militaryServiceId, @RequestBody @Valid MilitaryServiceRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateMilitaryService(id,militaryServiceId, dto)));
    }
    @DeleteMapping("/{id}/military-service/{militaryServiceId}")
    public ResponseEntity<Void> deleteMilitaryService(@PathVariable Long id, @PathVariable Long militaryServiceId) {
        employeeService.deleteMilitaryService(id,militaryServiceId);
        return ResponseEntity.noContent().build();
    }



    @PostMapping("/{id}/employment-history")
    public ResponseEntity<EmployeeResponse> addEmploymentHistory(@PathVariable Long id, @RequestBody @Valid EmploymentHistoryRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addEmploymentHistory(id,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/employment-history/{employmentHistoryId}")
    public ResponseEntity<EmployeeResponse> updateEmploymentHistory(@PathVariable Long id, @PathVariable Long employmentHistoryId, @RequestBody @Valid EmploymentHistoryRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateEmploymentHistory(id,employmentHistoryId, dto)));
    }
    @DeleteMapping("/{id}/employment-historyId/{employmentHistoryId}")
    public ResponseEntity<Void> deleteEmploymentHistory(@PathVariable Long id, @PathVariable Long employmentHistoryId) {
        employeeService.deleteEmploymentHistory(id,employmentHistoryId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/resource")
    public ResponseEntity<EmployeeResponse> addResource(@PathVariable Long id, @RequestBody @Valid MultipartFile file) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addResource(id,file,null)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/resource/{resourceId}")
    public ResponseEntity<EmployeeResponse> updateResource(@PathVariable Long id, @PathVariable Long resourceId, @RequestBody @Valid MultipartFile file) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateResource(id,resourceId, file)));
    }
    @DeleteMapping("/{id}/resource/{resourceId}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id, @PathVariable Long resourceId) {
        employeeService.deleteResource(id,resourceId);
        return ResponseEntity.noContent().build();
    }


     */

}

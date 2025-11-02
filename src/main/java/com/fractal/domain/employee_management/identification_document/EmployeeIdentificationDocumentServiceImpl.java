package com.fractal.domain.employee_management.identification_document;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.identification_document.mapper.EmployeeIdentificationDocumentMapperService;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeIdentificationDocumentServiceImpl implements EmployeeIdentificationDocumentService {

    private final EmployeeService employeeService;
    private final EmployeeIdentificationDocumentRepository employeeIdentificationDocumentRepository;
    private final EmployeeIdentificationDocumentMapperService employeeIdentificationDocumentMapperService;


    @Override
    @Transactional
    public EmployeeIdentificationDocument create(Long employeeId, IdentificationDocumentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = employeeIdentificationDocumentMapperService.toEntity(dto);
        employee.addIdentificationDocument(identificationDocument);
        employeeService.save(employee);
        return identificationDocument;
    }

    @Override
    public List<EmployeeIdentificationDocument> getAllByEmployeeId(Long employeeId) {
        return employeeIdentificationDocumentRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeIdentificationDocument getById(Long employeeId , Long id) {
        var employee = employeeService.getById(employeeId);
        return employee.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));

    }

    @Override
    public EmployeeIdentificationDocument getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public EmployeeIdentificationDocument update(Long employeeId, Long id, IdentificationDocumentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i-> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));
        identificationDocument = employeeIdentificationDocumentRepository.save(employeeIdentificationDocumentMapperService.toEntity(identificationDocument,dto));
        employeeService.save(employee);
        return identificationDocument;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));
        employee.removeIdentificationDocument(identificationDocument);
        employeeService.save(employee);
    }

    @Override
    public IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument employeeIdentificationDocument) {
        return employeeIdentificationDocumentMapperService.toDTO(employeeIdentificationDocument);
    }

    private EmployeeIdentificationDocument findById(Long id) {
        return employeeIdentificationDocumentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Identification Document with id: " + id + " not found"));
    }
}

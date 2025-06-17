package com.fractal.domain.employee_management.identification_document;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.employee_management.identification_document.mapper.IdentificationDocumentMapperService;
import com.fractal.domain.employee_management.identification_document.resource.IdentificationDocumentResourceService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdentificationDocumentServiceImpl implements IdentificationDocumentService {

    private final EmployeeService employeeService;

    private final IdentificationDocumentRepository identificationDocumentRepository;

    private final IdentificationDocumentResourceService resourceService;

    private final IdentificationDocumentMapperService identificationDocumentMapperService;


    @Override
    @Transactional
    public IdentificationDocument create(Long employeeId, IdentificationDocumentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = identificationDocumentMapperService.toEntity(dto);
        dto.files().forEach(file-> identificationDocument.addResource(resourceService.toEntity(file,null)));
        employee.addIdentificationDocument(identificationDocument);
        employeeService.save(employee);
        return identificationDocument;
    }

    @Override
    @Transactional
    public IdentificationDocument update(Long employeeId, Long id, IdentificationDocumentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i-> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));
        var finalIdentificationDocument = identificationDocumentMapperService.toEntity(identificationDocument,dto);;
        dto.files().forEach(file-> finalIdentificationDocument.addResource(resourceService.toEntity(file,null)));
        employeeService.save(employee);
        return finalIdentificationDocument;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));
        employee.removeIdentificationDocument(identificationDocument);
        identificationDocumentRepository.delete(identificationDocument);
         employeeService.save(employee);
    }
    @Override
    public List<IdentificationDocument> getAllByEmployeeId(Long employeeId) {
        return identificationDocumentRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public IdentificationDocument getById(Long employeeId ,Long id) {
        var employee = employeeService.getById(employeeId);
        return employee.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));

    }
    @Override
    public IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument) {
        return identificationDocumentMapperService.toDTO(identificationDocument);
    }

    @Override
    public IdentificationDocument toEntity(IdentificationDocumentRequest dto) {
        var identificationDocument  = identificationDocumentMapperService.toEntity(new IdentificationDocument(), dto);
        dto.files().forEach(file-> identificationDocument.addResource(resourceService.toEntity(file,null)));
        return identificationDocument;
    }

    @Override
    public IdentificationDocument addResource(Long id, MultipartFile file) {
        var identificationDocument = findById(id);
        identificationDocument.addResource(resourceService.toEntity(file,null));
        return save(identificationDocument);
    }

    @Override
    public IdentificationDocument updateResource(Long id, Long resourceId, MultipartFile file) {
        var identificationDocument = findById(id);
        var resource = identificationDocument.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification Document Resource  with id: " + resourceId + " not found"));
        resourceService.update(resource,resourceService.fileToRequest(file,null));
        return save(identificationDocument);
    }

    @Override
    public IdentificationDocument deleteResource(Long id, Long resourceId) {
        var identificationDocument = findById(id);
        var resource = identificationDocument.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification Document Resource  with id: " + resourceId + " not found"));
        identificationDocument.removeResource(resource);
        resourceService.delete(resource);
      return save(identificationDocument);
    }



    private IdentificationDocument save(IdentificationDocument identificationDocument) {
        try {
            return identificationDocumentRepository.save(identificationDocument);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private IdentificationDocument findById(Long id) {
        return identificationDocumentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Identification Document with id: " + id + " not found"));
    }
}

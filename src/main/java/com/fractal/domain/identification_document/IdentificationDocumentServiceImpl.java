package com.fractal.domain.identification_document;

import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.identification_document.mapper.IdentificationDocumentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdentificationDocumentServiceImpl implements IdentificationDocumentService {

    private final IdentificationDocumentRepository identificationDocumentRepository;
    private final IdentificationDocumentMapperService mapperService;


    /*@Override
    @Transactional
    public IdentificationDocument create(Long employeeId, IdentificationDocumentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = identificationDocumentMapperService.toEntity(dto);
        employee.addIdentificationDocument(identificationDocument);
        employeeService.save(employee);
        return identificationDocument;
    }

    @Override
    public List<IdentificationDocument> getAllByEmployeeId(Long employeeId) {
        return identificationDocumentRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public IdentificationDocument getById(Long employeeId , Long id) {
        var employee = employeeService.getById(employeeId);
        return employee.getIdentificationDocuments()
                .stream()
                .filter(i -> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));

    }



    @Override
    @Transactional
    public IdentificationDocument update(Long employeeId, Long id, IdentificationDocumentRequest dto) {
        var employee = employeeService.getById(employeeId);
        var identificationDocument = employee.getIdentificationDocuments()
                .stream()
                .filter(i-> i.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification document with id: " + id + " not found"));
        identificationDocument = identificationDocumentRepository.save(identificationDocumentMapperService.toEntity(identificationDocument,dto));
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
        identificationDocumentRepository.delete(identificationDocument);
         employeeService.save(employee);
    }*/

    @Override
    public IdentificationDocument getById(Long id) {
        return findById(id);
    }
    @Override
    public IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument) {
        return mapperService.toDTO(identificationDocument);
    }
    @Override
    public IdentificationDocument save(IdentificationDocument identificationDocument) {
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

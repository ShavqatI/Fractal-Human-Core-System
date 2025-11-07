package com.fractal.domain.agreement.type;

import com.fractal.domain.agreement.type.dto.AgreementTypeRequest;
import com.fractal.domain.agreement.type.dto.AgreementTypeResponse;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManager;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementTypeServiceImpl implements AgreementTypeService {

    private final AgreementTypeRepository agreementTypeRepository;
    private final DocumentTemplateManagerService documentTemplateManagerService;

    @Override
    public AgreementType create(AgreementTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<AgreementType> getAll() {
        return agreementTypeRepository.findAll();
    }

    @Override
    public AgreementType getByCode(String code) {
        return agreementTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Vacation Type with code: " + code + " not found"));

    }

    @Override
    public AgreementType getById(Long id) {
        return findById(id);
    }

    @Override
    public AgreementType update(Long id, AgreementTypeRequest dto) {
        try {
            AgreementType agreementType = findById(id);
            agreementType.setCode(dto.code());
            agreementType.setName(dto.name());
            agreementType.setDescription(dto.description());
            agreementType.setSeries(dto.series());
            documentTemplateManagerService.getById(dto.documentTemplateManagerId());
            return save(agreementType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       agreementTypeRepository.delete(findById(id));
    }

    @Override
    public AgreementTypeResponse toDTO(AgreementType agreementType) {
        return new AgreementTypeResponse(
                agreementType.getId(),
                agreementType.getCode(),
                agreementType.getName(),
                agreementType.getDescription(),
                agreementType.getSeries(),
                documentTemplateManagerService.toDTO(agreementType.getDocumentTemplateManager()),
                agreementType.getCreatedDate()
        );
    }

    private AgreementType toEntity(AgreementTypeRequest dto) {
        return AgreementType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .series(dto.series())
                .documentTemplateManager(documentTemplateManagerService.getById(dto.documentTemplateManagerId()))
                .build();
    }

    private AgreementType save(AgreementType agreementType) {
        try {
            return agreementTypeRepository.save(agreementType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private AgreementType findById(Long id) {
        return agreementTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vacation Type with id: " + id + " not found"));
    }

}

package com.fractal.domain.agreement.employment;

import com.fractal.domain.agreement.employment.dto.EmploymentAgreementRequest;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementResponse;
import com.fractal.domain.agreement.employment.mapper.EmploymentAgreementMapperService;
import com.fractal.domain.employment.EmploymentService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class EmploymentAgreementServiceImpl implements EmploymentAgreementService {

    private final EmploymentAgreementRepository agreementRepository;
    private final EmploymentAgreementMapperService agreementMapperService;
    private final EmploymentService employmentService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final FileService fileService;
    private final AgreementTemplateProcessorService templateProcessorService;

    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;

    @Override
    @Transactional
    public EmploymentAgreement create(EmploymentAgreementRequest dto) {
        var employment = employmentService.getById(dto.employmentId());
        var agreement = agreementMapperService.toEntity(dto);
        employment.addAgreement(agreement);
        employmentService.save(employment);
        return agreement;
    }

    @Override
    public List<EmploymentAgreement> getAll() {
        return agreementRepository.findAll();
    }

    @Override
    public EmploymentAgreement getById(Long id) {
        return findById(id);
    }


    @Override
    @Transactional
    public EmploymentAgreement update(Long id, EmploymentAgreementRequest dto) {
        var employment = employmentService.getById(dto.employmentId());
        var agreement = employment.getAgreements()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        agreement = agreementMapperService.toEntity(agreement, dto);
        agreementRepository.save(agreement);
        employmentService.save(employment);
        return agreement;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var agreement = findById(id);
        var employment = agreement.getEmployment();
        employment.removeAgreement(agreement);
        employmentService.save(employment);
    }

    @Override
    public EmploymentAgreementResponse toDTO(EmploymentAgreement agreement) {
        return agreementMapperService.toDTO(agreement);
    }

    @Override
    public EmploymentAgreement save(EmploymentAgreement agreement) {
        try {
            return agreementRepository.save(agreement);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public Path print(Long id) {
        var agreement = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();
        Map<String, String> values = new HashMap<>();
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(agreement.getAgreementType().getDocumentTemplateManager().getFilePath()));
            values.putAll(templateProcessorService.process(agreement));
            //setStamp(document);
            //setFloatingStamp(document);
            //findTextBoxes(document);
            //insertImageAtBookmark(document);
            //findTextInTextBoxes(document, "myText");
            //findTextBoxes(document);
            //findAllTextBoxes(document);

            wordTemplateProcessorService.processDocument(document, values);

            try (FileOutputStream out = new FileOutputStream(wordFilePath.toFile())) {
                document.write(out);
                wordToPdfConverterService.convert(wordFilePath, pdfFilePath);
                fileService.delete(wordFilePath.toString());
            }


        } catch (Exception e) {
        }
        return pdfFilePath;
    }
    private EmploymentAgreement findById(Long id) {
        return agreementRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}

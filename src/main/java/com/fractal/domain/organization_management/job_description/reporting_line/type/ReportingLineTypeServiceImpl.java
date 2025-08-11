package com.fractal.domain.organization_management.job_description.reporting_line.type;

import com.fractal.domain.organization_management.job_description.reporting_line.type.dto.ReportingLineTypeRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.type.dto.ReportingLineTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class ReportingLineTypeServiceImpl implements ReportingLineTypeService {

    private final ReportingLineTypeRepository reportingLineTypeRepository;

    @Override
    public ReportingLineType create(ReportingLineTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ReportingLineType> getAll() {
        return reportingLineTypeRepository.findAll();
    }

    @Override
    public ReportingLineType getByCode(String code) {
        return reportingLineTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Absence Type with code: " + code + " not found"));
    }

    @Override
    public ReportingLineType getById(Long id) {
        return findById(id);
    }

    @Override
    public ReportingLineType update(Long id, ReportingLineTypeRequest dto) {
        try {
            ReportingLineType reportingLineType = findById(id);
            reportingLineType.setCode(dto.code());
            reportingLineType.setName(dto.name());
            return save(reportingLineType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      reportingLineTypeRepository.delete(findById(id));
    }

    @Override
    public ReportingLineTypeResponse toDTO(ReportingLineType reportingLineType) {
        return new ReportingLineTypeResponse(
                reportingLineType.getId(),
                reportingLineType.getCode(),
                reportingLineType.getName(),
                reportingLineType.getCreatedDate()
        );
    }

    private ReportingLineType toEntity(ReportingLineTypeRequest dto) {
        return ReportingLineType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private ReportingLineType save(ReportingLineType reportingLineType) {
        try {
            return reportingLineTypeRepository.save(reportingLineType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ReportingLineType findById(Long id) {
        return reportingLineTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Absence Type with id: " + id + " not found"));
    }

}

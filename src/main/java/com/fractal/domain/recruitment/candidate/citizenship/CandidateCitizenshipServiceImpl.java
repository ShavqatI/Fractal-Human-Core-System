package com.fractal.domain.recruitment.candidate.citizenship;

import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipRequest;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipResponse;
import com.fractal.domain.recruitment.candidate.citizenship.mapper.CandidateCitizenshipMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateCitizenshipServiceImpl implements CandidateCitizenshipService {


    private final CandidateCitizenshipRepository citizenshipRepository;
    private final CandidateService candidateService;
    private final CandidateCitizenshipMapperService mapperService;


    @Override
    @Transactional
    public CandidateCitizenship create(Long candidateId, CandidateCitizenshipRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var citizenship = mapperService.toEntity(dto);
        candidate.addCitizenship(citizenship);
        candidateService.save(candidate);
        return citizenship;
    }

    @Override
    public List<CandidateCitizenship> getAllByCandidateId(Long candidateId) {
        return citizenshipRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateCitizenship getById(Long employeeId, Long id) {
        return citizenshipRepository.findByCandidateIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public CandidateCitizenship update(Long candidateId, Long id, CandidateCitizenshipRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var citizenship = candidate.getCitizenships()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
        citizenship = citizenshipRepository.save(mapperService.toEntity(citizenship,dto));
        candidateService.save(candidate);
        return citizenship;
    }

    @Override
    @Transactional
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var citizenship = candidate.getCitizenships()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
        candidate.removeCitizenship(citizenship);
        candidateService.save(candidate);
    }

    @Override
    public CandidateCitizenshipResponse toDTO(CandidateCitizenship citizenship) {
        return mapperService.toDTO(citizenship);
    }
}

package com.fractal.domain.recruitment.candidate.military_service;

import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.military_service.mapper.CandidateMilitaryServiceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateMilitaryServiceServiceImpl implements CandidateMilitaryServiceService {

    private final CandidateMilitaryServiceRepository militaryServiceRepository;
    private final CandidateMilitaryServiceMapperService militaryServiceMapperService;
    private final CandidateService candidateService;

    @Override
    @Transactional
    public CandidateMilitaryService create(Long candidateId, MilitaryServiceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var militaryService = militaryServiceMapperService.toEntity(dto);
        candidate.addMilitaryService(militaryService);
        candidateService.save(candidate);
       return militaryService;
    }

    @Override
    public List<CandidateMilitaryService> getAllByCandidateId(Long candidateId) {
        return militaryServiceRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateMilitaryService getById(Long candidateId, Long id) {
        return militaryServiceRepository.findByCandidateIdAndId(candidateId,id).orElseThrow(()-> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public CandidateMilitaryService update(Long candidateId, Long id, MilitaryServiceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var militaryService = candidate.getMilitaryServices()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
        militaryService = militaryServiceMapperService.toEntity(militaryService,dto);
        militaryServiceRepository.save(militaryService);
        candidateService.save(candidate);
       return militaryService;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var candidate = candidateService.getById(employeeId);
        var militaryService = candidate.getMilitaryServices()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
        candidate.removeMilitaryService(militaryService);
        candidateService.save(candidate);
    }

    @Override
    public MilitaryServiceResponse toDTO(CandidateMilitaryService candidateMilitaryService) {
        return militaryServiceMapperService.toDTO(candidateMilitaryService);
    }


    @Override
    public CandidateMilitaryService getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateMilitaryService save(CandidateMilitaryService candidateMilitaryService) {
        try {
            return militaryServiceRepository.save(candidateMilitaryService);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
    private CandidateMilitaryService findById(Long id) {
        return militaryServiceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Military service  with id: " + id + " not found"));
    }
}

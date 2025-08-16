package com.fractal.domain.recruitment.candidate;

import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.mapper.CandidateMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapperService mapperService;

    @Override
    @Transactional
    public Candidate create(CandidateRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Candidate update(Long id, CandidateRequest dto) {
        try {
            Candidate candidate = mapperService.toEntity(findById(id),dto);
            return save(candidate);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      candidateRepository.delete(findById(id));
    }

    @Override
    public CandidateResponse toDTO(Candidate candidate) {
        return mapperService.toDTO(candidate);
    }

    @Override
    public CandidateCompactResponse toCompactDTO(Candidate candidate) {
        return mapperService.toCompactDTO(candidate);
    }
    @Override
    @Transactional
    public Candidate save(Candidate candidate) {
        try {
            return candidateRepository.save(candidate);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Candidate with id: " + id + " not found"));
    }
}

package com.fractal.domain.recruitment.candidate.address;

import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;
import com.fractal.domain.recruitment.candidate.address.mapper.CandidateAddressMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateAddressServiceImpl implements CandidateAddressService {

    private final CandidateAddressRepository candidateAddressRepository;
    private final CandidateAddressMapperService addressMapperService;
    private final CandidateService candidateService;


    @Override
    @Transactional
    public CandidateAddress create(Long candidateId, CandidateAddressRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var address = addressMapperService.toEntity(dto);
        candidate.addAddress(address);
        candidateService.save(candidate);
        return address;
    }


    @Override
    public List<CandidateAddress> getAllByCandidateId(Long candidateId) {
        return candidateAddressRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateAddress getById(Long candidateId, Long id) {
        return candidateAddressRepository.findByCandidateIdAndId(candidateId, id).orElseThrow(() -> new ResourceNotFoundException("Candidate address with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public CandidateAddress update(Long organizationId, Long id, CandidateAddressRequest dto) {
        var candidate = candidateService.getById(organizationId);
        var address = candidate.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate address with id: " + id + " not found"));
        address = candidateAddressRepository.save(addressMapperService.toEntity(address, dto));
        candidateService.save(candidate);
        return address;
    }

    @Override
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var address = candidate.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate address with id: " + id + " not found"));
        candidate.removeAddress(address);
        candidateService.save(candidate);
    }

    @Override
    public CandidateAddressResponse toDTO(CandidateAddress address) {
        return addressMapperService.toDTO(address);
    }
}

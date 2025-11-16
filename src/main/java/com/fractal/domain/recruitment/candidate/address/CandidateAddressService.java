package com.fractal.domain.recruitment.candidate.address;

import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;

import java.util.List;

public interface CandidateAddressService {

    CandidateAddress create(Long candidateId, CandidateAddressRequest dto);

    CandidateAddress getById(Long candidateId, Long id);

    List<CandidateAddress> getAllByCandidateId(Long organizationId);

    CandidateAddress update(Long candidateId, Long id, CandidateAddressRequest dto);

    void delete(Long candidateId, Long id);

    CandidateAddressResponse toDTO(CandidateAddress address);
}

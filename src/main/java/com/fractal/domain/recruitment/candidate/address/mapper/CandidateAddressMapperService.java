package com.fractal.domain.recruitment.candidate.address.mapper;

import com.fractal.domain.recruitment.candidate.address.CandidateAddress;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;

public interface CandidateAddressMapperService {
    CandidateAddressResponse toDTO(CandidateAddress address);

    CandidateAddress toEntity(CandidateAddressRequest dto);

    CandidateAddress toEntity(CandidateAddress address, CandidateAddressRequest dto);
}



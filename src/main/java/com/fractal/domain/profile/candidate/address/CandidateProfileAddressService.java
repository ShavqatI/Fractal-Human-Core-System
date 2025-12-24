package com.fractal.domain.profile.candidate.address;

import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.recruitment.candidate.address.CandidateAddress;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;

import java.util.List;

public interface CandidateProfileAddressService {
    CandidateAddress create(CandidateAddressRequest dto);

    List<CandidateAddress> getAll();

    CandidateAddress getById(Long id);

    CandidateAddress update(Long id, CandidateAddressRequest dto);

    void delete(Long id);

    CandidateAddressResponse toDTO(CandidateAddress address);


}

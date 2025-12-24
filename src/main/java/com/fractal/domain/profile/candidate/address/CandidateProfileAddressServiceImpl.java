package com.fractal.domain.profile.candidate.address;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.EmployeeAddressService;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.recruitment.candidate.address.CandidateAddress;
import com.fractal.domain.recruitment.candidate.address.CandidateAddressService;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileAddressServiceImpl implements CandidateProfileAddressService {

   private final CandidateAddressService addressService;
   private final AuthenticatedService authenticatedService;

    @Override
    public CandidateAddress create(CandidateAddressRequest dto) {
        return addressService.create(authenticatedService.getCandidateId(),dto);
    }

    @Override
    public List<CandidateAddress> getAll() {
        return addressService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateAddress getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateAddress update(Long id, CandidateAddressRequest dto) {
        try {
            return addressService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
        }
        catch (DataAccessException e){
            throw new RuntimeException(e.getMostSpecificCause());
        }
    }

    @Override
    public void delete(Long id) {
        addressService.delete(authenticatedService.getCandidateId(), findById(id).getId());
    }

    @Override
    public CandidateAddressResponse toDTO(CandidateAddress address) {
        return addressService.toDTO(address);
    }


    private CandidateAddress findById(Long id) {
        return addressService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(address -> address.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}

package com.fractal.domain.profile.candidate.citizenship;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenship;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenshipService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileCitizenshipServiceImpl implements CandidateProfileCitizenshipService {

   private final CandidateCitizenshipService citizenshipService;
   private final AuthenticatedService authenticatedService;


    @Override
    public CandidateCitizenship create(CitizenshipRequest dto) {
        return citizenshipService.create(authenticatedService.getCandidateId(), dto);
    }

    @Override
    public List<CandidateCitizenship> getAll() {
        return citizenshipService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateCitizenship getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateCitizenship update(Long id, CitizenshipRequest dto) {
        return citizenshipService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
      citizenshipService.delete(authenticatedService.getCandidateId(), findById(id).getId());
    }

    @Override
    public CitizenshipResponse toDTO(CandidateCitizenship candidateCitizenship) {
        return citizenshipService.toDTO(candidateCitizenship);
    }

    private CandidateCitizenship findById(Long id) {
        return citizenshipService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(citizenship -> citizenship.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}

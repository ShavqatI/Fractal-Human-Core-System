package com.fractal.domain.profile.vacation.request;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ProfileVacationRequestServiceImpl implements ProfileVacationRequestService {

    private final VacationRequestService vacationRequestService;
    private final AuthenticatedService authenticatedService;

    @Override
    public VacationRequest create(ProfileVacationRequestRequest dto) {
        return vacationRequestService.create(mapDTO(dto));
    }

    @Override
    public List<VacationRequest> getAll() {
        return vacationRequestService.getAllByEmployeeId(authenticatedService.getEmployeeId()).stream().sorted(Comparator.comparing(VacationRequest::getId).reversed()).collect(Collectors.toList());
    }

    @Override
    public VacationRequest getById(Long id) {
        return findById(id);
    }



    @Override
    public VacationRequest update(Long id, ProfileVacationRequestRequest dto) {
        try {
            var vacationRequest = findById(id);
            return vacationRequestService.update(vacationRequest.getId(),mapDTO(dto));
        }
        catch (ResourceWithIdNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void deleteById(Long id) {
        vacationRequestService.deleteById(findById(id).getId());
    }

    @Override
    public void close(Long id) {
        vacationRequestService.close(findById(id).getId());
    }

    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return vacationRequestService.toDTO(vacationRequest);
    }

    private VacationRequest findById(Long id) {
        var request = getAll().stream().filter(s-> s.getEmployee().getId().equals(authenticatedService.getEmployeeId()) && s.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        return request;
    }

    @Override
    public VacationRequest review(Long id) {
        var vacationRequest = findById(id);
        return vacationRequestService.review(vacationRequest.getId());
    }

    private VacationRequestRequest mapDTO(ProfileVacationRequestRequest dto) {
        return new VacationRequestRequest(
                authenticatedService.getEmployeeId(),
                dto.successorEmployeeId(),
                dto.vacationTypeId(),
                dto.startDate(),
                dto.startDate().plusDays(dto.days() - 1),
                dto.responsibilities(),
                dto.medicalInfos(),
                dto.educations(),
                dto.description()
        );
    }

}

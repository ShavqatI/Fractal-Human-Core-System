package com.fractal.domain.military_service;

import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;

import java.util.List;


public interface MilitaryServiceService {

    /*MilitaryService create(Long employeeId, MilitaryServiceRequest dto);
    List<MilitaryService> getAllByEmployeeId(Long employeeId);
    MilitaryService getById(Long employeeId , Long id);
    MilitaryServiceResponse toDTO(MilitaryService militaryService);
    MilitaryService update(Long employeeId, Long id, MilitaryServiceRequest dto);
    void delete(Long employeeId,Long id);*/

    MilitaryService getById(Long id);
    MilitaryService save(MilitaryService militaryService);

}

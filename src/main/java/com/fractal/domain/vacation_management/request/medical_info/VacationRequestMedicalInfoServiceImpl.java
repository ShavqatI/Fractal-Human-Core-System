package com.fractal.domain.vacation_management.request.medical_info;

import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoResponse;
import com.fractal.domain.vacation_management.request.medical_info.mapper.VacationRequestMedicalInfoMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationRequestMedicalInfoServiceImpl implements VacationRequestMedicalInfoService {

    private final VacationRequestMedicalInfoRepository medicalInfoRepository;
    private final VacationRequestMedicalInfoMapperService mapperService;
    private final VacationRequestService vacationRequestService;


    @Override
    @Transactional
    public VacationRequestMedicalInfo create(Long vacationRequestId, VacationRequestMedicalInfoRequest dto) {
        var request = vacationRequestService.getById(vacationRequestId);
        var medicalInfo = mapperService.toEntity(dto);
        request.addMedicalInfo(medicalInfo);
        vacationRequestService.save(request);
        return medicalInfo;
    }

    @Override
    public List<VacationRequestMedicalInfo> getAllByVacationRequestId(Long vacationRequestId) {
        return medicalInfoRepository.findAllByVacationRequestId(vacationRequestId);
    }

    @Override
    public VacationRequestMedicalInfo getById(Long vacationRequestId, Long id) {
        return medicalInfoRepository.findByVacationRequestIdAndId(vacationRequestId,id).orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public VacationRequestMedicalInfo update(Long vacationRequestId, Long id, VacationRequestMedicalInfoRequest dto) {
        var request = vacationRequestService.getById(vacationRequestId);
        var medicalInfo = request.getMedicalInfos()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        medicalInfo = medicalInfoRepository.save(mapperService.toEntity(medicalInfo,dto));
        vacationRequestService.save(request);
        return medicalInfo;
    }

    @Override
    @Transactional
    public void delete(Long vacationRequestId, Long id) {
        var request = vacationRequestService.getById(vacationRequestId);
        var medicalInfo = request.getMedicalInfos()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        request.removeMedicalInfo(medicalInfo);
        vacationRequestService.save(request);
    }

    @Override
    public VacationRequestMedicalInfoResponse toDTO(VacationRequestMedicalInfo order) {
        return mapperService.toDTO(order);
    }


}

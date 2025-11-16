package com.fractal.domain.employee_management.relative.address;

import com.fractal.domain.employee_management.relative.RelativeService;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressResponse;
import com.fractal.domain.employee_management.relative.address.mapper.RelativeAddressMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelativeAddressServiceImpl implements RelativeAddressService {

    private final RelativeAddressRepository addressRepository;
    private final RelativeAddressMapperService addressMapperService;
    private final RelativeService relativeService;

    @Override
    public RelativeAddress create(Long relativeId, RelativeAddressRequest dto) {
        var relative = relativeService.getById(relativeId);
        var address = addressMapperService.toEntity(dto);
        relative.addAddress(address);
        relativeService.save(relative);
        return address;
    }

    @Override
    public RelativeAddress getById(Long relativeId, Long id) {
        return addressRepository.findByRelativeIdAndId(relativeId, id).orElseThrow(() -> new ResourceNotFoundException("Relative address with id: " + id + " not found"));
    }

    @Override
    public List<RelativeAddress> getAllByRelativeId(Long relativeId) {
        return addressRepository.findAllByRelativeId(relativeId);
    }

    @Override
    public RelativeAddress update(Long relativeId, Long id, RelativeAddressRequest dto) {
        var relative = relativeService.getById(relativeId);
        var address = relative.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Relative address with id: " + id + " not found"));
        address = addressRepository.save(addressMapperService.toEntity(address, dto));
        relativeService.save(relative);
        return address;
    }

    @Override
    public void delete(Long relativeId, Long id) {
        var relative = relativeService.getById(relativeId);
        var address = relative.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Relative address with id: " + id + " not found"));
        relative.removeAddress(address);
        addressRepository.delete(address);
        relativeService.save(relative);
    }

    @Override
    public RelativeAddressResponse toDTO(RelativeAddress address) {
        return addressMapperService.toDTO(address);
    }
}

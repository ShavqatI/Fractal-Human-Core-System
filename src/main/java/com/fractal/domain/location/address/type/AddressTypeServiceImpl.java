package com.fractal.domain.location.address.type;

import com.fractal.domain.location.address.type.dto.AddressTypeRequest;
import com.fractal.domain.location.address.type.dto.AddressTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class AddressTypeServiceImpl implements AddressTypeService {

    private final AddressTypeRepository addressTypeRepository;
    @Override
    public AddressType create(AddressTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public AddressType update(Long id, AddressTypeRequest dto) {
        try {
            AddressType addressType = findById(id);
            addressType.setCode(dto.code());
            addressType.setName(dto.name());
            return save(addressType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<AddressType> getAll() {
        return addressTypeRepository.findAll();
    }

    @Override
    public AddressType getByCode(String code) {
        return addressTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public AddressType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       addressTypeRepository.delete(findById(id));
    }

    @Override
    public AddressTypeResponse toDTO(AddressType addressType) {
        return new AddressTypeResponse(
                addressType.getId(),
                addressType.getCode(),
                addressType.getName(),
                addressType.getCreatedDate()
        );
    }
    private AddressType toEntity(AddressTypeRequest dto) {
        return AddressType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private AddressType save(AddressType addressType) {
        try {
            return addressTypeRepository.save(addressType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private AddressType findById(Long id) {
        return addressTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}

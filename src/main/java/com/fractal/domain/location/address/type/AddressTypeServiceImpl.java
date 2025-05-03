package com.fractal.domain.location.address.type;

import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class AddressTypeServiceImpl implements AddressTypeService {

    private final AddressTypeRepository addressTypeRepository;
    @Override
    public AddressTypeDto create(AddressTypeDto dto) {
        try {
            return toDTO(save(toEntity(dto)));
        }
        catch (DataAccessException e) {
           throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public AddressTypeDto update(Long id, AddressTypeDto dto) {
        try {
            AddressType newAddressType = toEntity(dto);
            AddressType addressType = findById(id);
            addressType.setName(newAddressType.getName());
            addressType.setCode(newAddressType.getCode());
            return toDTO(save(addressType));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<AddressTypeDto> getAll() {
        return addressTypeRepository.findAll()
                .stream()
                 .map(this::toDTO)
                 .collect(Collectors.toList());
    }

    @Override
    public AddressTypeDto getByCode(String code) {
        return toDTO(addressTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found")));
    }

    @Override
    public AddressTypeDto getById(Long id) {
        return toDTO(findById(id));
    }

    @Override
    public void deleteById(Long id) {
       addressTypeRepository.delete(findById(id));
    }


    private AddressTypeDto toDTO(AddressType addressType) {
        return new AddressTypeDto(
                addressType.getId(),
                addressType.getCode(),
                addressType.getName(),
                addressType.getCreatedDate()
        );
    }
    private AddressType toEntity(AddressTypeDto dto) {
        return AddressType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private AddressType save(AddressType addressType) {
        return addressTypeRepository.save(addressType);
    }

    private AddressType findById(Long id) {
        return addressTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}

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
    public AddressTypeDTO create(AddressTypeDTO dto) {
        try {
            AddressType addressType = toEntity(dto);
            return toDTO(save(addressType));
        }
        catch (DataAccessException e) {
           throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public AddressTypeDTO update(Long id,AddressTypeDTO dto) {
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
    public List<AddressTypeDTO> getAll() {
        return addressTypeRepository.findAll()
                .stream()
                 .map(this::toDTO)
                 .collect(Collectors.toList());
    }

    @Override
    public AddressTypeDTO getByCode(String code) {
        return toDTO(addressTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found")));
    }

    @Override
    public AddressTypeDTO getById(Long id) {
        return toDTO(findById(id));
    }

    @Override
    public void deleteById(Long id) {
       AddressType addressType = findById(id);
       addressTypeRepository.delete(addressType);

    }

    private AddressTypeDTO toDTO(AddressType addressType) {
        return new AddressTypeDTO(
                addressType.getId(),
                addressType.getCode(),
                addressType.getName(),
                addressType.getCreatedDate()
        );
    }
    private AddressType toEntity(AddressTypeDTO dto) {
        return AddressType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private AddressType save(AddressType addressType) {
        addressTypeRepository.save(addressType);
        return addressType;
    }

    private AddressType findById(Long id) {
        return addressTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}

package com.fractal.domain.location.address.type;


import com.fractal.domain.location.address.type.dto.AddressTypeDTO;
import com.fractal.exception.AddressTypeException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class AddressTypeServiceImpl implements AddressTypeService {

    private final AddressTypeRepository addressTypeRepository;


    private AddressType save(AddressType addressType) {
        addressTypeRepository.save(addressType);
        return addressType;
    }

    @Override
    public AddressType create(AddressTypeDTO dto) {
        AddressType addressType = AddressType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
        return save(addressType);
    }

    @Override
    public AddressType update(Long id,AddressType newAddressType) {
        AddressType addressType = findById(id);
        addressType.setName(newAddressType.getName());
        addressType.setCode(newAddressType.getCode());
        return save(addressType);
    }


    @Override
    public List<AddressType> findAll() {
        return addressTypeRepository.findAll();
    }

    @Override
    public AddressType findByCode(String code) {
        return addressTypeRepository.findByCode(code).orElseThrow(()-> new AddressTypeException("Address Type with code: " + code + " not found"));
    }

    @Override
    public AddressType findById(Long id) {
        return addressTypeRepository.findById(id).orElseThrow(()-> new AddressTypeException("Address Type with id: " + id + " not found"));
    }
}

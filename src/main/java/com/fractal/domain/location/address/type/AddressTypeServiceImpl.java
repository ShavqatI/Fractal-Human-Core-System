package com.fractal.domain.location.address.type;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressTypeServiceImpl implements AddressTypeService {

    private final AddressTypeRepository addressTypeRepository;

    @Override
    public AddressType create(AddressType addressType) {
        addressTypeRepository.save(addressType);
        return addressType;
    }

    public AddressType update(Long id,AddressType newAddressType) {
        AddressType addressType = findById(id);
        addressType.setName(newAddressType.getName());
        addressType.setCode(newAddressType.getCode());
        addressTypeRepository.save(addressType);
        return addressType;
    }


    @Override
    public List<AddressType> findAll() {
        return addressTypeRepository.findAll();
    }

    @Override
    public AddressType findByCode(String code) {
        return addressTypeRepository.findByCode(code).orElseThrow(()-> new RuntimeException("Address Type with code: " + code + " not found"));
    }

    @Override
    public AddressType findById(Long id) {
        return addressTypeRepository.findById(id).orElseThrow(()-> new RuntimeException("Address Type with id: " + id + " not found"));
    }
}

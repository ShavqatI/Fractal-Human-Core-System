package com.fractal.domain.location.address.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface AddressTypeRepository extends JpaRepository<AddressType,Long> {

    List<AddressType> findAll();

    Optional<AddressType> findByCode(String code);

}

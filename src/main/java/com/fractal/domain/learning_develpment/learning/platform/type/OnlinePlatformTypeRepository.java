package com.fractal.domain.learning_develpment.learning.platform.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OnlinePlatformTypeRepository extends JpaRepository<OnlinePlatformType, Long> {

    OnlinePlatformType save(OnlinePlatformType onlinePlatformType);

    List<OnlinePlatformType> findAll();

    Optional<OnlinePlatformType> findByCode(String code);

    Optional<OnlinePlatformType> findById(Long id);

}

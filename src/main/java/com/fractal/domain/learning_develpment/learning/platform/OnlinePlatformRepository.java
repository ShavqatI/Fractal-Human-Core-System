package com.fractal.domain.learning_develpment.learning.platform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OnlinePlatformRepository extends JpaRepository<OnlinePlatform, Long> {

    OnlinePlatform save(OnlinePlatform onlinePlatform);

    List<OnlinePlatform> findAll();

    Optional<OnlinePlatform> findByCode(String code);

    Optional<OnlinePlatform> findById(Long id);

}

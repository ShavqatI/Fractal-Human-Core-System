package com.fractal.domain.employee_management.relative.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelativeContactRepository extends JpaRepository<RelativeContact, Long> {
    List<RelativeContact> findAllByRelativeId(Long relativeId);

    Optional<RelativeContact> findByRelativeIdAndId(Long relativeId, Long id);
}

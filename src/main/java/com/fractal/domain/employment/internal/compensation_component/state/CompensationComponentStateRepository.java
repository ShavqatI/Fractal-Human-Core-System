package com.fractal.domain.employment.internal.compensation_component.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface CompensationComponentStateRepository extends JpaRepository<CompensationComponentState, Long> {

    List<CompensationComponentState> findAllByCompensationComponentId(Long compensationComponentId);

}

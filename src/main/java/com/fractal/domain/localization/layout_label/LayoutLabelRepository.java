package com.fractal.domain.localization.layout_label;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface LayoutLabelRepository extends JpaRepository<LayoutLabel,Long> {
    Optional<LayoutLabel> findByName(String name);
}

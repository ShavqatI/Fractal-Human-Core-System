package com.fractal.domain.localization.layout_label.detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LayoutLabelDetailRepository extends JpaRepository<LayoutLabelDetail,Long> {
    Optional<LayoutLabelDetail> findByLayoutLabelIdAndId(Long layoutLabelId,Long id);
    List<LayoutLabelDetail> findAllByLayoutLabelId(Long layoutLabelId);
}

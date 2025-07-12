package com.fractal.domain.localization.layout_label;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.localization.layout_label.detail.LayoutLabelDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "layout_label", schema = "localization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LayoutLabel extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "layoutLabel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LayoutLabelDetail> layoutLabelDetails = new ArrayList<>();

    public void addDetail(LayoutLabelDetail detail) {
        if (layoutLabelDetails == null) layoutLabelDetails = new ArrayList<>();
        detail.setLayoutLabel(this);
        layoutLabelDetails.add(detail);
    }
    public void removeDetail(LayoutLabelDetail detail) {
        if (layoutLabelDetails != null && !layoutLabelDetails.isEmpty())
            layoutLabelDetails.remove(detail);
    }
}

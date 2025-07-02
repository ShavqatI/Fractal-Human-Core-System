package com.fractal.domain.abstraction;


import com.fractal.domain.localization.layout_label.LayoutLabel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class Navigation extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "icon")
    private String icon;

    @ManyToOne
    @JoinColumn(name = "layout_label_id", referencedColumnName = "id")
    private LayoutLabel layoutLabel;
}

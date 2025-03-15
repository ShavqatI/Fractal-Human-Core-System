package com.fractal.domain.navigation;

import com.fractal.domain.localization.LayoutLabel;
import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "menu", schema = "navigation_schema", catalog = "fractal")
public class Menu extends AbstractEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "level")
    private Integer level;
    @Basic
    @Column(name = "icon")
    private String icon;
    @ManyToOne
    @JoinColumn(name = "layout_label_id", referencedColumnName = "id")
    private LayoutLabel layoutLabel;
    @Basic
    @Column(name = "sequence")
    private Integer sequence;
    @Column(name = "route")
    private String route;
    @Column(name = "class_name")
    private String className;
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Menu parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public LayoutLabel getLayoutLabel() {
        return layoutLabel;
    }

    public void setLayoutLabel(LayoutLabel layoutLabelId) {
        this.layoutLabel = layoutLabelId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parentId) {
        this.parent = parentId;
    }


}

package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.localization.layout_label.LayoutLabel;
import jakarta.persistence.*;

@Entity
@Table(name = "action", schema = "navigation_schema", catalog = "fractal")
public class Action extends AbstractEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "icon")
    private String icon;
    @ManyToOne
    @JoinColumn(name = "layout_label_id", referencedColumnName = "id")
    private LayoutLabel layoutLabel;

    @ManyToOne
    @JoinColumn(name = "action_category_id", referencedColumnName = "id")
    private ActionCategory actionCategory;
    @ManyToOne
    @JoinColumn(name = "action_type_id", referencedColumnName = "id")
    private ActionType actionType;

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

    public ActionCategory getActionCategory() {
        return actionCategory;
    }

    public void setActionCategory(ActionCategory actionCategory) {
        this.actionCategory = actionCategory;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}

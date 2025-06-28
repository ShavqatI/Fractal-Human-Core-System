package com.fractal.domain.navigation.action;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.localization.layout_label.LayoutLabel;
import com.fractal.domain.navigation.action.category.ActionCategory;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "action", schema = "navigation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Action extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

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

    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL)
    private List<MenuAction> menuActions = new ArrayList<>();

    @Entity
    @Table(name = "action_type", schema = "navigation_schema", catalog = "fractal")
    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class ActionType extends Dictionary {

    }
}

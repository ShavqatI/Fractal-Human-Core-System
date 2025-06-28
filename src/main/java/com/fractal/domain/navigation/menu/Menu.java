package com.fractal.domain.navigation.menu;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.localization.layout_label.LayoutLabel;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu", schema = "navigation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Menu extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "level")
    private Integer level;

    @Column(name = "icon")
    private String icon;

    @ManyToOne
    @JoinColumn(name = "layout_label_id", referencedColumnName = "id")
    private LayoutLabel layoutLabel;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "class_name")
    private String className;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Menu parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Menu> children = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuAction> menuActions = new ArrayList<>();

    public void addChild(Menu menu) {
        if (children == null) children = new ArrayList<>();
        menu.setParent(this);
        children.add(menu);
    }
    public void removeChild(Menu menu) {
        if (children != null && !children.isEmpty())
            children.remove(menu);
    }

    public void addAction(MenuAction menuAction) {
        if (menuActions == null) menuActions = new ArrayList<>();
        menuAction.setMenu(this);
        menuActions.add(menuAction);
    }


    public void removeAction(MenuAction menuAction) {
        if (menuActions != null && !menuActions.isEmpty())
         menuActions.remove(menuAction);
    }



}

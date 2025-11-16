package com.fractal.domain.navigation.menu;

import com.fractal.domain.abstraction.Navigation;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu", schema = "navigation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Menu extends Navigation {

    @Column(name = "level")
    private Integer level;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "class_name")
    private String className;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Menu parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> children = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuAction> menuActions = new ArrayList<>();

    @Transactional
    public void addChild(Menu menu) {
        if (children == null) children = new ArrayList<>();
        menu.setParent(this);
        children.add(menu);
    }

    @Transactional
    public void removeChild(Menu menu) {
        if (children != null && !children.isEmpty())
            children.remove(menu);
    }

    @Transactional
    public void addAction(MenuAction menuAction) {
        if (menuActions == null) menuActions = new ArrayList<>();
        menuAction.setMenu(this);
        menuActions.add(menuAction);
    }


    @Transactional
    public void removeAction(MenuAction menuAction) {
        if (menuActions != null && !menuActions.isEmpty())
            menuActions.remove(menuAction);
    }


}

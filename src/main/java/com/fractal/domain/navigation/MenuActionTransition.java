package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_action_transition", schema = "navigation_schema", catalog = "fractal")
public class MenuActionTransition extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "menu_transition_id", referencedColumnName = "id")
    private MenuTransition menuTransition;

    @Column(name = "entity_id")
    private Integer entity;
    @ManyToOne
    @JoinColumn(name = "menu_action_id", referencedColumnName = "id")
    private MenuAction menuAction;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "sequence")
    private Integer sequence;

}

package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
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


    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public MenuAction getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(MenuAction menuAction) {
        this.menuAction = menuAction;
    }

    public MenuTransition getMenuTransition() {
        return menuTransition;
    }

    public void setMenuTransition(MenuTransition menuTransition) {
        this.menuTransition = menuTransition;
    }
}

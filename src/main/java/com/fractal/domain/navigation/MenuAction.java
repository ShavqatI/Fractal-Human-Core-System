package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_action", schema = "navigation_schema", catalog = "fractal")
public class MenuAction extends AbstractEntity {
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "action_id", referencedColumnName = "id")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menuByMenuId) {
        this.menu = menuByMenuId;
    }


    public Action getAction() {
        return action;
    }

    public void setAction(Action actionByActionId) {
        this.action = actionByActionId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

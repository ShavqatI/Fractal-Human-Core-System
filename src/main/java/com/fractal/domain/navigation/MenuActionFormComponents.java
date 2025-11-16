package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_action_form_component", schema = "navigation_schema", catalog = "fractal")
public class MenuActionFormComponents extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name = "form_component_id", referencedColumnName = "id")
    private FormComponents formComponents;
    @ManyToOne
    @JoinColumn(name = "menu_action_id", referencedColumnName = "id")
    private MenuAction menuAction;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "sequence")
    private Integer sequence;


    public FormComponents getMenuComponent() {
        return formComponents;
    }

    public void setMenuComponent(FormComponents formComponents) {
        this.formComponents = formComponents;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public FormComponents getFormComponents() {
        return formComponents;
    }

    public void setFormComponents(FormComponents formComponents) {
        this.formComponents = formComponents;
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

}

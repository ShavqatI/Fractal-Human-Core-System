package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.EntityType;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_transition", schema = "navigation_schema", catalog = "fractal")
public class MenuTransition extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name = "entity_type_id", referencedColumnName = "id")
    private EntityType entityType;


    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}

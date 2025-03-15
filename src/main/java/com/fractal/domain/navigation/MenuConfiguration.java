package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_configuration", schema = "navigation_schema", catalog = "fractal")
public class MenuConfiguration extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "configuration_id", referencedColumnName = "id")
    private Configuration configuration;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Basic
    @Column(name = "value")
    private String value;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}

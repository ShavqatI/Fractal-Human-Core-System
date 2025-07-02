package com.fractal.domain.navigation.action;

import com.fractal.domain.abstraction.Navigation;
import com.fractal.domain.navigation.action.category.ActionCategory;
import com.fractal.domain.navigation.action.type.ActionType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "action", schema = "navigation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Action extends Navigation {

    @ManyToOne
    @JoinColumn(name = "action_category_id", referencedColumnName = "id")
    private ActionCategory actionCategory;

    @ManyToOne
    @JoinColumn(name = "action_type_id", referencedColumnName = "id")
    private ActionType actionType;
}

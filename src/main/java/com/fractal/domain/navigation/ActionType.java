package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "action_type", schema = "navigation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class ActionType extends Dictionary {

}

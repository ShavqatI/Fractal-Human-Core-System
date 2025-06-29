package com.fractal.domain.authorization;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.navigation.menu.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Entity
@Table(name = "role_menu", schema = "authorization_schema", catalog = "fractal")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenu extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "confirmed_user_id", referencedColumnName = "id")
    private User confirmedUser;

    @Column(name = "confirmed_date")
    private Timestamp confirmedDate;


}

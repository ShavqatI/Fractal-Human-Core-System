
package com.fractal.domain.authorization;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "permission", schema = "authorization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "menu_action_id", referencedColumnName = "id")
    private MenuAction menuAction;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "confirmed_user_id", referencedColumnName = "id")
    private User confirmedUser;

    @Column(name = "confirmed_date")
    private Timestamp confirmedDate;

  }


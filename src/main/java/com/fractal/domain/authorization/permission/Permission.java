package com.fractal.domain.authorization.permission;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.authorization.role.Role;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "permission", schema = "authorization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_action_id", referencedColumnName = "id")
    private MenuAction menuAction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "confirmed_user_id", referencedColumnName = "id")
    private User confirmedUser;

    @Column(name = "confirmed_date")
    private LocalDateTime confirmedDate;

}


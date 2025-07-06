package com.fractal.domain.authorization.user.role;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.authorization.role.Role;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_role",schema = "authorization_schema",catalog = "fractal")
public class UserRole extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}
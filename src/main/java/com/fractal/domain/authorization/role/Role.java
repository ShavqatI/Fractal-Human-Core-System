package com.fractal.domain.authorization.role;
import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.authorization.user.role.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role",schema = "authorization_schema",catalog = "fractal")
public class Role extends AbstractEntity {

    @Column(name = "code",length = 50)
    @Size(min = 3,max = 50, message = "Code must be between 3 and 50 characters")
    private String code;

    @Column(name = "name",length = 255)
    @Size(min = 5,max = 255, message = "Name must be between 5 and 255 characters")
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRole> userRoles = new HashSet<>();
}
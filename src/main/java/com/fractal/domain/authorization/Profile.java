package com.fractal.domain.authorization;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.ProfileAttribute;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "profile", schema = "user_schema", catalog = "fractal")
public class Profile extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "profile_attribute_id", referencedColumnName = "id")
    private ProfileAttribute profileAttribute;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Basic
    @Column(name = "value")
    private String value;
}

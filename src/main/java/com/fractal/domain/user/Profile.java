package com.fractal.domain.user;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.ProfileAttribute;
import com.fractal.domain.dictionary.Status;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProfileAttribute getProfileAttribute() {
        return profileAttribute;
    }

    public void setProfileAttribute(ProfileAttribute profileAttribute) {
        this.profileAttribute = profileAttribute;
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

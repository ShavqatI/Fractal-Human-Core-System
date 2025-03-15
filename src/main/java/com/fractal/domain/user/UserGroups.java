package com.fractal.domain.user;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "user_groups", schema = "user_schema", catalog = "fractal")
public class UserGroups extends AbstractEntity {


    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
   private User user;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User userByUserId) {
        this.user = userByUserId;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group groupByGroupId) {
        this.group = groupByGroupId;
    }


}

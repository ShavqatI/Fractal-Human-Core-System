
package com.fractal.domain.user;

import com.fractal.domain.dictionary.Status;
import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.navigation.MenuAction;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "permissions", schema = "user_schema", catalog = "fractal")
public class Permissions extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "menu_action_id", referencedColumnName = "id")
    private MenuAction menuAction;
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "confirm_user_id", referencedColumnName = "id")
    private User confirmUser;
    @Column(name = "confirm_date")
    private Timestamp confirmDate;

    public Timestamp getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Timestamp confirmDate) {
        this.confirmDate = confirmDate;
    }




    public Status getStatus() {
        return status;
    }

    public void setStatus(Status statusByStatusId) {
        this.status = statusByStatusId;
    }


    public User getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(User confirmUser) {
        this.confirmUser = confirmUser;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group groupId) {
        this.group = groupId;
    }


    public MenuAction getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(MenuAction menuActionId) {
        this.menuAction = menuActionId;
    }


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

  }


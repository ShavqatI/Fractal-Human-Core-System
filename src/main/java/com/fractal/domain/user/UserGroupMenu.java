package com.fractal.domain.user;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.navigation.Menu;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_group_menu", schema = "user_schema", catalog = "fractal")
public class UserGroupMenu extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "confirm_user_id", referencedColumnName = "id")
    private User confirmUser;

    public Timestamp getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Timestamp confirmDate) {
        this.confirmDate = confirmDate;
    }

    @Column(name = "confirm_date")
    private Timestamp confirmDate;



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status statusByStatusId) {
        this.status = statusByStatusId;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group groupByGroupId) {
        this.group = groupByGroupId;
    }

    public User getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(User userByConfirmUserId) {
        this.confirmUser = userByConfirmUserId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menuByMenuId) {
        this.menu = menuByMenuId;
    }

}

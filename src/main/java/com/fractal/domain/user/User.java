package com.fractal.domain.user;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(value = true)
@Table(name = "user", schema = "user_schema", catalog = "fractal")
public class User extends AbstractEntity {

    @Column(name = "employee_id")
    private Integer employee;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_lock")
    private Boolean isLock;
    @Column(name = "is_credentials_expired")
    private Boolean isCredentialsExpired;
    @Column(name = "is_account_expired")
    private Boolean isAccountExpired;







    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employeeId) {
        this.employee = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public Boolean getCredentialsExpired() {
        return isCredentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        isCredentialsExpired = credentialsExpired;
    }

    public Boolean getAccountExpired() {
        return isAccountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        isAccountExpired = accountExpired;
    }

    }

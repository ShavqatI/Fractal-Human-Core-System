package com.fractal.domain.user;

import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "authentication", schema = "user_schema", catalog = "fractal")
public class Authentication   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "sign_in_date")
    private Timestamp signInDate;

    @Column(name = "sign_out_date")
    private Timestamp signOutDate;

    @Column(name = "token")
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @Column(name = "language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;




    public Timestamp getSignInDate() {
        return signInDate;
    }

    public void setSignInDate(Timestamp signInDate) {
        this.signInDate = signInDate;
    }

    public Timestamp getSignOutDate() {
        return signOutDate;
    }

    public void setSignOutDate(Timestamp signOutDate) {
        this.signOutDate = signOutDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        this.signInDate = new Timestamp(date.getTime());
    }

    @PreUpdate
    protected void onUpdate() {
        Date date = new Date();
        this.signOutDate = new Timestamp(date.getTime());
    }


}

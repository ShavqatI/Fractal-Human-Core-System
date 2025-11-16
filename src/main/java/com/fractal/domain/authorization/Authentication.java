package com.fractal.domain.authorization;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "authentication", schema = "user_schema", catalog = "fractal")
public class Authentication {
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
    private User user;

    @Column(name = "language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


}

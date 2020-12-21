package ashcheulov.mr.db;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heckingUsers", schema = "bull_schema_shit")
public class HeckingUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_name")
    @NotNull
    private String user_name;

    @OneToMany()
    private List<WhatTheHeck> whatTheHeck;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package ashcheulov.mr.db;

import javax.persistence.*;

@Entity
@Table(name = "whatTheHeck", schema = "bull_schema_shit")
public class WhatTheHeck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text_message")
    private String text_message;

    @Column(name = "id_user")
    private int id_user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private HeckingUsers heckingUsers;

    public String getText_message() {
        return text_message;
    }

    public void setText_message(String text_message) {
        this.text_message = text_message;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public HeckingUsers getHeckingUsers() {
        return heckingUsers;
    }

    public void setHeckingUsers(HeckingUsers heckingUsers) {
        this.heckingUsers = heckingUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

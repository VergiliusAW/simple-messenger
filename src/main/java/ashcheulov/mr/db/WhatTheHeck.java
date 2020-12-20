package ashcheulov.mr.db;

import io.smallrye.common.constraint.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "whatTheHeck", schema = "bull_schema_shit")
public class WhatTheHeck {

    @Id
    @Column(name = "id_message")
    @GenericGenerator(name="gen" , strategy="increment")
    @GeneratedValue(generator="gen")
//    @Basic(optional = false)
    @NotNull
    private int id_message;

    @Column(name = "text_message")
    private String text_message;

    @Column(name = "id_user")
    private int id_user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private HeckingUsers heckingUsers;

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

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
}

package ashcheulov.mr.db;

import io.smallrye.common.constraint.NotNull;
import org.checkerframework.common.reflection.qual.ClassBound;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heckingUsers", schema = "bull_schema_shit")
public class HeckingUsers {

    @Id
    @Column(name = "id_user")
    @GenericGenerator(name="gen" , strategy="increment")
    @GeneratedValue(generator="gen")
    @Basic(optional = false)
    @NotNull
    private int user_id;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_name")
    private String user_name;

    @OneToMany(mappedBy = "id_user")
    private List<WhatTheHeck> whatTheHeck;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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
}

package org.example.ss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public final class UserEntity extends User {

    private static final long serialVersionUID = -3708998745561667721L;

    @Id
    @Column(name = "user_id")
    @Override
    public int getUserId() {
        return super.getUserId();
    }

    @Column(name = "user_name")
    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Column(name = "user_name_plain")
    @Override
    public String getUserNamePlain() {
        return super.getUserNamePlain();
    }

    @Column(name = "pwd")
    @Override
    public String getPwd() {
        return super.getPwd();
    }

    @Column(name = "assisted_query_pwd")
    @Override
    public String getAssistedQueryPwd() {
        return super.getAssistedQueryPwd();
    }
}

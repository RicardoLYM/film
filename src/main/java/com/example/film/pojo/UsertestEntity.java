package com.example.film.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usertest", schema = "film", catalog = "")
public class UsertestEntity {
    private int uid;
    private String uname;
    private String upwd;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "upwd")
    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsertestEntity that = (UsertestEntity) o;
        return uid == that.uid &&
                Objects.equals(uname, that.uname) &&
                Objects.equals(upwd, that.upwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, upwd);
    }
}

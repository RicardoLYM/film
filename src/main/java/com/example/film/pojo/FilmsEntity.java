package com.example.film.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "films", schema = "film", catalog = "")
public class FilmsEntity {
    private int fId;
    private String fName;
    private Date fTime;
    private String fDirector;
    private String fImg;
    private String fIntro;
    private Double fScore;

    @Id
    @Column(name = "F_ID")
    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    @Basic
    @Column(name = "F_NAME")
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "F_TIME")
    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    @Basic
    @Column(name = "F_DIRECTOR")
    public String getfDirector() {
        return fDirector;
    }

    public void setfDirector(String fDirector) {
        this.fDirector = fDirector;
    }

    @Basic
    @Column(name = "F_IMG")
    public String getfImg() {
        return fImg;
    }

    public void setfImg(String fImg) {
        this.fImg = fImg;
    }

    @Basic
    @Column(name = "F_INTRO")
    public String getfIntro() {
        return fIntro;
    }

    public void setfIntro(String fIntro) {
        this.fIntro = fIntro;
    }

    @Basic
    @Column(name = "F_SCORE")
    public Double getfScore() {
        return fScore;
    }

    public void setfScore(Double fScore) {
        this.fScore = fScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmsEntity that = (FilmsEntity) o;
        return fId == that.fId &&
                Objects.equals(fName, that.fName) &&
                Objects.equals(fTime, that.fTime) &&
                Objects.equals(fDirector, that.fDirector) &&
                Objects.equals(fImg, that.fImg) &&
                Objects.equals(fIntro, that.fIntro) &&
                Objects.equals(fScore, that.fScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fId, fName, fTime, fDirector, fImg, fIntro, fScore);
    }
}

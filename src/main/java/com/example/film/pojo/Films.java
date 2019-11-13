package com.example.film.pojo;


import java.sql.Date;
import java.util.List;

public class Films {
    private Integer fId;
    private String fName;
    private Date fTime;
    private String fDirector;
    private String fImg;
    private String fIntro;
    private float fScore;

    private List<Actors> actorsList;
    private List<Types> typesList;

    public Films() {
    }

    public List<Actors> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<Actors> actorsList) {
        this.actorsList = actorsList;
    }

    public List<Types> getTypeList() {
        return typesList;
    }

    public void setTypeList(List<Types> typeList) {
        this.typesList = typesList;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    public String getfDirector() {
        return fDirector;
    }

    public void setfDirector(String fDirector) {
        this.fDirector = fDirector;
    }

    public String getfImg() {
        return fImg;
    }

    public void setfImg(String fImg) {
        this.fImg = fImg;
    }

    public String getfIntro() {
        return fIntro;
    }

    public void setfIntro(String fIntro) {
        this.fIntro = fIntro;
    }

    public float getfScore() {
        return fScore;
    }

    public void setfScore(float fScore) {
        this.fScore = fScore;
    }

    @Override
    public String toString() {
        return "Films{" +
                "fId=" + fId +
                ", fName='" + fName + '\'' +
                ", fTime=" + fTime +
                ", fDirector='" + fDirector + '\'' +
                ", fImg='" + fImg + '\'' +
                ", fIntro='" + fIntro + '\'' +
                ", fScore=" + fScore +
                ", actorsList=" + actorsList +
                ", typesList=" + typesList +
                '}';
    }
}

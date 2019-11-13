package com.example.film.pojo;

import javax.persistence.*;

public class Actors {

    private Integer aId;
    private String aName;

    public Actors() {
    }

    public Integer getaId() {
        return aId;
    }
    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }
    public void setaName(String aName) {
        this.aName = aName;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                '}';
    }
}

package com.example.film.pojo;

public class Films_actors {

    private Integer fAId;
    private Integer aId;

    public Films_actors() {
    }

    public Integer getfAId() {
        return fAId;
    }

    public void setfAId(Integer fAId) {
        this.fAId = fAId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "Films_actors{" +
                "fAId=" + fAId +
                ", aId=" + aId +
                '}';
    }
}

package com.example.film.service;

import com.example.film.pojo.Actors;

import java.util.List;

public interface ActorsService {

    //添加新演员
    int insertActor(String aName);

    //判断演员之前是否存在
    int selectActor(String aName);

    //查找所有演员
    List<Actors> findAllActors();

    //根据演员名查找编号
    List<Integer> findAIdByAName(List<String> aNameList);

    //添加新的电影和演员
    int insertNewFilmActors(int fId,List<Integer> aIds);
}

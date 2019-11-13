package com.example.film.service;

import com.example.film.pojo.Types;

import java.util.List;

public interface TypesService {

    List<Types> findAllTypes();

    //新增电影类型
    int insertType(String tName);

    //判断之前是否存在该类型
    int selectType(String tName);

    //根据种类名查找编号
    List<Integer> findTIdByTName(List<String> tNameList);

    //添加新电影的种类
    int insertNewFilmTypes(int fId,List<Integer> tIds);
}

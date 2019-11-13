package com.example.film.mapper;

import com.example.film.pojo.Types;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypesMapper {

    //查找所有种类
    List<Types> findAllTypes();

    //新增电影类型
    int insertType(String tName);

    //判断之前是否存在该类型
    int selectType(String tName);

    List<Integer> findTIdByTName(List<String> tNameList);

    int insertNewFilmTypes(@Param("fId") int fId,@Param("list") List<Integer> tIds);
}

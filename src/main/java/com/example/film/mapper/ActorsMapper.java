package com.example.film.mapper;

import com.example.film.pojo.Actors;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActorsMapper {

    int insertActor(String aName);

    int selectActor(String aName);

    List<Actors> findAllActors();

    List<Integer> findAIdByAName(List<String> aNameList);

    /**
     *
     * @param fId  电影id
     * @param aIds   演员id 数组
     * @return 返回insert成功的值
     */
    int insertNewFilmActors(@Param("fId") int fId,@Param("list") List<Integer> aIds);
}

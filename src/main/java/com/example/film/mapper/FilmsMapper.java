package com.example.film.mapper;

import com.example.film.pojo.Films;

import java.sql.Date;
import java.util.List;

public interface FilmsMapper {

    //查找所有电影
    List<Films> findAllFilms();

    //按关键字查找电影
    //@Select("select F_ID fId,F_NAME fName,F_TIME fTime,F_DIRECTOR fDirector,F_IMG fImg,F_INTRO fIntro from films where F_NAME like '%${_parameter}%' or F_DIRECTOR like '%${_parameter}%'")
    List<Films> searchFilms(String text);

    //按主键查找电影
    Films findFilmByFId(int fId);

    //最新电影的排序
    List<Films> findFilmByTime();

    //根据电影编号查找的电影详情
    Films findFilmDetail(int fId);

    //根据种类查找电影
    List<Films> findFilmsByTName(String tName);

    List<Films> storeFilms(int uid);

    int newFilmId();

    int insertNewFilm(int fId, String fName, String fTime,String fDirector,String fImg, String fIntro,float fScore);
}

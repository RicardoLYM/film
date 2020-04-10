package com.example.film.service;

import com.example.film.pojo.Films;
import com.example.film.pojo.FilmsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface FilmsService {

    Page<FilmsEntity> findAll(Pageable pageable);

    List<Films> findAllFilms();

    List<Films> searchFilms(String text);

    Films findFilmByFId(int fId);

    List<Films> findFilmByTime();

    Films findFilmDetail(int fId);

    List<Films> findFilmsByTName(String tName);
    List<Films> storeFilms(int uid);
    int newFilmId();

    int insertNewFilm(int fId, String fName, String fTime, String fDirector, String fImg, String fIntro, float fScore);
}

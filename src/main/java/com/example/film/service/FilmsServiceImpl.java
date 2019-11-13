package com.example.film.service;

import com.example.film.mapper.FilmsMapper;
import com.example.film.pojo.Films;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("FilmsService")
public class FilmsServiceImpl implements FilmsService{

    @Autowired
    FilmsMapper filmsMapper;


    @Override
    public List<Films> findAllFilms() {
        return filmsMapper.findAllFilms();
    }

    @Override
    public List<Films> searchFilms(String text) {
        return filmsMapper.searchFilms(text);
    }

    @Override
    public Films findFilmByFId(int fId) {
        return filmsMapper.findFilmByFId(fId);
    }

    @Override
    public List<Films> findFilmByTime() {
        return filmsMapper.findFilmByTime();
    }

    @Override
    public Films findFilmDetail(int fId) {
        return filmsMapper.findFilmDetail(fId);
    }

    @Override
    public List<Films> findFilmsByTName(String tName) {
        return filmsMapper.findFilmsByTName(tName);
    }

    @Override
    public List<Films> storeFilms(int uid) {
        return filmsMapper.storeFilms(uid);
    }

    @Override
    public int newFilmId() {
        return filmsMapper.newFilmId();
    }

    @Override
    public int insertNewFilm(int fId, String fName, String fTime, String fDirector, String fImg, String fIntro, float fScore) {
        return filmsMapper.insertNewFilm(fId,fName,fTime,fDirector,fImg,fIntro,fScore);
    }
}

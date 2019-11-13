package com.example.film.service;

import com.example.film.mapper.ActorsMapper;
import com.example.film.pojo.Actors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ActorsService")
public class ActorsServiceImpl implements ActorsService{

    @Autowired
    ActorsMapper actorsMapper;

    @Override
    public int insertActor(String aName) {
        return actorsMapper.insertActor(aName);
    }

    @Override
    public int selectActor(String aName) {
        return actorsMapper.selectActor(aName);
    }

    @Override
    public List<Actors> findAllActors() {
        return actorsMapper.findAllActors();
    }

    @Override
    public List<Integer> findAIdByAName(List<String> aNameList) {
        return actorsMapper.findAIdByAName(aNameList);
    }

    @Override
    public int insertNewFilmActors(int fId, List<Integer> aIds) {
        return actorsMapper.insertNewFilmActors(fId,aIds);
    }
}

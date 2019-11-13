package com.example.film.service;

import com.example.film.mapper.TypesMapper;
import com.example.film.pojo.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TypesService")
public class TypesServiceImpl implements TypesService {

    @Autowired
    TypesMapper typesMapper;

    @Override
    public List<Types> findAllTypes() {
        return typesMapper.findAllTypes();
    }

    @Override
    public int insertType(String tName) {
        return typesMapper.insertType(tName);
    }

    @Override
    public int selectType(String tName) {
        return typesMapper.selectType(tName);
    }

    @Override
    public List<Integer> findTIdByTName(List<String> tNameList) {
        return typesMapper.findTIdByTName(tNameList);
    }

    @Override
    public int insertNewFilmTypes(int fId, List<Integer> tIds) {
        return typesMapper.insertNewFilmTypes(fId,tIds);
    }
}

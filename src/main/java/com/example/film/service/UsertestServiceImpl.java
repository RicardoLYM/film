package com.example.film.service;

import com.example.film.mapper.UsertestMapper;
import com.example.film.pojo.Usertest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usertestService")
public class UsertestServiceImpl implements UsertestService{

    @Autowired
    UsertestMapper usertestMapper;

    @Override
    public Usertest selectUser(int uid) {
        return usertestMapper.selectUser(uid);
    }

    @Override
    public boolean checkRegist(Usertest usertest) {
        int i=usertestMapper.addUser(usertest);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Usertest> findUser() {
        return usertestMapper.findUser();
    }

    @Override
    public int findByName(Usertest usertest) {
        return usertestMapper.findByName(usertest);
    }

    @Override
    public int checkUser(String uname) {
        return usertestMapper.checkUser(uname);
    }

    @Override
    public String findUnameByUid(int uid) {
        return usertestMapper.findUnameByUid(uid);
    }

    @Override
    public int updateUser(Usertest usertest) {
        return usertestMapper.updateUser(usertest);
    }

    @Override
    public int storeFilm(int uid, int fid) {
        return usertestMapper.storeFilm(uid,fid);
    }

    @Override
    public int countStore(int uid, int fid) {
        return usertestMapper.countStore(uid, fid);
    }

    @Override
    public int deleteFilm(int uid, int fid) {
        return usertestMapper.deleteFilm(uid, fid);
    }

    @Override
    public int selectUStateByUId(int uid) {
        return usertestMapper.selectUStateByUId(uid);
    }
}

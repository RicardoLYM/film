package com.example.film.service;

import com.example.film.pojo.Usertest;
import java.util.List;

public interface UsertestService {
    Usertest selectUser(int uid);
    boolean checkRegist(Usertest usertest);
    List<Usertest> findUser();
    int findByName(Usertest usertest);
    int checkUser(String uname);
    //根据用户编号查找用户名
    String findUnameByUid(int uid);
    //更新用户信息
    int updateUser(Usertest usertest);
    int storeFilm(int uid,int fid);
    int countStore(int uid,int fid);
    int deleteFilm(int uid,int fid);
    int selectUStateByUId(int uid);
}

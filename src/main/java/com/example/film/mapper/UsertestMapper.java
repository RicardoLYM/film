package com.example.film.mapper;

import com.example.film.pojo.Usertest;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsertestMapper {

    @Select("select * from usertest where uid=#{uid}")
    Usertest selectUser(int uid);

    /**
     * 用户注册方法
     *
     * @param usertest
     * @return
     */
    int addUser(Usertest usertest);

    /**
     * 用户注册检查
     */
    @Select("select count(*) from usertest where uname=#{uname}")
    int checkUser(String uname);

    /**
     * 查询多个数据
     *
     * @return
     */
    @Select("select * from usertest")
    List<Usertest> findUser();

    /**
     * 用户登录
     */
    int findByName(Usertest usertest);

    /**
     * 根据用户编号查找用户名
     */
    @Select("select uname from usertest where uid=#{uid}")
    String findUnameByUid(int uid);

    //更改用户的信息
    int updateUser(Usertest usertest);

    //保存收藏的信息
    int storeFilm(int uid,int fid);

    //判断该用户是否收藏该影片
    int countStore(int uid,int fid);
    //删除收藏
    int deleteFilm(int uid,int fid);

    //判断用户状态
    int selectUStateByUId(int uid);
}

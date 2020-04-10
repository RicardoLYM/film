package com.example.film.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.film.pojo.Films;
import com.example.film.pojo.Usertest;
import com.example.film.pojo.UsertestEntity;
import com.example.film.service.FilmsService;
import com.example.film.service.UsertestService;
import com.example.film.service.UsertestService2;
import com.example.film.utils.FastJsonConvert;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class JsonUserTestController {

    @Autowired
    UsertestService usertestService;
    @Autowired
    UsertestService2 usertestService2;
    @Autowired
    FilmsService filmsService;

    @RequestMapping("/showUserTest/{uid}")
    public Usertest selectUser(@PathVariable int uid){
        return usertestService.selectUser(uid);
    }

    @RequestMapping("/showUserTest")
    public List<Usertest> findUSer(){
        return usertestService.findUser();
    }

    @RequestMapping(value = "/jpaFindOne/{uid}")
    public UsertestEntity japFindOne(@PathVariable int uid){
        return usertestService2.findUserByUid(uid);
    }

    @RequestMapping("/testlogin1")
    public int login(HttpServletResponse response,Usertest usertest) {
        //System.out.println(usertest.toString());
        int uid = usertestService.findByName(usertest);
        if(0<uid){
            //session.setAttribute("uname", usertest.getUname());
            Cookie c = new Cookie("uname",usertest.getUname());
            Cookie c1 = new Cookie("uid",String.valueOf(uid));
            response.addCookie(c);
            response.addCookie(c1);
        }
            return uid;
    }


    @RequestMapping("/getUserSession")
    public  Cookie[] getUserSession(HttpServletRequest request, HttpSession httpSession) throws JSONException {
        Cookie[] cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
            //String cName = cookies[i].getName();
            //String cValue = cookies[i].getValue();
        }
        return cookies;
    }


    @RequestMapping("/checkUname")
    public String checkUname(Usertest usertest)throws Exception{
        System.out.println(usertest.getUname());
        if(usertestService.checkUser(usertest.getUname())>=1) {
            return "{\"msg\":\"no\"}";
        }
        return "{\"msg\":\"ok\"}";
    }

    @RequestMapping("/testRegister")
    public boolean testRegister(Usertest usertest){
        if(1>usertestService.checkUser(usertest.getUname())){
            if(usertestService.checkRegist(usertest)){
                return true;
            }
            return false;
        }
        return false;
    }

    @RequestMapping("/userLogout")
    @ResponseBody
    public Cookie userLogout(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Cookie c = new Cookie("uid",null);
        Cookie c1 = new Cookie("uname",null);
        response.addCookie(c);
        response.addCookie(c1);
        return c;
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public Usertest showUser(int uid){
        return usertestService.selectUser(uid);
    }

    @RequestMapping("/updateUser")
    public int updateUser(Usertest usertest){
        return usertestService.updateUser(usertest);
    }

    @RequestMapping("/storeFilm")
    public int storeFilm(int uid,int fid){
        return usertestService.storeFilm(uid, fid);
    }

    @RequestMapping("/isExist")
    public int countStore(int uid,int fid){
        return usertestService.countStore(uid, fid);
    }

    @RequestMapping("/deleteFilm")
    public int  deleteFilm( int uid,int fid){
        return usertestService.deleteFilm(uid, fid);
    }

    @RequestMapping("/storeFilms")
    public List<Films> storeFilms(int uid){
        return filmsService.storeFilms(uid);
    }

    @RequestMapping("/findUState")
    public int findUState(int uid){
        return usertestService.selectUStateByUId(uid);
    }

}

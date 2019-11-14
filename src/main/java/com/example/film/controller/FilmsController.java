package com.example.film.controller;

import com.example.film.pojo.Actors;
import com.example.film.pojo.Films;
import com.example.film.pojo.Types;
import com.example.film.service.ActorsService;
import com.example.film.service.FilmsService;
import com.example.film.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmsController {

    @Autowired
    FilmsService filmsService;
    @Autowired
    TypesService typesService;
    @Autowired
    ActorsService actorsService;

    @RequestMapping("/films")
    public String films(Model model)throws Exception{
        //System.out.println("访问films页面");
        List<Films> films = filmsService.findAllFilms();
        List<Films> newFilms  = filmsService.findFilmByTime();
        List<Types> types = typesService.findAllTypes();
        model.addAttribute("newFilms",newFilms);
        model.addAttribute("films",films);
        model.addAttribute("types",types);
        //System.out.println(types);
        return "films";
    }

    @RequestMapping("/films/{fId}")
    public String findFilmByFId(@PathVariable int fId,Model model){
        Films filmDetail = filmsService.findFilmDetail(fId);
        //System.out.println(filmDetail);
        model.addAttribute("filmDetail",filmDetail);
        return "filmDetail";

    }

    @RequestMapping("/searchFilms")
    public String searchFilms(Model model,HttpServletRequest request)throws Exception{
        String text = request.getParameter("search_box");
        List<Films> films = filmsService.searchFilms(text);
        model.addAttribute("searchfilms",films);
        return "filmSearchDetail";
    }

    @RequestMapping("/findFilmsByTName")
    @ResponseBody
    public List<Films> findFilmsByTName(String tName)throws Exception{
        //System.out.println(tName);
        List<Films> films = filmsService.findFilmsByTName(tName);
        //System.out.println(films);
        //model.addAttribute("films",films);
        return films;
    }

    @RequestMapping("userInfo")
    public String userInfo()throws Exception{
        //System.out.println(111);
        return "userInfo";
    }

    @RequestMapping("/backStage")
    public String backStage(Model model){
        int newFId = filmsService.newFilmId();
        List<Actors> actors = actorsService.findAllActors();
        List<Types> types = typesService.findAllTypes();
        model.addAttribute("fId",newFId+1);
        model.addAttribute("actors",actors);
        model.addAttribute("types",types);
        return "backStage";
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file,HttpServletRequest request,HttpServletResponse response){
        if(file.isEmpty()){
            request.setAttribute("reason","图片不存在");
        }
        String fImg = file.getOriginalFilename();
        int fId = Integer.parseInt(request.getParameter("fId"));
        String fName = request.getParameter("fName");
        String fTime = request.getParameter("fTime");
        String fDirector = request.getParameter("fDirector");
        String fIntro = request.getParameter("fIntro");
        float fScore = Float.parseFloat("".equals(request.getParameter("fScore"))?"0.00":request.getParameter("fScore"));
        int result = filmsService.insertNewFilm(fId,fName,fTime,fDirector,fImg,fIntro,fScore);
        //System.out.println(result);
        String[] aName = request.getParameterValues("aName");
        List<String> aNameList = new ArrayList<>();
        for(int i =0;i<aName.length;i++) //对checkbox进行遍历
        {
            aNameList.add(aName[i]);
        }
        List<Integer> aIds = actorsService.findAIdByAName(aNameList);
        actorsService.insertNewFilmActors(fId,aIds);
        String[] tName = request.getParameterValues("tName");
        List<String> tNameList = new ArrayList<>();
        for(int i =0;i<tName.length;i++) //对checkbox进行遍历
        {
            tNameList.add(tName[i]);
        }
        List<Integer> tIds = typesService.findTIdByTName(tNameList);
        typesService.insertNewFilmTypes(fId,tIds);
        int size = (int) file.getSize();
        String path = "D:\\IDEA-Workspace\\film\\src\\main\\resources\\static\\image" ;
        File dest = new File(path + "/" + fImg);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "forward:backStage.html";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }
}

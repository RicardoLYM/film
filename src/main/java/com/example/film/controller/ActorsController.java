package com.example.film.controller;

import com.example.film.service.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActorsController {

    @Autowired
    ActorsService actorsService;

    @RequestMapping("/insertActor")
    @ResponseBody
    public boolean insertActor(String aName){
        if(actorsService.selectActor(aName)==0){
            actorsService.insertActor(aName);
            return true;
        }
        return false;
    }

}

package com.example.film.controller;

import com.example.film.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TypesController {

    @Autowired
    TypesService typesService;

    @RequestMapping("/insertType")
    @ResponseBody
    public boolean insertActor(String tName){
        //System.out.println(1111);
        if(typesService.selectType(tName)==0){
            typesService.insertType(tName);
            return true;
        }
        return false;
    }
}

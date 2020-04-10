package com.example.film.controller;

import com.example.film.pojo.Usertest;
import com.example.film.pojo.UsertestEntity;
import com.example.film.service.UsertestService;
import com.example.film.service.UsertestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserTestController {

    @Autowired
    UsertestService usertestService;
    @Autowired
    UsertestService2 usertestService2;

    @RequestMapping("/welcome")
    public String welcome()throws  Exception{
        System.out.println("访问templates下welcome.html");
        return "welcome";
    }

    @ResponseBody
    @RequestMapping("/showUsertest/{uid}")
    public Usertest selectUser(@PathVariable int uid){
        return usertestService.selectUser(uid);
    }

    @RequestMapping("/bootstrap11")
    public String bootstrap11()throws  Exception{
        System.out.println("访问templates下bootstrap11.html");
        return "bootstrap11";
    }

    @PostMapping("/testRegist")
    public String testRegist(Model model,Usertest usertest){
        System.out.println("前台获取到："+usertest.getUname());
        boolean result = usertestService.checkRegist(usertest);
        if(result){
            model.addAttribute("msg","注册成功");
            model.addAttribute("user",usertest);
        }else {
            model.addAttribute("msg","注册失败");
        }
        return "welcome";
    }

    @PostMapping("/showUsers")
    public String showUsers(Model model)throws Exception{
        List<Usertest> users = usertestService.findUser();
        model.addAttribute("users",users);
        return "allUsers";
    }

    @PostMapping("/showUsers2")
    public String showUser2(Model model,@RequestParam(defaultValue = "1")Integer pageNum)throws  Exception{
        //页面从第一页 但是JPA中指向的是0  2代表的是每页显示条目数
        Pageable pageable = new PageRequest(pageNum-1,2);
        //获取分页信息
        Page<UsertestEntity> pages  = usertestService2.findAll(pageable);
        //获取后台JPA获取到的数据条目数
        System.out.println(pages.getTotalElements());
        //将分页数据 转换为List让前台遍历
        List<UsertestEntity> users = pages.getContent();
        //数据
        model.addAttribute("users",users);
        //总页码
        model.addAttribute("totalPages",pages.getTotalPages());
        //当前页码
        model.addAttribute("pageNum",pageNum);
        return "allUsers2";
    }
}

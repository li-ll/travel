package com.ruo.travel_1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruo.travel_1.domain.Favorite;
import com.ruo.travel_1.domain.Route;
import com.ruo.travel_1.domain.User;
import com.ruo.travel_1.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;
    @RequestMapping("/my")
    public String myf(HttpSession session,Model model,@RequestParam(value = "start",defaultValue = "0")int start,
                      @RequestParam(value = "size",defaultValue = "10")int size){

        PageHelper.startPage(start,size);
        User user = (User) session.getAttribute("user");
        if (user==null){
            return "redirect:rlogin";
        }
        else {
            Integer uid = user.getUid();
            List<Favorite> myf = favoriteService.findByUid(uid);
            PageInfo<Favorite> pageInfo=new PageInfo<>(myf);
            model.addAttribute("page",pageInfo);
           // model.addAttribute("my", myf);
            return "my";
        }

    }
    @RequestMapping("/isFavorite")
    @ResponseBody
    public Map<String,String> isFavorite(HttpSession session, int  rid){

        Map<String,String>map=new HashMap<>(0);
        User user= (User) session.getAttribute("user");

        int uid;
        if (user==null){
            uid=0;
        }
        else {
            uid=user.getUid();
        }
        boolean flag=favoriteService.isFavorite(rid,uid);
        if (flag){
            map.put("flag","true");
        }
        else {
            map.put("flag","false");
        }


        return map;
    }
    @RequestMapping("/addFavorite")
    @ResponseBody
    public void addFavorite(HttpSession session,int rid){

        User user= (User) session.getAttribute("user");
        int uid;
        if (user==null){
            return;
        }
        else {
            uid=user.getUid();
        }
        favoriteService.add(rid,new Date(),uid);
    }
    @RequestMapping("/deleteFavorite")
    @ResponseBody
    public void deleteFavorite(HttpSession session,int rid){

        User user= (User) session.getAttribute("user");
        int uid;
        if (user==null){
            return;
        }
        else {
            uid=user.getUid();
        }
        favoriteService.deleteByRidAndUid(rid,uid);
    }

    @RequestMapping("/test")
    @ResponseBody
    public  PageInfo test(@RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "10")int size,int uid){
/*
        User user = (User) session.getAttribute("user");
        Integer uid=user.getUid();*/


        PageHelper.startPage(start,size);
        List<Favorite> myf2 = favoriteService.findByUid(uid);
        PageInfo<Favorite> pageInfo=new PageInfo<>(myf2);
       // model.addAttribute("page",pageInfo);
        return pageInfo;
    }


    @RequestMapping("/test2")
    public  String test2(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "10")int size,int uid){
/*
        User user = (User) session.getAttribute("user");
        Integer uid=user.getUid();*/


        PageHelper.startPage(start,size);
        List<Favorite> myf2 = favoriteService.findByUid(uid);
        PageInfo<Favorite> pageInfo=new PageInfo<>(myf2);
        model.addAttribute("page",pageInfo);
        return "my";
    }
}

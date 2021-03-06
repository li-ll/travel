package com.ruo.travel_1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruo.travel_1.domain.Route;
import com.ruo.travel_1.service.RouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouService  rouService;

    /**
     * 分类控制器
      * @param model
     * @param start
     * @param size
     * @param cid
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "10")int size,
                          @RequestParam(value = "cid",defaultValue = "5")int cid){
        PageHelper.startPage(start,size);
        List<Route> routes=rouService.findAll(cid);
        PageInfo<Route> pageInfo=new PageInfo<>(routes);
        model.addAttribute("page",pageInfo);
        return "route_list";
    }

    /**
     * 收藏控制器
     * @param model
     * @param start
     * @param size
     * @return
     */
    @RequestMapping("/findByCount")

   // @ResponseBody
    public String findByCount(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "10")int size){
        PageHelper.startPage(start,size);
        List<Route> routes=rouService.findByCount();
        PageInfo<Route> pageInfo=new PageInfo<>(routes);
        model.addAttribute("page",pageInfo);
       return "favorite_rank";
         //return pageInfo;
    }
/*    @RequestMapping("/test")
    @ResponseBody
    public PageInfo<Route> fi(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "10")int size,int cid){
        PageHelper.startPage(start,size);
        List<Route> routes=rouService.findAll(cid);
        PageInfo<Route> pageInfo=new PageInfo<>(routes);
     //   model.addAttribute("page",pageInfo);
        return pageInfo;
    }*/
    @RequestMapping("/findOne")
    public String findOne(Model model, int rid){
        Route route=rouService.findOne(rid);
        model.addAttribute("route",route);
        return "route_detail";
    }

    @RequestMapping("/findByFuzzyQuery")
    public String  findByFuzzyQuery(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                                    @RequestParam(value = "size",defaultValue = "10")int size, String str){
        PageHelper.startPage(start,size);
        List<Route> routes=rouService.findByFuzzyQuery(str);
        PageInfo<Route> pageInfo=new PageInfo<>(routes);
        model.addAttribute("page",pageInfo);
        return "route_list";
    }

}

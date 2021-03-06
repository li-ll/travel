package com.ruo.travel_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {

    @GetMapping("/re")
    public String regist(){
        return "register";
    }

    @RequestMapping("/rlogin")
    public String change2login() {
        return "login";
    }
    /**
     * 跳转到成功页面
     * @return
     */
    @RequestMapping("/regist_ok")
    public String regist_ok( Model model){
        model.addAttribute("msg","恭喜，注册成功！请登录您的注册邮箱进行激活您的账号，激活后才能登录。");
        return "r_ok";
    }

    @RequestMapping("/index")
    public String index(){ return "index";}


    @RequestMapping("/route_detail")
    public String route_detail(){ return "route_de";}


    @RequestMapping("/header")
    public String header(){ return "header"; }
    @RequestMapping("/footer")
    public String footer(){ return "footer"; }
    @GetMapping("/shi_li")
    public String shi(){return "shi_li";}
    @GetMapping("/r")
    public String si(){return "route_detail";}
    @GetMapping("/f")
    public String sli(){return "f";}

    @GetMapping("/l")
    public String l(Model model){
        String msg="你个憨憨";
        model.addAttribute("msg",msg);
        return "l";
    }
/*
    @GetMapping("/my")
    public String my(){return "my";}*/
//    @RequestMapping("route_list")
//    public String list(){return "route_list";}
}

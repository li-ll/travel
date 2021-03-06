package com.ruo.travel_1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruo.travel_1.domain.User;
import com.ruo.travel_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{uid}")
    public String GetUser(@PathVariable int uid) {
        return userService.findByUid(uid).toString();
    }


    //检验用户名
    @RequestMapping("/validateName")
    @ResponseBody
    public Map<String, String> validateName(@RequestParam("username") String username) throws Exception {
        User u = userService.findByUsername(username);
        Map<String, String> map = new HashMap<>();
        if (u == null) {
            map.put("type", "right");
            map.put("msg", "用户名可用");
            return map;
        } else {
            map.put("type", "error");
            map.put("msg", "用户名重复");
            return map;
        }
    }

    @RequestMapping("/regist")
    @ResponseBody
    public Map<String, String> regigster(User user, HttpSession session, String check) {
        Map<String, String> map = new HashMap<>();
        String check_code = (String) session.getAttribute("session_code");
        session.removeAttribute("session_code");
        //比较
        if (check_code == null || !check_code.equalsIgnoreCase(check)) {
            map.put("flag", "false");
            map.put("msg", "验证码错误");
            return map;
        } else {
            boolean flag = userService.regist(user);
            if (flag) {
                map.put("flag", "true");
                return map;
            } else {
                map.put("flag", "false");
                map.put("msg", "注册失败");
                return map;
            }
        }
    }


    /**
     * 激活用户
     *
     * @param code
     * @return
     */

    @RequestMapping("/active")
    public String activeUser(String code, Model model) {
        String msg;
        if (code != null) {
            boolean flag = userService.active(code);
            if (flag) {
                msg="激活成功";
                model.addAttribute("msg",msg );
            } else {
                msg="激活失败，请联系管理员!";
                model.addAttribute("msg", msg);
            }
        }
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(String check, String username, String password, HttpSession session) {

        Map<String, String> map = new HashMap<>();
        String check_code = (String) session.getAttribute("session_code");
        session.removeAttribute("session_code");
        //比较
        if (check_code == null || !check_code.equalsIgnoreCase(check)) {
            map.put("flag", "false");
            map.put("msg", "验证码错误");
            return map;
        } else {
            User user = userService.login(username, password);
            if (user == null) {
                map.put("flag", "false");
                map.put("msg", "用户名或密码错误");
                return map;
            }
            if (user != null && !"Y".equals(user.getStatus())) {
                map.put("flag", "false");
                map.put("msg", "您尚未激活，请激活");
                return map;
            }
            else  {
                map.put("flag", "true");
                session.setAttribute("user", user);
                return map;
            }
        }
    }

   @RequestMapping("/findOne")
    @ResponseBody
    public User findOne(HttpSession session){
      User  user= (User) session.getAttribute("user");
        return user;
    }
    /*

       @RequestMapping("/findAll")
        public String findAll(Model model,@RequestParam(value = "start",defaultValue = "0")int start,
                              @RequestParam(value = "size",defaultValue = "4")int size){
            PageHelper.startPage(start,size);
            List<User> users=userService.findAll();
            PageInfo<User> pageInfo=new PageInfo<>(users);
            model.addAttribute("page",pageInfo);
            return "shi_li";
        }
    */
  @RequestMapping("/test")
  @ResponseBody
  public PageInfo<User> findAll(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
      PageHelper.startPage(pageNum, pageSize);
      List<User> users=userService.findAll();
      PageInfo<User> pageInfo=new PageInfo<>(users);
      return pageInfo;
  }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        //1.销毁session
        session.removeAttribute("user");
        //2.跳转登录页面
        return "redirect:/index";
    }
}

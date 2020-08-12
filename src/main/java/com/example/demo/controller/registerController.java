package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class registerController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/register")
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userMapper.getuser(username);
        if (user1!=null) {
            map.put("msg1", "the user has been used,pls register again");
            return "register";
        } else {
            map.put("msg1", "register success");
            userMapper.adduser(user);
            return "login";
        }
    }

    @RequestMapping("/getuser")
    public String getuser(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        User user = userMapper.getuser(username);
        if (user!= null) {
            map.put("msg", "the user has been registered!");
            return "login";
        } else {
            map.put("msg", "the user has not been used!");
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        if (loginuser != null) {
            return "data";
        } else {
            map.put("msg2", "the user is not a legal user");
            return "login";
        }
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
         User getuser1 = userMapper.getuser1(username, password);
        if (getuser1 != null) {
            userMapper.deleteuser(username);
            map.put("msg3", "the user has been deleted!");
            return "login";
        } else {
            map.put("msg3", "the user is not a legal user");
            return "login";
        }
    }

    @RequestMapping("/Update")
    public String Update(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        User getuser = userMapper.getuser1(username, password);
        if (getuser != null) {
            userMapper.updateuser(username,newpassword);
            map.put("msg3", "the user has been updated!");
            return "login";
        } else {
            map.put("msg3", "the user is not a legal user");
            return "login";
        }
    }

    @RequestMapping("/data")
    public String data(HttpServletRequest request, Map<String,Object> map) {
        return "data";
    }

    @RequestMapping("/shu")
    public String shu(HttpServletRequest request, Map<String,Object> map) {
            return "shu";
    }

    @RequestMapping("/tu")
    public String tu(HttpServletRequest request, Map<String,Object> map) {
        return "tu";
    }

    @RequestMapping("/biao")
    public String biao(HttpServletRequest request, Map<String,Object> map) {
        return "biao";
    }

    @RequestMapping("/paixu")
    public String paixu(HttpServletRequest request, Map<String,Object> map) {
        return "paixu";
    }

    @RequestMapping("/shuzu")
    public String shuzu(HttpServletRequest request, Map<String,Object> map) { return "shuzu";
    }

    @RequestMapping("/duiheduizhan")
    public String duiheduizhan(HttpServletRequest request, Map<String,Object> map) {
        return "duiheduizhan";
    }

    @RequestMapping("/zhanheduilie")
    public String zhanheduilie(HttpServletRequest request, Map<String,Object> map) {
        return "zhanheduilie";
    }


}
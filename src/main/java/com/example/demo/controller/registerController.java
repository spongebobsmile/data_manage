package com.example.demo.controller;


import com.example.demo.mapper.DatacontrolMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Datacontrol;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class registerController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DatacontrolMapper datacontrolMapper;

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

    @RequestMapping("/Tree")
    public String Tree(Model model, HttpServletRequest request, Map<String,Object> map) {
        String titlevalue ;
        String headvalue ;
        String txtvalue ;
        List<String> alltitle = datacontrolMapper.Alltitle();
        List<String> allhead = datacontrolMapper.Allhead();
        List<String> alltxt = datacontrolMapper.Alltxt();
        int size = alltitle.size();
        String[] Display_Txt = new String[size];
        String[] Display_Title = new String[size];
        String[] Display_Head = new String[size];
        int tmp = 1;
        Map<String,Datacontrol> allMembers = new HashMap<String,Datacontrol>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x - 1);
            headvalue = allhead.get(x - 1);
            txtvalue = alltxt.get(x - 1);
            if (headvalue!=null && headvalue.equals("树")) {
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
                Display_Txt[tmp] = txtvalue;
                tmp++;

            } else {

                continue;
            }

        }
        for (int x = 1;x < tmp; x = x +1) {
            Datacontrol vo = new Datacontrol();
            vo.setId(x);
            vo.setHead(Display_Head[x]);
            vo.setTitle(Display_Title[x]);
            vo.setTxt(Display_Txt[x]);

            allMembers.put("index-" + x, vo);

        }
       map.put("msg_tree",Display_Head[tmp-1]);
        model.addAttribute("alldatacontrol",allMembers);
        return "Tree";
    }

    @RequestMapping("/tu")
    public String tu(Model model, HttpServletRequest request, Map<String,Object> map) {
        String titlevalue ;
        String headvalue ;
        String txtvalue ;
        List<String> alltitle = datacontrolMapper.Alltitle();
        List<String> allhead = datacontrolMapper.Allhead();
        List<String> alltxt = datacontrolMapper.Alltxt();
        int size = alltitle.size();
        String[] Display_Txt = new String[size];
        String[] Display_Title = new String[size];
        String[] Display_Head = new String[size];
        int tmp = 1;
        Map<String,Datacontrol> allMembers = new HashMap<String,Datacontrol>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x - 1);
            headvalue = allhead.get(x - 1);
            txtvalue = alltxt.get(x - 1);
            if (headvalue!=null && headvalue.equals("图")) {
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
                Display_Txt[tmp] = txtvalue;
                tmp++;

            } else {

                continue;
            }

        }
        for (int x = 1;x < tmp; x = x +1) {
            Datacontrol vo = new Datacontrol();
            vo.setId(x);
            vo.setHead(Display_Head[x]);
            vo.setTitle(Display_Title[x]);
            vo.setTxt(Display_Txt[x]);

            allMembers.put("index-" + x, vo);

        }
        map.put("msg_tu",Display_Head[tmp-1]);
        model.addAttribute("alldatacontrol",allMembers);
        return "tu";
    }

    @RequestMapping("/paixu")
    public String paixu(Model model, HttpServletRequest request, Map<String,Object> map) {
        String titlevalue ;
        String headvalue ;
        String txtvalue ;
        List<String> alltitle = datacontrolMapper.Alltitle();
        List<String> allhead = datacontrolMapper.Allhead();
        List<String> alltxt = datacontrolMapper.Alltxt();
        int size = alltitle.size();
        String[] Display_Txt = new String[size];
        String[] Display_Title = new String[size];
        String[] Display_Head = new String[size];
        int tmp = 1;
        Map<String,Datacontrol> allMembers = new HashMap<String,Datacontrol>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x - 1);
            headvalue = allhead.get(x - 1);
            txtvalue = alltxt.get(x - 1);
            if (headvalue!=null && headvalue.equals("排序")) {
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
                Display_Txt[tmp] = txtvalue;
                tmp++;

            } else {

                continue;
            }

        }
        for (int x = 1;x < tmp; x = x +1) {
            Datacontrol vo = new Datacontrol();
            vo.setId(x);
            vo.setHead(Display_Head[x]);
            vo.setTitle(Display_Title[x]);
            vo.setTxt(Display_Txt[x]);

            allMembers.put("index-" + x, vo);

        }
        System.out.println(allMembers);
        map.put("msg_paixu",Display_Head[tmp-1]);
        model.addAttribute("alldatacontrol",allMembers);
        return "paixu";
    }

    @RequestMapping("/shuzu")
    public String shuzhu(Model model, HttpServletRequest request, Map<String,Object> map) {
        String titlevalue ;
        String headvalue ;
        String txtvalue ;
        List<String> alltitle = datacontrolMapper.Alltitle();
        List<String> allhead = datacontrolMapper.Allhead();
        List<String> alltxt = datacontrolMapper.Alltxt();
        int size = alltitle.size();
        String[] Display_Txt = new String[size];
        String[] Display_Title = new String[size];
        String[] Display_Head = new String[size];
        int tmp = 1;
        Map<String,Datacontrol> allMembers = new HashMap<String,Datacontrol>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x - 1);
            headvalue = allhead.get(x - 1);
            txtvalue = alltxt.get(x - 1);
            if (headvalue!=null && headvalue.equals("数组")) {
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
                Display_Txt[tmp] = txtvalue;
                tmp++;

            } else {

                continue;
            }

        }
        for (int x = 1;x < tmp; x = x +1) {
            Datacontrol vo = new Datacontrol();
            vo.setId(x);
            vo.setHead(Display_Head[x]);
            vo.setTitle(Display_Title[x]);
            vo.setTxt(Display_Txt[x]);

            allMembers.put("index-" + x, vo);

        }
        map.put("msg_shuzu",Display_Head[tmp-1]);
        model.addAttribute("alldatacontrol",allMembers);
        return "shuzu";
    }

    @RequestMapping("/duilie")
    public String duilie(Model model, HttpServletRequest request, Map<String,Object> map) {
        String titlevalue ;
        String headvalue ;
        String txtvalue ;
        List<String> alltitle = datacontrolMapper.Alltitle();
        List<String> allhead = datacontrolMapper.Allhead();
        List<String> alltxt = datacontrolMapper.Alltxt();
        int size = alltitle.size();
        String[] Display_Txt = new String[size];
        String[] Display_Title = new String[size];
        String[] Display_Head = new String[size];
        int tmp = 1;
        Map<String,Datacontrol> allMembers = new HashMap<String,Datacontrol>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x - 1);
            headvalue = allhead.get(x - 1);
            txtvalue = alltxt.get(x - 1);
            if (headvalue!=null && headvalue.equals("队列")) {
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
                Display_Txt[tmp] = txtvalue;
                tmp++;

            } else {

                continue;
            }

        }
        for (int x = 1;x < tmp; x = x +1) {
            Datacontrol vo = new Datacontrol();
            vo.setId(x);
            vo.setHead(Display_Head[x]);
            vo.setTitle(Display_Title[x]);
            vo.setTxt(Display_Txt[x]);

            allMembers.put("index-" + x, vo);

        }
        map.put("msg_duilie",Display_Head[tmp-1]);
        model.addAttribute("alldatacontrol",allMembers);
        return "duilie";
    }

    @RequestMapping("/biao")
    public String biao(Model model, HttpServletRequest request, Map<String,Object> map) {
        String titlevalue ;
        String headvalue ;
        String txtvalue ;
        List<String> alltitle = datacontrolMapper.Alltitle();
        List<String> allhead = datacontrolMapper.Allhead();
        List<String> alltxt = datacontrolMapper.Alltxt();
        int size = alltitle.size();
        String[] Display_Txt = new String[size];
        String[] Display_Title = new String[size];
        String[] Display_Head = new String[size];
        int tmp = 1;
        Map<String,Datacontrol> allMembers = new HashMap<String,Datacontrol>();
        for (int x = 1;x <= size; x = x +1) {
            titlevalue = alltitle.get(x - 1);
            headvalue = allhead.get(x - 1);
            txtvalue = alltxt.get(x - 1);
            if (headvalue!=null && headvalue.equals("表")) {
                Display_Head[tmp] = headvalue;
                Display_Title[tmp] = titlevalue;
                Display_Txt[tmp] = txtvalue;
                tmp++;

            } else {

                continue;
            }

        }
        for (int x = 1;x < tmp; x = x +1) {
            Datacontrol vo = new Datacontrol();
            vo.setId(x);
            vo.setHead(Display_Head[x]);
            vo.setTitle(Display_Title[x]);
            vo.setTxt(Display_Txt[x]);

            allMembers.put("index-" + x, vo);

        }
        map.put("msg_biao",Display_Head[tmp-1]);
        model.addAttribute("alldatacontrol",allMembers);
        return "biao";
    }



    @RequestMapping("/data")
    public String data(HttpServletRequest request, Map<String,Object> map) {
        return "data";
    }


}
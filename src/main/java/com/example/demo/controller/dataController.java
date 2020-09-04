package com.example.demo.controller;

import com.example.demo.model.Datacontrol;
import com.example.demo.mapper.DatacontrolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.ui.Model;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class dataController {
    @Autowired
    private DatacontrolMapper datacontrolMapper;

    @GetMapping("/de")
    @RequestMapping("/de")
    public String de() {
        return "de";
    }



    @RequestMapping("/addtxt")
    public String addtxt(HttpServletRequest request, Map<String, Object> map) {
        String head = request.getParameter("head");
        String title = request.getParameter("title");
        String txt = request.getParameter("txt");
        Datacontrol datacontrol = new Datacontrol();
        Datacontrol datacontrol1 = datacontrolMapper.getdatacontrol(head,title);
        datacontrol.setHead(head);
        datacontrol.setTitle(title);
        datacontrol.setTxt(txt);
        if (datacontrol1 != null) {
            map.put("msg6", "f");
            return "data";
        } else {
            map.put("msg6", "内容添加成功");
            datacontrolMapper.addtxt(datacontrol);
            return "de";
        }


    }

    @RequestMapping("/deletetxt")
    public String deletedatacontrol(HttpServletRequest request, Map<String, Object> map) {
        String title = request.getParameter("title");
        String head = request.getParameter("head");
        String txt = request.getParameter("txt");
        String getdatacontrol = datacontrolMapper.gettxt2(head,title);
        if (getdatacontrol != null) {
            datacontrolMapper.deletedatacontrol(head,title);
            map.put("msg5", "内容删除成功");
            return "de";
        } else {
            map.put("msg5", "内容删除失败");
            return "de";
        }
    }

    @RequestMapping("/Updatetxt")
    public String updatedatacontrol(HttpServletRequest request, Map<String, Object> map) {
        String title = request.getParameter("title");
        String head = request.getParameter("head");
        String txt = request.getParameter("txt");
        // String newtxt = request.getParameter("newtxt");
        //   String datacontrol1 = datacontrolMapper.gettxt1(title);
        Datacontrol getdatacontrol = datacontrolMapper.getdatacontrol(head,title);
        if (getdatacontrol != null) {
            datacontrolMapper.updatedatacontrol(head,title, txt);
                  map.put("msg7","修改成功" );
            return "de";
        } else {
            map.put("msg7", "不存在");
            return "de";
        }
    }
        @RequestMapping("/gettxt")
        public String getdatacontrol(HttpServletRequest request, Map<String, Object> map) {
            String title = request.getParameter("title");
            String head = request.getParameter("head");
            Datacontrol datacontrol = datacontrolMapper.getdatacontrol(head,title);
            String txt = datacontrolMapper.gettxt1(head,title);
            if (datacontrol != null) {
                map.put("msg10", head);
                map.put("msg8", title);
                map.put("msg9", txt);
                return "de";
            } else {
                map.put("msg8", "the title has not been added");
                return "data";

            }
        }


    @RequestMapping("/show")
    public String show(HttpServletRequest request, Map<String, Object> map) {
        List<String> alltitle1 = datacontrolMapper.Alltitle();
        map.put("msg11", alltitle1);
        return "de";
    }

    @RequestMapping("/hidde")
    public String hidde(HttpServletRequest request, Map<String, Object> map) {

        map.put("msg11", "");
        return "de";
    }





}



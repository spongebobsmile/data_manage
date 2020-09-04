package com.example.demo.model;

import lombok.Data;

@Data
public class Datacontrol {
    private String head;
    private String title;
    private String txt;
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return this.head;
    }

}

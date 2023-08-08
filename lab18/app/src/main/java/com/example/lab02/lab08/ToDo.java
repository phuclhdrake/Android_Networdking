package com.example.lab02.lab08;

import java.util.HashMap;

public class ToDo {
    private String pid,name,price, des;

    public ToDo(String pid, String name, String price, String des) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.des = des;
    }
    //phuong thuc xu ly di lieu thao tac voi Firebase
    public HashMap<String,Object> convertHashMap()
    {
        HashMap<String,Object> work=new HashMap<>();
        work.put("pid",pid);
        work.put("name",name);
        work.put("price",price);
        work.put("des",des);
        return work;
    }

    public ToDo() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

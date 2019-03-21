package com.example.wzh.bmobtest;

import cn.bmob.v3.BmobObject;

/**
 * Author by wzh,Date on 2019/3/16.
 * PS: Not easy to write code, please indicate.
 */
public class Person extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

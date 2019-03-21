package com.example.wzh.bmobtest;

import cn.bmob.v3.BmobObject;

/**
 * Author by wzh,Date on 2019/3/17.
 * PS: Not easy to write code, please indicate.
 */
public class BmobUser extends BmobObject {

    private static BmobUser currentUser;
    private String Username;
    private String Password;
    private String Email;


    public static BmobUser getCurrentUser() {
        return currentUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

package com.learning.springboot.devrestapi.model;

import org.springframework.stereotype.Component;

@Component
public class User {

    private Integer userid;
    private String username;
    private String password;
    private static Integer userCounter = 100;
    /*
     * usertype:
     * 		1 - general user
     * 		2 - CSR (Customer Service Representative)
     * 		3 - admin
     */
    private Integer usertype;

    public static Integer getUserCounter() {
        return userCounter;
    }

    public static void setUserCounter(Integer userCounter) {
        User.userCounter = userCounter;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Integer userid, String username, Integer usertype) {


        this.userid = userid;

        this.username = username;

        this.usertype = usertype;

    }

    public User() {
    }

    public User(Integer userid, Integer usertype) {
        this.userid = userid;
        this.usertype = usertype;
    }


    public User(String username, Integer usertype) {
        userCounter++;
        this.userid = userCounter;
        this.username = username;
        this.usertype = usertype;
    }


    public User(String username, String password, Integer usertype) {
        userCounter++;
        this.userid = userCounter;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }


    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + ", usertpye = " + usertype + "]";

    }
}

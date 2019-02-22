package com.lambdaschool.todos.models;

import javax.persistence.Id;
import javax.persistence.*;

//* userid primary key, not null int
//* username string, not null

public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(nullable = false)
    private String username;

    public Users()
    {
        // default constructor
    }

//    getters & setters ----------------------------------------

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}

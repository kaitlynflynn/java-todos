package com.lambdaschool.todos.models;

import javax.persistence.Id;
import javax.persistence.*;


@Entity
@Table(name="users")

//* userid primary key, not null int
//* username string, not null

public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @Column(nullable = false)
    private String username;

    public Users()
    {
        // default constructor
    }

//    getters & setters ----------------------------------------

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
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

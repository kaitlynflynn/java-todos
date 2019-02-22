package com.lambdaschool.todos.models;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="todo")

//* todoid primary key, not null int
//* description string, not null
//* datestarted datetime **_STRETCH GOAL_**
//* completed boolean (0 = false 1 = true) **_STRETCH GOAL_**
//* userid foreign key (one user to many todos) not null

public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoid;

    @Column(nullable = false)
    private String description;

    private Timestamp datestarted;

    private Boolean completed;

    @Column(nullable = false)
    private int userid;

    public Todo()
    {
        // default constructor
    }

    // getters & setters --------------------------------------

    public int getTodoid()
    {
        return todoid;
    }

    public void setTodoid(int todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Timestamp getDatestarted()
    {
        return datestarted;
    }

    public void setDatestarted(Timestamp datestarted)
    {
        this.datestarted = datestarted;
    }

    public Boolean getCompleted()
    {
        return completed;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
    }

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }
}

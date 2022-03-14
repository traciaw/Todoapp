package com.generation.Todoapp.repository.Entity;

import com.generation.Todoapp.controller.dto.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Repository package is part of the Model Component (MVC)
//Item is the entity class to use to map against the table from the database

@Entity
public class Item {
    //Needs to have the same attributes with the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String header;
    private String description;
    private String due;

    public Item() {}

    public Item( ItemDTO itemDto )
    {

        this.header = itemDto.getHeader();
        this.description = itemDto.getDescription();
        this.due = itemDto.getDue();
    }


    public Integer getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader( String header )
    {
        this.header = header;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getDue()
    {
        return due;
    }

    public void setDue( String due )
    {
        this.due = due;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", header='" + header + '\'' + ", description='" + description + '\''  + '\'' + ", due='"
                + due + '\'' + '}';
    }
}


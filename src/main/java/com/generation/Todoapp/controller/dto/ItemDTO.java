package com.generation.Todoapp.controller.dto;

public class ItemDTO {

    private String header;
    private String description;
    private String due;


    public ItemDTO( String header, String description, String due )
    {
        this.header = header;
        this.description = description;
        this.due=due;
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
        this.due= due;
    }


}


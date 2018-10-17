package com.example.anna;

public class Category {
    private String Name;
    public Category(){

    }
    public Category(String name)
    {
        Name = name;
    }
    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

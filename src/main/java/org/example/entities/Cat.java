package org.example.entities;

import org.example.annotations.ImportantString;
import org.example.annotations.Runimmediately;
import org.example.annotations.VeryImportant;

@VeryImportant
public class Cat {

    @ImportantString
    private String name;

    public Cat(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Runimmediately(times = 3)
    public void meaw(){
        System.out.println("MEAAAAWWWWW");
    }
}

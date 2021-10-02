package com.stark.study.lesson_052;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Student {

    private final SimpleIntegerProperty age = new SimpleIntegerProperty();

    //优化处理 (懒汉模式)
    private String name;
    private SimpleStringProperty nameProperty = null;

    public Student(String name,int age){
        this.name = name;



        this.age.set(age);
    }

    public int getAge() {
        return age.get();
    }

    public String getName() {
        if(nameProperty!=null){
            return nameProperty.get();
        }else {
            return this.name;
        }
    }

    public void setAge(int age){
        this.age.set(age);
    }

    public void setName(String name){
        if(nameProperty!=null){
            nameProperty.set(name);
        }else {
            this.name = name;
        }
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public SimpleStringProperty nameProperty() {

        if(nameProperty==null){
            nameProperty = new SimpleStringProperty(name);
        }
        return nameProperty;
    }
}

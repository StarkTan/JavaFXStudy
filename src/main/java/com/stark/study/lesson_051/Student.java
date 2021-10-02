package com.stark.study.lesson_051;

import java.beans.PropertyChangeSupport;

public class Student {

    private String name;

    private int age;

    private final PropertyChangeSupport propertyChangeSupport;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        if(!oldName.equals(this.name)){
            propertyChangeSupport.firePropertyChange("StudentNameChange",oldName,this.name);
        }

    }

    public void setAge(int age) {
        int oldAge = this.age;
        this.age = age;
        if(oldAge!=this.age){
            propertyChangeSupport.firePropertyChange("StudentAgeChange",oldAge,this.age);
        }
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }
}

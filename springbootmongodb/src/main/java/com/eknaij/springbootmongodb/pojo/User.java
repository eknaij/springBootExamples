package com.eknaij.springbootmongodb.pojo;

public class User {
    int userId;
    String name;


    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "user:[userId:"+userId+"---name:"+name+"]";
    }
}

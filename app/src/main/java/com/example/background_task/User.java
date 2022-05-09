package com.example.background_task;

public class User {

    public Integer id;
    public String name;
    public String email;
    public String gender;
    public String status;
    public User( String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
    public User() {

    }


    public void abc(Integer id, String name, String email, String gender, String status) {
        System.out.println("User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}');
    }
}
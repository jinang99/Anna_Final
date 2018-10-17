package com.example.anna;

public class User {
    private String Name;
    private String password;
    private String Phone;
    public void setPhone(String phone) {
        Phone = phone;
    }


    public String getPhone() {
        return Phone;
    }




    public User() {}

    public User(String  passworda, String name) {

        System.out.println("User mea pass " + passworda);
        System.out.println("User mea name " + name);
        Name = name;
        password = passworda;


        System.out.println("in user cons");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

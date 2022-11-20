package com.example.newsapplication;

public class userHelperClass
{
    private String name, email, password, conformapassword;

    public userHelperClass(String name, String email, String password, String conformapassword)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.conformapassword = conformapassword;
    }

    public userHelperClass()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConformapassword() {
        return conformapassword;
    }

    

    public void setConformapassword(String conformapassword) {
        this.conformapassword = conformapassword;
    }
}

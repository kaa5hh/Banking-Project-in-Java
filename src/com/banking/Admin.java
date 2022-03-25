package com.banking;

public class Admin {
    private String password = "admin";

    Admin()
    {

    }

    public String getAdminPassword()
    {
        return this.password;
    }
    public void setAdminPassword(String password)
    {
        this.password = password;
    }
}

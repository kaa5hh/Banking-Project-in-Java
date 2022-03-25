package com.banking;
public class User
{
    private int id;
    private String password;
    private String fullName;
    double balance;

    User(int id, String fullName, String password)
    {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
    }

    public int getId()
    {
        return this.id;
    }
    public String getPassword()
    {
        return this.password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getFullName()
    {
        return this.fullName;
    }
    public double getBalance()
    {
        return this.balance;
    }
    public void setBalance(double Balance)
    {
        this.balance = Balance;
    }
}


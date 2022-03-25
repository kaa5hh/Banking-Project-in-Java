package com.banking;

import java.util.*;

public class Bank {
    private HashMap<Integer,User> users = new HashMap<>();
    Bank()
    {

    }
        public void addUser(int id, String fullName, String password)
        {
            User newUser = new User(id, fullName, password);
            if (users.containsKey(id)) {
                System.out.println("User Already Exists");

            } else {
                users.put(id, newUser);
                System.out.println("User Account Created Successfully");
            }
        }
        public void deleteUser(int id)
        {
            if(users.isEmpty())
            {
                System.out.println("User Account Does Not Exists");
            }
            if(users.containsKey(id))
            {
                users.remove(id);
                System.out.println("User Account Deleted Successfully");
            }
            else
            {
                System.out.println("User Account Does Not Exists");
            }
        }
        public String getFullName(int id)
        {
            return (users.get(id)).getFullName();
        }
        public void addBalance(int id, double amount)
        {
            double newAmount = (users.get(id)).getBalance() + amount;
            (users.get(id)).setBalance(newAmount);
        }
    public void subBalance(int id, double amount)
    {
        if((users.get(id)).getBalance() < amount)
        {
            System.out.println("Insufficient funds");
        }
        else
        {
            double newAmount = (users.get(id)).getBalance() - amount;
            (users.get(id)).setBalance(newAmount);
        }
    }
        public double getBalance(int id)
        {
            return (users.get(id)).getBalance();
        }
        public boolean checkCustomerDetails(int id, String password)
        {
            if(users.containsKey(id))
            {
                if(((users.get(id)).getPassword()).equals(password))
                {
                    return true;
                }
                else
                {
                    return false;
                }


            }
            else
            {
                return false;
            }
        }
        public void transferFunds(int debitor, int creditor, double amount)
        {
            if(users.containsKey(debitor) && users.containsKey(creditor))
            {
                if ((users.get(debitor)).getBalance() < amount) {
                    System.out.println("Insufficient Funds");
                } else {
                    double newDebitorAmount = (users.get(debitor)).getBalance() - amount;
                    double newCreditorAmount = (users.get(creditor)).getBalance() + amount;
                    (users.get(debitor)).setBalance(newDebitorAmount);
                    (users.get(creditor)).setBalance(newCreditorAmount);
                }
            }
            else
            {
                System.out.println("Check customer IDs and retry");
            }

        }
        public void changeCustomerPassword(int id, String newPassword)
        {
            (users.get(id)).setPassword(newPassword);
        }
}

package com.banking;


import java.util.Scanner;

public class Main {
    Bank newBank = new Bank();
    moreFunctions fn = new moreFunctions();
    Admin a1 = new Admin();
    public void switchPage0()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Customer Panel");
        System.out.println("2. Admin Panel");
        System.out.println("3. Exit");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1: fn.customerLogin();
                break;

            case 2: fn.adminLogin();
                break;

            case 3: break;
        }

    }
    public class moreFunctions {
        public void customerLogin()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter customer id:");
            int id = sc.nextInt();
            System.out.println("Enter customer password:");
            String password = sc.next();
            if(newBank.checkCustomerDetails(id,password))
            {
                System.out.println("Login Successful");
                System.out.println("Customer ID: " +id);
                System.out.println("Customer Name: " +newBank.getFullName(id));
                fn.switchPageCustomer0(id);
            }
            else
            {
                System.out.println("Incorrect credentials");
                switchPage0();
            }
        }
        public void adminLogin()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter admin password:");
            String tempPassword = sc.next();
            if(tempPassword.equals(a1.getAdminPassword()))
            {
                fn.switchPageAdmin0();
            }
            else
            {
                System.out.println("Incorrect Password");
                System.out.println("1. Try Again");
                System.out.println("2. Back To Previous Menu");
                System.out.println("3. Exit");
                int ch = sc.nextInt();
                switch (ch)
                {
                    case 1: fn.adminLogin();
                        break;
                    case 2: switchPage0();
                        break;
                    case 3: break;
                }
            }
        }
        public void switchPageCustomer0(int id)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Check balance");
            System.out.println("2. Transfer funds");
            System.out.println("3. Change customer password");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.println("Current Balance:" +newBank.getBalance(id));
                    switchPageCustomer0(id);
                    break;

                case 2:
                    System.out.println("Enter the recipient ID:");
                    int creditorID = sc.nextInt();
                    System.out.println("Recipient full name: " +newBank.getFullName(id));
                    System.out.println("Enter the amount to be Credited:");
                    double amount = sc.nextDouble();
                    System.out.println("Enter password:");
                    String password = sc.next();
                    if(newBank.checkCustomerDetails(id, password))
                    {
                        newBank.transferFunds(id, creditorID, amount);
                        System.out.println("Transfer Successful");
                        switchPageCustomer0(id);
                    }
                    else
                    {
                        System.out.println("Incorrect Password");
                        switchPageCustomer0(id);
                    }
                    break;

                case 3:
                    System.out.println("Enter old password:");
                    password = sc.next();
                    if(newBank.checkCustomerDetails(id, password))
                    {
                        System.out.println("Enter new password:");
                        String newPassword = sc.next();
                        System.out.println("Re-enter new password");
                        String newPassword2 = sc.next();
                        if(newPassword.equals(newPassword2)) {
                            newBank.changeCustomerPassword(id, newPassword);
                            System.out.println("Password changed successfully");
                            switchPage0();
                        }
                        else
                        {
                            System.out.println("Passwords do not match");
                            switchPageCustomer0(id);
                        }
                    }
                    else
                    {
                        System.out.println("Incorrect Password");
                        switchPageCustomer0(id);
                    }
                    break;
                case 4: switchPage0();
                break;
                case 5: break;
            }
        }
        public void switchPageAdmin0()
        {
            System.out.println();
            System.out.println("1. Create Customer Account");
            System.out.println("2. Delete Customer Account");
            System.out.println("3. Deposit Money from counter");
            System.out.println("4. Withdraw Money from counter");
            System.out.println("5. Change Admin Password");
            System.out.println("6. Logout");
            System.out.println("7. Exit");

            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Creating customer ID");
                    System.out.println("Enter new customer ID:");
                    int id = sc.nextInt();
                    System.out.println("Enter full name of customer:");
                    String fullName = sc.nextLine();
                    fullName = sc.nextLine();
                    System.out.println("Enter new customer password:");
                    String password = sc.next();
                    newBank.addUser(id,fullName,password);
                    switchPageAdmin0();
                    break;
                case 2:
                    System.out.println("Enter customer ID to be deleted:");
                    id = sc.nextInt();
                    System.out.print("User to be deleted: ");
                    fullName = newBank.getFullName(id);
                    System.out.println(" "+fullName);
                    System.out.println("Re-enter admin password:");
                    password = sc.next();
                    if(password.equals(a1.getAdminPassword()))
                    {
                        newBank.deleteUser(id);
                        switchPageAdmin0();
                    }
                    else
                    {
                        System.out.println("Incorrect Password");
                        switchPageAdmin0();
                    }
                    break;

                case 3:
                    System.out.println("Enter customer ID to credit amount:");
                    id = sc.nextInt();
                    System.out.print("Full name:");
                    fullName = newBank.getFullName(id);
                    System.out.println(" "+fullName);
                    System.out.println("Enter the amount:");
                    double amount = sc.nextDouble();

                    System.out.println("Re-enter admin password:");
                    password = sc.next();
                    if(password.equals(a1.getAdminPassword()))
                    {
                        newBank.addBalance(id, amount);
                        System.out.println("Current Balance:" +newBank.getBalance(id));
                        switchPageAdmin0();
                    }
                    else
                    {
                        System.out.println("Incorrect Password");
                        switchPageAdmin0();
                    }
                    break;
                case 4:
                    System.out.println("Enter customer ID to debit amount:");
                    id = sc.nextInt();
                    System.out.print("Full name:");
                    fullName = newBank.getFullName(id);
                    System.out.println(" "+fullName);
                    System.out.println("Enter the amount:");
                    amount = sc.nextDouble();

                    System.out.println("Re-enter admin password:");
                    password = sc.next();
                    if(password.equals(a1.getAdminPassword()))
                    {
                        newBank.subBalance(id, amount);
                        System.out.println("Current Balance:" +newBank.getBalance(id));
                        switchPageAdmin0();
                    }
                    else
                    {
                        System.out.println("Incorrect Password");
                        switchPageAdmin0();
                    }
                    break;

                    case 5: System.out.println("Enter old password:");
                        String tempPassword = sc.next();
                        if(tempPassword.equals(a1.getAdminPassword()))
                        {
                            System.out.println("Enter new password:");
                            String newPass = sc.next();
                            System.out.println("Re-enter new password:");
                            String newPass2 = sc.next();
                            if(newPass.equals(newPass2))
                            {
                                a1.setAdminPassword(newPass);
                            }
                            else
                            {
                                System.out.println("Passwords do not match");
                            }
                        }
                        else
                        {
                            System.out.println("Incorrect Password");
                        }

                    case 6: switchPage0();
                    break;

                    case 7: break;

            }
    }

    }
    public static void main(String[] args) {
        Main m1 = new Main();
        System.out.println("Welcome to Universal Banking Services");
        System.out.println("Please choose your panel type");
        m1.switchPage0();
    }
}

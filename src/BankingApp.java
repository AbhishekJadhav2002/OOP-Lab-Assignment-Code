/*
============================================================================
 Name : BankingApp.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 11 - Case Study
============================================================================
*/

import java.io.*;
import Packages.BankPack.BankingClass;

public class BankingApp
{
    public static void main(String[] args) throws Exception
    {
        BankingClass Bank = new BankingClass();
        int choice;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.print("\n\n----------------------------------------------------------------- Welcome To The Bank -----------------------------------------------------------------\n\n1. Create New Account\t2. Deposit\t3. Withdraw\t4. Display Account Details\t5. Display Balance & Acc. Log\t6. Bank Customers Log\t7. Exit\n\t\t\t\t\t\t\t\tEnter Choice : ");
            choice = Integer.parseInt(in.readLine());
            System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
            switch(choice)
            {
                case 1:
                    System.out.print("\nFill Bank Form -\nEnter name of customer : ");
                    String name = in.readLine();
                    System.out.print("Enter contact number : ");
                    String phone_no = in.readLine();
                    Bank.CreateAccount(name, phone_no);
                    break;

                case 2:
                    System.out.print("\nEnter name of account holder : ");
                    String nameOfDepositor = in.readLine();
                    System.out.print("Enter amount to be deposited : ");
                    float AddToBalance = Float.parseFloat(in.readLine());
                    Bank.Deposit(nameOfDepositor, AddToBalance);
                    break;

                case 3:
                    System.out.print("\nEnter name of account holder : ");
                    String nameOfWithdrawal = in.readLine();
                    System.out.print("Enter amount to be withdrawn : ");
                    float RemoveFromBalance = Float.parseFloat(in.readLine());
                    Bank.Withdraw(nameOfWithdrawal, RemoveFromBalance);
                    break;

                case 4:
                    System.out.print("\nEnter name of account holder : ");
                    String detailsOfCustomer = in.readLine();
                    Bank.ShowCustomerDetails(detailsOfCustomer);
                    break;

                case 5:
                    System.out.print("\nEnter name of account holder : ");
                    String BalanceOfCustomer = in.readLine();
                    Bank.CheckBalanceAndLogs(BalanceOfCustomer);
                    break;

                case 6:
                    Bank.ShowBankLogs();
                    break;

                case 7:
                    System.out.print("\n\n\t\t\t\t\t\t\t-------- Bank Closed ! --------\n\t\t\t\t\t\t\t\tSee you later !");
                    in.close();
                    return;
            }
        }while(true);
    }
}
package Packages.BankPack;
import Packages.CustomerActions.BankCustomer;
import Packages.CustomerActions.LogPrinter;
import java.util.*;
import java.io.*;

public class BankingClass implements BankInterface
{
    private Vector<BankCustomer> customerList = new Vector<BankCustomer>();
    private LogPrinter<String> printer = new LogPrinter<String>();

    public void ShowCustomerDetails(String customerName)
    {
        System.out.print("\nName\t\t\tBalance(Rs.)\tAccount No.\t\t\tContact No.\n--------------------------------------------------------------------------------------");
        for (BankCustomer bankCustomer : customerList)
        {
        if(customerName.equalsIgnoreCase(bankCustomer.name))
            bankCustomer.DisplayContents();
            System.out.print("\n--------------------------------------------------------------------------------------");
            return;
    }
    System.out.print("\nCustomer with name '"+customerName+"' is not found !\n");
    return;
    }

    @Override
        public void CreateAccount(String name, String phone_no)
        {
            for (BankCustomer bankCustomer : customerList)
            {
                if(name.equalsIgnoreCase(bankCustomer.name))
                {
                    System.out.print("\n[ Customer with name '"+name+"' has already an account in bank, cannot create with same name! ]\n");
                    return;
                }
            }
            customerList.add(new BankCustomer());
            customerList.get(customerList.size()-1).FillMeIn(name, phone_no);
        }

        public void ShowBankLogs()
        {
            Vector<String> currentCustomerDetails = new Vector<String>();
            File clear = new File("BankLog.txt");
            clear.delete();
            printer = printer.GivePrinter("Bank", "BankLog.txt");
            System.out.print("\n\n\n-----------------------------------------------------------------------------------\nName\t\t\tBalance(Rs.)\tAccount No.\t\t\tContact No.\n-----------------------------------------------------------------------------------");
            for (BankCustomer bankCustomer : customerList)
            {
                currentCustomerDetails = bankCustomer.DisplayContents();
                printer.WriteToFile(currentCustomerDetails);
            }
            System.out.print("\n\n> Banks' customers details written to the file BankLog.txt\n");
            System.out.print("-----------------------------------------------------------------------------------\n");
        }

        public void CheckBalanceAndLogs(String name)
        {
            for (BankCustomer bankCustomer : customerList)
            {
                if(name.equalsIgnoreCase(bankCustomer.name))
                {
                    Scanner in = new Scanner(System.in);
                    bankCustomer.DisplayTransLogsOfCustomer();
                    System.out.print("\nDo you want to print this details to the Log File?\n(Press any key for 'Yes' / Press '!' for 'No') : ");
                    String PrintOrNot = in.next();
                    if(PrintOrNot != "!")
                    {
                        bankCustomer.FileProvider();
                    }
                    System.out.print("-----------------------------------------------------------------------\n");
                    // in.close();
                    return;
                }
            }
            System.out.print("\nCustomer with name '"+name+"' is not found !\n");
            return;
        }

        public void Deposit(String nameOfCustomer, float AddToBalance)
        {
            for (BankCustomer bankCustomer : customerList)
            {
                if(bankCustomer.name.equalsIgnoreCase(nameOfCustomer))
                {
                    bankCustomer.Deposit(AddToBalance);
                    return;
                }
            }
            System.out.print("\nCustomer with name '"+nameOfCustomer+"' is not found !\n");
            return;
        }

        public void Withdraw(String nameOfCustomer, float RemoveFromBalance)
        {
            for (BankCustomer bankCustomer : customerList)
            {
                if(bankCustomer.name.equalsIgnoreCase(nameOfCustomer))
                {
                    bankCustomer.Withdraw(RemoveFromBalance);
                    return;
                }
            }
            System.out.print("\nCustomer with name '"+nameOfCustomer+"' is not found !\n");
            return;
        }
}
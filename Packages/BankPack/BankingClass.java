package Packages.BankPack;
import Packages.CustomerActions.BankCustomer;
import java.util.ArrayList;

public class BankingClass implements BankInterface
{
    private
        ArrayList<BankCustomer> customerList = new ArrayList<BankCustomer>();
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
            customerList.add(new BankCustomer());
            customerList.get(customerList.size()-1).FillMeIn(name, phone_no);
        }

        public void ShowBankLogs()
        {
            System.out.print("\nName\t\tBalance(Rs.)\tAccount No.\tContact No.\n----------------------------------------------------------");
            for (BankCustomer bankCustomer : customerList)
            {
                bankCustomer.DisplayContents();
            }
            System.out.print("\n----------------------------------------------------------");
        }

        public void CheckBalanceAndLogs(String name)
        {
            for (BankCustomer bankCustomer : customerList)
            {
                if(name.equalsIgnoreCase(bankCustomer.name))
                    bankCustomer.DisplayTransLogsOfCustomer();
                    return;
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
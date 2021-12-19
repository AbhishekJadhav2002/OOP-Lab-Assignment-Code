package Packages.CustomerActions;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.io.*;

public class BankCustomer
{
    public String name;
    private String account_no, phone_no;
    private float balance = 0.0F;
    private LogPrinter<String> printer = new LogPrinter<String>();
    protected Vector<Vector<String>> TransDetails = new Vector<Vector<String>>();

    public void FileProvider()
    {
        File clear = new File("LogFile_"+account_no+".txt");
        clear.delete();
        printer = printer.GivePrinter("Customer", "LogFile_"+account_no+".txt");
        for (Vector<String> TransVector : TransDetails)
        {
            printer.WriteToFile(TransVector);
        }
        System.out.print("\n> Transitions Log contents written to the file "+printer.LogFileName+"\n");
        return;
    }

    public void FillMeIn(String name, String phone_no)
    {
        this.name = name;
        this.phone_no = phone_no;
        LocalDateTime date = LocalDateTime.now();
        balance = 0;
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        this.account_no = date.format(myFormatObj) + Integer.toString(date.getNano());

    }

    public Vector<String> DisplayContents()
    {
        System.out.print("\n"+name+"\t\t"+balance+"\t\t"+account_no+"\t\t"+phone_no);
        Vector<String> customerDetailsVector = new Vector<String>();
        customerDetailsVector.add(name);
        customerDetailsVector.add(account_no);
        customerDetailsVector.add(phone_no);
        return customerDetailsVector;
    }

    public void Deposit(float AddToBalance)
    {
        TransactionsClass transactions = TransactionTypeFactory.ReturnTransactionClassObject(TransactionTypeEnum.DEPOSIT);
        balance = transactions.Perform(balance, AddToBalance);
        Vector<String> DetailsTempVector = new Vector<String>();
        DetailsTempVector.add(TransactionTypeEnum.DEPOSIT.toString());
        DetailsTempVector.add(Float.toString(AddToBalance));
        DetailsTempVector.add(transactions.TransID + TransDetails.size());
        TransDetails.add(DetailsTempVector);
        System.out.print("\n\n------------------------------ Deposit ------------------------------\nCustomer with name '"+name+"' deposited : Rs."+AddToBalance+"\nTransaction ID : "+transactions.GiveTransLogID()+"\t\tUpdated Balance : Rs."+balance+"\n---------------------------------------------------------------------\n");
        return;
    }

    public void Withdraw(float RemoveFromBalance)
    {
        if(balance <= 50000 && RemoveFromBalance/balance < 0.83)
        {
            TransactionsClass transactions = TransactionTypeFactory.ReturnTransactionClassObject(TransactionTypeEnum.WITHDRAW);
            balance = transactions.Perform(balance, RemoveFromBalance);
            Vector<String> DetailsTempVector = new Vector<String>();
            DetailsTempVector.add(TransactionTypeEnum.WITHDRAW.toString());
            DetailsTempVector.add(Float.toString(RemoveFromBalance));
            DetailsTempVector.add(transactions.TransID + TransDetails.size());
            TransDetails.add(DetailsTempVector);
            System.out.print("\n\n------------------------------- Withdraw -------------------------------\nCustomer with name '"+name+"' withdrawn : Rs."+RemoveFromBalance+" (+2% Taxes)\nTransaction ID : "+transactions.GiveTransLogID()+"\t\tUpdated Balance : Rs."+balance+"\n------------------------------------------------------------------------\n");
            return;
        }
        else
        {
            System.out.print("\n\n------------------------------- Withdraw -------------------------------\nCustomer with name '"+name+"' tried withdrawal of 'Rs."+RemoveFromBalance+"', is failed due to...\n[ *Withdrawal greater than '83%' of total balance while balance being greater than Rs.50,000 ]\nCurrent balance is : "+balance+"\n------------------------------------------------------------------------\n");
            return;
        }
    }

    public void DisplayTransLogsOfCustomer()
    {
        System.out.print("\n\n-------------------------- Transition Details -------------------------\n\t\t\tName of customer : "+name+"\n\nIndex No.\tTransaction Type\tAmount(Rs)\tTransaction ID\n-----------------------------------------------------------------------");
        int i = 1;
        for (Vector<String> vector : TransDetails)
        {
            System.out.print("\n  "+i+"\t\t"+vector.get(0)+" \t\t"+vector.get(1)+"\t\t"+vector.get(2));
            i++;
        }
        System.out.print("\n-----------------------------------------------------------------------");
        System.out.print("\nBalance available in account '"+account_no+"' : Rs."+balance+"\n-----------------------------------------------------------------------\n");
    }
}
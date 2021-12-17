package Packages.BankPack;

public interface BankInterface
{
    void CreateAccount(String name, String phone_no);

    void ShowBankLogs();

    void CheckBalanceAndLogs(String name);

    void Deposit(String nameOfCustomer, float AddToBalance);

    void Withdraw(String nameOfCustomer, float RemoveFromBalance);
}
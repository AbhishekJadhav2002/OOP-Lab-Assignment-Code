package Packages.CustomerActions;

class Deposit extends TransactionsClass
{
    @Override
        float Perform(float balance, float AddToBalance)
        {
            TransID = super.GiveTransLogID();
            return (balance + AddToBalance);
        }
}


class Withdraw extends TransactionsClass
{
    @Override
        float Perform(float balance, float RemoveFromBalance)
        {
            TransID = super.GiveTransLogID();
            return Math.abs(balance - RemoveFromBalance - RemoveFromBalance*0.02F);
        }
}
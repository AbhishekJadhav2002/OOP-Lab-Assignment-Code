package Packages.CustomerActions;

class TransactionTypeFactory
{
    static TransactionsClass ReturnTransactionClassObject(TransactionTypeEnum type)
    {
        switch(type)
        {
            case WITHDRAW:
                return new Withdraw();

            case DEPOSIT:
                return new Deposit();

            default :
                return null;
        }
    }
}
package Packages.CustomerActions;
import java.time.*;
import java.time.format.DateTimeFormatter;

abstract class TransactionsClass extends BankCustomer
{
    String TransID;

    String GiveTransLogID()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        return (date.format(myFormatObj) + Integer.toString(date.getDayOfWeek().getValue()) + Integer.toString(TransDetails.size()));
    }

    abstract float Perform(float balance, float AddOrRemove);
}
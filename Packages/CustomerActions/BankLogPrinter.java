package Packages.CustomerActions;
import java.util.Vector;

class BankLogPrinter<G> extends LogPrinter<G>
{
    BankLogPrinter(String LogFileName)
    {
        super.LogFileName = LogFileName;
    }

    @Override
        public void WriteToFile(Vector<G> bankCustomer)
        {
            super.WriteToFile(bankCustomer);
            return;
        }
}
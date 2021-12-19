package Packages.CustomerActions;
import java.util.Vector;

class CustomerLogPrinter<G> extends LogPrinter<G>
{
    CustomerLogPrinter(String LogFileName)
    {
        super.LogFileName = LogFileName;
    }

    @Override
        public void WriteToFile(Vector<G> customerLogs)
        {
            super.WriteToFile(customerLogs);
            return;
        }
}
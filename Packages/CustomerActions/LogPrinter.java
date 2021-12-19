package Packages.CustomerActions;
import Packages.FileHandler.PrinterMethodsImple;
import java.util.Vector;

public class LogPrinter<G>
{
    private PrinterMethodsImple printer = new PrinterMethodsImple();
    String LogFileName;

    public LogPrinter<G> GivePrinter(String TypeOfPrinter, String LogFileName)
    {
        this.LogFileName = LogFileName;
        switch(TypeOfPrinter)
        {
            case "Customer":
                return new CustomerLogPrinter<G>(LogFileName);

            case "Bank":
                return new BankLogPrinter<G>(LogFileName);
        }
        return null;
    }

    public void WriteToFile(Vector<G> Details)
    {
        for (G stringsOfLine : Details)
        {
            printer.AppendToFile(LogFileName, stringsOfLine.toString()+"\t\t");
        }
        printer.AppendToFile(LogFileName, "\n");
        return;
    }
}
package Packages.FileHandler;
import java.io.*;

public class PrinterMethodsImple implements PrinterMethods
{
    private
        String FileName;

    @Override
        public void MakeFile(String FileName)
        {
            try
            {
                File getPath = new File(FileName);
                this.FileName = FileName;
                getPath.createNewFile();
                System.out.print("\nLog file '"+FileName+"' created at path "+getPath.getAbsolutePath()+" !\n");
            }
            catch (IOException e)
            {
                System.out.print("\n[ Error : Unexpected exception occurred while creating the log file ]\n");
                e.printStackTrace();
            }
        }

        public void AppendToFile(String FileName, String CustomerDetails)
        {
            PrintWriter writer;
            try
            {
                this.FileName = FileName;
                writer = new PrintWriter(new BufferedWriter(new FileWriter(this.FileName, true)));
                writer.write(CustomerDetails);
                writer.close();
                return;
            }
            catch (IOException e)
            {
                System.out.print("\n[ Error : Unexpected exception occurred while opening the log file '"+FileName+"' ]\n");
                e.printStackTrace();
            }
        }
}
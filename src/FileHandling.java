/*
============================================================================
 Name : FileHandling.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 8
============================================================================
*/
import java.io.*;

class Operations
{
    private
        String FileName;
        BufferedReader input;

    public
        Operations(String FileName)
        {
            this.FileName = FileName;
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        void ViewRecords() throws IOException
        {
            BufferedReader read_file = new BufferedReader(new FileReader(this.FileName));
            System.out.print("\n\nLine No.\tName  \t\tRoll No.\tMarks \tAddress\n------------------------------------------------------------------\n");
            String line;
            String[] line_contents;
            int i = 1;
            while((line = read_file.readLine()) != null)
            {
                line_contents = line.split(" ");
                System.out.print("  "+i+"\t\t"+line_contents[0]+" "+line_contents[1]+"\t"+line_contents[2]+"\t\t"+line_contents[3]+"\t"+line_contents[4]+"\n");
                i++;
            }
            read_file.close();
        }

        void AddRecord() throws IOException
        {
            String name, address;
            int roll_no, marks;
            PrintWriter write_file = new PrintWriter(new BufferedWriter(new FileWriter(FileName, true)));
            System.out.print("\nEnter Name : ");
            name = input.readLine();
            System.out.print("Enter Roll no. : ");
            roll_no = Integer.parseInt(input.readLine());
            System.out.print("Enter Marks : ");
            marks = Integer.parseInt(input.readLine());
            System.out.print("Enter Address : ");
            address = input.readLine();
            write_file.write(name+" "+roll_no+" "+marks+" "+address+"\n");
            System.out.print("\nRecord added successfully !");
            write_file.close();
        }

        void SearchRecord(String first_name) throws IOException
        {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            String search_line;
            int i = 1;
            while((search_line = reader.readLine()) != null)
            {
                String[] line_contents = search_line.split(" ");
                if(line_contents[0].contentEquals(first_name))
                {
                    System.out.print("\nRecord Found on Line No. "+i+" !");
                    System.out.print("\n\nLine No.\tName  \t\tRoll No.\tMarks \tAddress\n------------------------------------------------------------------\n");
                    System.out.print("  "+i+"\t\t"+line_contents[0]+" "+line_contents[1]+"\t"+line_contents[2]+"\t\t"+line_contents[3]+"\t"+line_contents[4]+"\n");
                    reader.close();
                    return;
                }
                else
                {
                    i++;
                }
            }
            System.out.print("\nRecord '"+first_name+"' not Found in "+FileName);
            reader.close();
            return;
        }

        void UpdateRecord(String first_name) throws IOException
        {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            PrintWriter write_to_updated = new PrintWriter(new BufferedWriter(new FileWriter("tempFile.txt", true)));
            String line;
            int i = 1;
            while((line = reader.readLine()) != null)
            {
                String[] line_contents = line.split(" ");
                if(!first_name.equals(line_contents[0]))
                {
                    write_to_updated.write(line+"\n");
                    i++;
                }
                else
                {
                    System.out.print("\nRecord '"+first_name+"' found on Line No. "+i+" !");
                    String name, address;
                    int roll_no, marks;
                    System.out.print("\nEnter Name : ");
                    name = input.readLine();
                    System.out.print("Enter Roll no. : ");
                    roll_no = Integer.parseInt(input.readLine());
                    System.out.print("Enter Marks : ");
                    marks = Integer.parseInt(input.readLine());
                    System.out.print("Enter Address : ");
                    address = input.readLine();
                    write_to_updated.write(name+" "+roll_no+" "+marks+" "+address+"\n");
                    reader.close();
                    write_to_updated.close();
                    File delete_file = new File(FileName);
                    delete_file.delete();
                    File rename_file = new File("tempFile.txt");
                    rename_file.renameTo(delete_file);
                    System.out.print("\nRecord updated successfully on line No. "+i+" !");
                    System.out.print("\n\nLine No.\tName  \t\tRoll No.\tMarks \tAddress\n------------------------------------------------------------------\n");
                    System.out.print("  "+i+"\t\t"+name+"\t"+roll_no+"\t\t"+marks+"\t"+address+"\n");
                    return;
                }
            }
            System.out.print("\nRecord "+first_name+" is not found in "+FileName);
            reader.close();
            write_to_updated.close();
            return;
        }

        void DeleteRecord(String first_name) throws IOException
        {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            PrintWriter write_to_new = new PrintWriter(new BufferedWriter(new FileWriter("tempFile.txt", true)));
            String line;
            int i = 1;
            while((line = reader.readLine()) != null)
            {
                String[] line_contents = line.split(" ");
                if(!first_name.equalsIgnoreCase(line_contents[0]))
                {
                    write_to_new.write(line+"\n");
                    i++;
                }
                else
                {
                    System.out.print("\nRecord '"+first_name+"' found on Line No. "+i+" !");
                    reader.close();
                    write_to_new.close();
                    File delete_file = new File(FileName);
                    delete_file.delete();
                    File rename_file = new File("tempFile.txt");
                    rename_file.renameTo(delete_file);
                    System.out.print("\nRecord deleted successfully !");
                    return;
                }
            }
            System.out.print("\nRecord "+first_name+" is not found in "+FileName);
            reader.close();
            write_to_new.close();
            return;
        }

        void ClearRecords() throws IOException, InterruptedException
        {
            PrintWriter blanked_file = new PrintWriter(new BufferedWriter(new FileWriter(FileName)));
            blanked_file.close();
            Thread.sleep(1000);
            System.out.print("\nAll records cleared successfully !");
        }
}

public class FileHandling
{
    public static void main(String[] args) throws Exception, IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Operations file = new Operations("StudentData.txt");
        while(true)
        {
            System.out.print("\n\nChoose Operation -\n1.View Records\t2.Add Record\t3.Search Record \t4.Update Record \t5.Delete Record \t6.Clear Records \t7.Exit\n\t\t\t\t \t Choose Operation : ");
            int choice = Integer.parseInt(input.readLine());
            switch(choice)
            {
                case 1:
                    file.ViewRecords();
                    continue;

                case 2:
                    file.AddRecord();
                    continue;
                
                case 3:
                    System.out.print("\nEnter first name to be searched : ");
                    String first_name = input.readLine();
                    file.SearchRecord(first_name);
                    continue;

                case 4:
                    System.out.print("\nEnter first name to be updated : ");
                    String update_name = input.readLine();
                    file.UpdateRecord(update_name);
                    continue;

                case 5:
                    System.out.print("\nEnter first name to be deleted : ");
                    String delete_name = input.readLine();
                    file.DeleteRecord(delete_name);
                    continue;

                case 6:
                    file.ClearRecords();
                    continue;

                case 7:
                    System.out.print("\n-------Program Terminated-------");
                    return;
            }
        }
    }
}
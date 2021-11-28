/*
============================================================================
 Name : FileHandling.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 8
============================================================================
*/
import java.io.*;   //package containing almost every class for input and output in file or console

class Operations    //class with all file operations
{
    private
        String FileName;    //filename which is given by user is stored on here and kept private to avoid vulnerabilities
        BufferedReader input;   //declaring a object for getting inputs from user throughout the execution of this class

    public
        Operations(String FileName)     //Declared a parameterized constructor to get and set FileName in the class object's initialization
        {
            this.FileName = FileName;
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        void ViewRecords() throws IOException    //method to read from the provided file using BufferedReader and showing it's data in formatted manner
        {
            BufferedReader read_file = new BufferedReader(new FileReader(this.FileName));   //BufferedReader reads text from a character-input stream(or file), buffering characters so as to provide for the efficient reading of characters, arrays, and lines
            System.out.print("\n\nLine No.\tName  \t\tRoll No.\tMarks \tAddress\n------------------------------------------------------------------\n");
            String line;    //string line to store the each read line from file in each iteration of while loop
            String[] line_contents;     //string array to store the content of string line spitted by a some delimiter
            int i = 1;    //integer to keep count of lines read in while loop
            while((line = read_file.readLine()) != null)    //while loop continues iterations till readLine returns null i.e. last line(empty) of file
            {
                line_contents = line.split(" ");    //splits the read string with whenever specified delimiter is encountered and stored in array
                System.out.print("  "+i+"\t\t"+line_contents[0]+" "+line_contents[1]+"\t"+line_contents[2]+"\t\t"+line_contents[3]+"\t"+line_contents[4]+"\n");    //prints the contents of string array in tabular way
                i++;
            }
            read_file.close();
        }

        void AddRecord() throws IOException    //method to add(write) person's details to the file using PrintWriter class
        {
            String name, address;
            int roll_no, marks;
            PrintWriter write_file = new PrintWriter(new BufferedWriter(new FileWriter(FileName, true)));   //creating object of PrintWriter class with file in append mode to add contents one by one in the same file
            System.out.print("\nEnter Name : ");
            name = input.readLine();
            System.out.print("Enter Roll no. : ");
            roll_no = Integer.parseInt(input.readLine());
            System.out.print("Enter Marks : ");
            marks = Integer.parseInt(input.readLine());
            System.out.print("Enter Address : ");
            address = input.readLine();
            write_file.write(name+" "+roll_no+" "+marks+" "+address+"\n");  //write method of PrintWriter class is used to write content to file in formatted way using basic string formatting
            System.out.print("\nRecord added successfully !");
            write_file.close();
        }

        void SearchRecord(String first_name) throws IOException    //method to search a given string i.e. firstname in the file using BufferedReader
        {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));   //making object of BufferedReader to open and read from file 
            String search_line;     //string to store each read line from the file
            int i = 1;    //integer to keep count of lines read in while loop
            while((search_line = reader.readLine()) != null)    //while loop continues iterations till readLine returns null i.e. last line(empty) of file
            {
                String[] line_contents = search_line.split(" ");    //splits the read string with whenever specified delimiter is encountered and stored in array
                if(line_contents[0].contentEquals(first_name))    //compares first word read from file with string passed to the method
                {
                    System.out.print("\nRecord Found on Line No. "+i+" !");    //indicates the line no. at which the record is found in file
                    System.out.print("\n\nLine No.\tName  \t\tRoll No.\tMarks \tAddress\n------------------------------------------------------------------\n");
                    System.out.print("  "+i+"\t\t"+line_contents[0]+" "+line_contents[1]+"\t"+line_contents[2]+"\t\t"+line_contents[3]+"\t"+line_contents[4]+"\n");
                    reader.close();
                    return;
                }
                else
                {
                    i++;    //if firstname does not matches, then increment line no.
                }
            }
            System.out.print("\nRecord '"+first_name+"' not Found in "+FileName);
            reader.close();
            return;
        }

        void UpdateRecord(String first_name) throws IOException    //method to search particular name and update it in file
        {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));    //reader  to read through file used to find particular record to be updated
            PrintWriter write_to_updated = new PrintWriter(new BufferedWriter(new FileWriter("tempFile.txt", true)));    //writer to write updated details to temporary file
            String line;    //string to store each read line from the file
            int i = 1;    //integer to keep count of lines read in while loop
            while((line = reader.readLine()) != null)    //while loop continues iterations till readLine returns null i.e. last line(empty) of file
            {
                String[] line_contents = line.split(" ");    //splits the read string with whenever specified delimiter is encountered and stored in array
                if(!first_name.equals(line_contents[0]))    //if first name does not matches with file record then it's written to tempFile
                {
                    write_to_updated.write(line+"\n");
                    i++;    //incrementing line no. as loop keep iterating through file
                }
                else
                {
                    System.out.print("\nRecord '"+first_name+"' found on Line No. "+i+" !");    //indicates the line no. at which the record is found in file
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
                    write_to_updated.write(name+" "+roll_no+" "+marks+" "+address+"\n");    //here updated details are written to tempFile which was required
                    reader.close();
                    write_to_updated.close();
                    File delete_file = new File(FileName);    //accessing old file which is outdated
                    delete_file.delete();    //deleting old file
                    File rename_file = new File("tempFile.txt");    //accessing newly made tempFile which shall be renamed ahead to FileName
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

        void DeleteRecord(String first_name) throws IOException    //method to delete particular name from file
        {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));    //BufferedReader to read through file
            PrintWriter write_to_new = new PrintWriter(new BufferedWriter(new FileWriter("tempFile.txt", true)));    //writer to write updated details to temporary file
            String line;    //string to store each read line from the file
            int i = 1;    //integer to keep count of lines read in while loop
            while((line = reader.readLine()) != null)    //while loop continues iterations till readLine returns null i.e. last line(empty) of file
            {
                String[] line_contents = line.split(" ");    //splits the read string with whenever specified delimiter is encountered and stored in array
                if(!first_name.equalsIgnoreCase(line_contents[0]))    //if first name does not matches with file record then it's written to tempFile
                {
                    write_to_new.write(line+"\n");
                    i++;    //incrementing line no. as loop keep iterating through file
                }
                else    //if first name matches, then it;s not written in the tempFile i.e. deletion takes place
                {
                    System.out.print("\nRecord '"+first_name+"' found on Line No. "+i+" !");    //indicates the line no. at which the record is found in file
                    reader.close();
                    write_to_new.close();
                    File delete_file = new File(FileName);    //accessing old file which is outdated
                    delete_file.delete();    //deleting old file
                    File rename_file = new File("tempFile.txt");    //accessing newly made tempFile which shall be renamed ahead to FileName
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

        void ClearRecords() throws IOException, InterruptedException    //method to clear all records of file
        {
            PrintWriter blanked_file = new PrintWriter(new BufferedWriter(new FileWriter(FileName)));    //creating file with same name which will override the old file
            blanked_file.close();
            Thread.sleep(1000);
            System.out.print("\nAll records cleared successfully !");
        }
}

public class FileHandling
{
    public static void main(String[] args) throws Exception, IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    //creating object of BufferedReader to take input from user
        Operations file = new Operations("StudentData.txt");    //creating object of our class to access File Handling methods
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
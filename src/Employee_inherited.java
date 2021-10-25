/*
============================================================================
 Name : Employee_inherited.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 2
============================================================================
*/

import java.util.Scanner;

class Employee
{   
    public
        String name;
        String email;
        int id;
        String num;

        void getdata(int n)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("\nEmployee no. "+(n+1)+" - \n");
            System.out.print("Enter Details of Employee -\n---------------------------\nEnter Name : ");
            name = input.nextLine();
            System.out.print("\nEnter Email : ");
            email = input.nextLine();
            System.out.print("\nEnter Mobile Number : ");
            num = input.nextLine();
        }

        void Display(int n, int i)
        {
            System.out.print("---------------------------\nDisplaying payment slip of Employee No. "+(n+1)+" >\n\n\tName of the Employee\t\tEmail of the Employee\t\t\tDesignation\n\t-----------------------------------------------------------------------------------\n\t "+name+"\t\t\t "+email);
            // System.out.print("\nEmail of the Employee : "+email+"\n\nDesignation : ");
            switch(i)
            {
                case 1:
                    System.out.print("\t\t\t\tProgrammer");
                    break;
                case 2:
                    System.out.print("\t\t\t\tTeam Leader");
                    break;
                case 3:
                    System.out.print("\t\t\t\tAssistant Project Manager");
                    break;
                case 4:
                    System.out.print("\t\t\t\tProject Manager");
            }
        }
}


class Programmer extends Employee
{
    int bp = 50000;
    void display_pro(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\n\nPayment Details >\n\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t------------------------------------------------------------------\n\tRs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\tRs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\tRs."+0.001*bp+" :)");
    }
}


class ProjectManager extends Employee
{
    int bp = 100000;
    void display_pm(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\n\nPayment Details >\n\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t------------------------------------------------------------------\n\tRs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\tRs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\tRs."+0.001*bp+" :)");
    }
}


class teamLeader extends Employee
{
    int bp = 70000;
    void display_lead(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\n\nPayment Details >\n\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t------------------------------------------------------------------\n\tRs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\tRs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\tRs."+0.001*bp+" :)");
    }
}


class Assistant extends Employee
{
    int bp = 40000;
    void display_assi(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\n\nPayment Details >\n\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t------------------------------------------------------------------\n\tRs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\tRs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\tRs."+0.001*bp+" :)");
    }
}


public class Employee_inherited
{
    public static void main( String [] args )
    {
        Programmer pro = new Programmer();
        teamLeader lead = new teamLeader();
        Assistant Assist = new Assistant();
        ProjectManager pm = new ProjectManager();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no. of employees to be added : ");
        int n;
        n = input.nextInt();
        for (int i = 0; i < n; i++)
        {
            System.out.print("\nEmployee Designation -\t1.Programmer\t2.Team Lead\t3.Assistant Project Manager\t4.Project Manager\n\t\t\t\tSelect Designation (1/2/3/4) : ");
            int designation = input.nextInt();
            switch(designation)
            {
                case 1:
                    pro.getdata(i);
                    pro.display_pro(i, designation);
                    break;
                case 2:
                    lead.getdata(i);
                    lead.display_lead(i, designation);
                    break;
                case 3:
                    Assist.getdata(i);
                    Assist.display_assi(i, designation);
                    break;
                case 4:
                    pm.getdata(i);
                    pm.display_pm(i, designation);
                    break;
                default :
                    System.out.println("Wrong Choice ! Please select between 1/2/3/4");
            }
        }
    }
}
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
        // double bp= 0.00;
        // double ns = bp*0.97 + bp*0.1 - bp*0.12 - bp*0.01;
        // int n = 5;
        // String[] name = new String[n];
        // String[] email = new String[n];
        // int[] id = new int[n];
        // String[] num = new String[n];
        // float[] bp = new float[n];
        // float[] ns = new float[n];

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
            System.out.println("---------------------------\nDisplaying details of Employee No. "+(n+1)+" -\n\nName of the Employee : "+name);
            System.out.print("\nEmail of the Employee : "+email+"\n\nDesignation : ");
            switch(i)
            {
                case 1:
                    System.out.print("Programmer");
                    break;
                case 2:
                    System.out.print("Team Leader");
                    break;
                case 3:
                    System.out.print("Assistant Project Manager");
                    break;
                case 4:
                    System.out.print("Project Manager");
            }
        }
}


class programmer extends Employee
{
    int bp = 50000;
    void display_pro(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\nPayment Slip >\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t Rs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\t Rs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\t    Rs."+0.001*bp+" :)");
    }
}


class ProjectManager extends Employee
{
    int bp = 100000;
    void display_pm(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\nPayment Slip >\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t Rs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\t Rs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\t    Rs."+0.001*bp+" :)");
    }
}


class teamLeader extends Employee
{
    int bp = 70000;
    void display_lead(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\nPayment Slip >\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t Rs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\t Rs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\t    Rs."+0.001*bp+" :)");
    }
}


class Assistance extends Employee
{
    int bp = 40000;
    void display_assi(int i, int n)
    {
        super.Display(i, n);
        System.out.print("\nPayment Slip >\n\tGross Salary\t\t\tNet Salary\t\tDeductions\n\t Rs."+(0.97*bp+0.10*bp+0.12*bp+0.001*bp)+"\t\t\t Rs."+(0.97*bp + 0.10*bp + 0.12*bp)+"\t\t    Rs."+0.001*bp+" :)");
    }
}


public class Employee_inherited
{
    public static void main( String [] args )
    {
        programmer pro = new programmer();
        teamLeader lead = new teamLeader();
        Assistance Assistant = new Assistance();
        ProjectManager pm = new ProjectManager();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no. of employees to be added : ");
        int n;
        n = input.nextInt();
        for (int i = 0; i<n; i++)
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
                    Assistant.getdata(i);
                    Assistant.display_assi(i, designation);
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
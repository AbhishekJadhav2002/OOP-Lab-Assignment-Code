/*
Assignment no1 : Classes and Objects
Instructions
Design a class ‘Complex ‘with data members for real and imaginary part. Provide default and Parameterized constructors. Write a program to perform arithmetic operations of two complex numbers. Design a class ‘Complex ‘with data members for real and imaginary part. Provide default and Parameterized constructors. Write a program to perform arithmetic operations of two complex numbers.*/

import java.util.Scanner;
class complex
{
    float real;
    float imaginary;

    public complex()  //constructor for complex no. template
    {
        real = 0 ;
        imaginary = 0;
    }
    
    public 
        void get_data(complex c1, complex c2) //method for taking input
            {
                Scanner input = new Scanner(System.in);
                System.out.println("\n Enter Real part of Complex no. 1 : ");
                c1.real = input.nextInt();
                System.out.println("\n Enter Imaginary part of Complex no. 1 : ");
                c1.imaginary = input.nextInt();
                System.out.println("\n-------------------------------------------\n Real part of Complex no. 1 is : "+c1.real);
                System.out.println("\n Imaginary part of Complex no. 1 is : "+c1.imaginary+"i\n-------------------------------------------");
                System.out.println("\n Enter Real part of Complex no. 2 : ");
                c2.real = input.nextInt();
                System.out.println("\n Enter Imaginary part of Complex no. 2 : ");
                c2.imaginary = input.nextInt();
                System.out.println("\n-------------------------------------------\n Real part of Complex no. 2 is : "+c2.real);
                System.out.println("\n Imaginary part of Complex no. 2 is : "+c2.imaginary+"i\n-------------------------------------------");
            }

        void add(complex c1, complex c2)  //method to add complex no. and display as well
            {
                real = c1.real + c2.real;
                imaginary = c1.imaginary + c2.imaginary;
            }

        void subtract(complex c1, complex c2)  //method to subtract complex no. and display as well
            {
                real = c1.real - c2.real;
                imaginary = c1.imaginary - c2.imaginary;
            }

        void multiply(complex c1, complex c2)  //method to multiply complex no. and display as well
            {
                real = c1.real * c2.real;
                imaginary = c1.imaginary * c2.imaginary;
            }

        void divide(complex c1, complex c2)  //method to divide complex no. and display as well
            {
                real = (c1.real*c2.real)+(c1.imaginary*c2.imaginary) / (c2.real*c2.real)+(c2.imaginary*c2.imaginary);
                imaginary = (c1.imaginary*c2.real)-(c1.real*c2.imaginary) / (c2.real*c2.real)+(c2.imaginary*c2.imaginary);
            }
}


public class Complex_working
{
    public static void main(String [] args)
        {
            complex cal = new complex();  //creating object for class complex
            complex c1 = new complex();  //declaring 1st complex no.
            complex c2 = new complex();  //declaring 2nd complex no.
            cal.get_data(c1, c2);  //calling method get_data to take input 1st
            Scanner input = new Scanner(System.in);
            int choose;
            do
            {
                System.out.println("\nSelect ->    1. ADD\t2. SUBTRACT\t3. MULTIPLY\t4. DIVIDE\t5. EXIT\n");
                System.out.println("Enter your choice  (1 / 2 / 3 / 4 / 5) : ");
                choose = input.nextInt();  //taking choices now
                switch(choose)
                {
                    case 1 :
                        cal.add(c1, c2);  //calling specific methods for that respective choice
                        System.out.println("\n--------------------------------------------------------------\n Addition of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+cal.real+" + "+cal.imaginary+"i]\n--------------------------------------------------------------\n");
                        break;
                    case 2 :
                        cal.subtract(c1, c2);
                        System.out.println("\n--------------------------------------------------------------\n Subtraction of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+cal.real+" + "+cal.imaginary+"i]\n--------------------------------------------------------------\n");
                        break;
                    case 3 :
                        cal.multiply(c1, c2);
                        System.out.println("\n--------------------------------------------------------------\n Multiplication of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+cal.real+" + "+cal.imaginary+"i]\n--------------------------------------------------------------\n");
                        break;
                    case 4 :
                        cal.divide(c1, c2);
                        System.out.println("\n--------------------------------------------------------------\n Division of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+cal.real+" + "+cal.imaginary+"i]\n--------------------------------------------------------------\n");
                        break;
                    case 5 :
                        System.out.println("\n\t--------------------\n\t Program Terminated \n\t--------------------");
                        break;
                }
            }while(choose != 5);
        }
}

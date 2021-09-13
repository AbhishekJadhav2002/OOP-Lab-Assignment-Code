/*
Assignment no1 : Classes and Objects
Instructions
Design a class ‘Complex ‘with data members for real and imaginary part. Provide default and Parameterized constructors. Write a program to perform arithmetic operations of two complex numbers. Design a class ‘Complex ‘with data members for real and imaginary part. Provide default and Parameterized constructors. Write a program to perform arithmetic operations of two complex numbers.*/

import java.util.Scanner;
class complex
{
    float real , imaginary;

    public complex(float r, float i)
    {
        real = r ;
        imaginary = i;
    }

    public void get_data()
    {
        Scanner input = new Scanner(System.in);
        complex c1 = new complex(real,imaginary);
        complex c2 = new complex(real,imaginary);
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

    static void add()
    {
        float result_real, result_imaginary;
        complex c1 = new complex(real,imaginary);
        complex c2 = new complex(real,imaginary);
        result_real = c1.real + c2.real;
        result_imaginary = c1.imaginary + c2.imaginary;
        System.out.println("\n--------------------------------------------------------------\n Addition of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+result_real+" + "+result_imaginary+"i]\n--------------------------------------------------------------\n");
    }
    static void subtract()
    {
        float result_real, result_imaginary;
        complex c1 = new complex(real,imaginary);
        complex c2 = new complex(real,imaginary);
        result_real = c1.real - c2.real;
        result_imaginary = c1.imaginary - c2.imaginary;
        System.out.println("\n--------------------------------------------------------------\n Subtraction of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+result_real+" + "+result_imaginary+"i]\n--------------------------------------------------------------\n");
    }
    static void multiply()
    {
        float result_real, result_imaginary;
        complex c1 = new complex(real,imaginary);
        complex c2 = new complex(real,imaginary);
        result_real = c1.real * c2.real;
        result_imaginary = c1.imaginary * c2.imaginary;
        System.out.println("\n--------------------------------------------------------------\n Multiplication of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+result_real+" + "+result_imaginary+"i]\n--------------------------------------------------------------\n");
    }
    static void divide()
    {
        float result_real, result_imaginary;
        complex c1 = new complex(real,imaginary);
        complex c2 = new complex(real,imaginary);
        result_real = c1.real / c2.real;
        result_imaginary = c1.imaginary / c2.imaginary;
        System.out.println("\n--------------------------------------------------------------\n Division of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : ["+result_real+" + "+result_imaginary+"i]\n--------------------------------------------------------------\n");
    }
}
public class Complex_working
{
    public static void main(String [] args)
        {
            complex cal = new complex(5, 6);
            cal.get_data();
            Scanner input = new Scanner(System.in);
            int choose;
            do
            {
                System.out.println("\nSelect ->    1. ADD\t2. SUBTRACT\t3. MULTIPLY\t4. DIVIDE\t5. EXIT\n");
                System.out.println("Enter your choice  (1 / 2 / 3 / 4 / 5) : ");
                choose = input.nextInt();
                switch(choose)
                {
                    case 1 :
                        complex.add();
                    case 2 :
                        complex.subtract();
                    case 3 :
                        complex.multiply();
                    case 4 :
                        complex.divide();
                    case 5 :
                        break;
                }
            }while(choose != 5);
        }
}
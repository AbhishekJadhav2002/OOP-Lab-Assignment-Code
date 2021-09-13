/*Assignment no2 : Prerequisite

Write a program to implement static polymorphism 
define a class calculator with multiple addition function as below 
1. add for two int numbers
2. add for three int numbers
3. add for 3 float numbers
4. add for two double number
5. add for two char numbers
Also test following
overload the main for testing*/

import java.util.Scanner;
class methods
{
    float real;
    float imaginary;
    methods(float r , float i)
    {
        real = r;
        imaginary = i;
    }
    static void add(methods c1, methods c2)
    {
        float result_r , result_i;
        result_r = c1.real + c2.real;
        result_i = c2.imaginary + c2.imaginary;
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n___Sum of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : "+result_r+" + "+result_i+"i___");
    }
    static void add(methods c1, methods c2, methods c3)
    {
        float result_r , result_i;
        result_r = c1.real + c2.real + c3.real;
        result_i = c2.imaginary + c2.imaginary + c3.imaginary;
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n___Sum of ("+c1.real+"+"+c1.imaginary+"i) and ("+c2.real+"+"+c2.imaginary+"i) is : "+result_r+" + "+result_i+"i___");
    }
}

public class polymorph
{
    //overloading main for testing
    
    static float add(float f1, float f2, float f3)
    {
        return f1+f2+f3;
    }

    static double add(double d1, double d2)
    {
        return d1+d2;
    }

    static char add(char c1, char c2, char c3)
    {
        int char_sum = (int)c1 + (int)c2 + (int)c3;
        return ((char)char_sum);
    }

    public static void main( String [] args)
    {
        Scanner input = new Scanner(System.in);
        int choose;
        do
        {
            System.out.println("\nSelect ->    1. Two Complex no.\t\t2. Three Complex no.\t3. Adding 3 float values\t4. Adding 2 double values\t5. Adding 2 characters\t\t6. Exit\n");
            System.out.println("Enter your choice  (1 / 2 / 3 / 4 / 5) : ");
            choose = input.nextInt();
            switch(choose)
            {
                case 1 :
                    int a, b, c, d;
                    System.out.println("\n\nSum of two Complex numbers C1 and C2");
                    System.out.println("-------------------------------------\n>Enter Real part of Complex no. 1 : ");
                    a = input.nextInt();
                    System.out.println("\n>Enter Imaginary part of Complex no. 1 : "+a+" + i");
                    b = input.nextInt();
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n>Enter Real part of Complex no. 2 : ");
                    c = input.nextInt();
                    System.out.println("\n>Enter Imaginary part of Complex no. 2 : "+c+" + i");
                    d = input.nextInt();
                    methods c1 = new methods(a, b);
                    methods c2 = new methods(c, d);
                    methods.add(c1, c2);
                    System.out.println("\n-------------------------------------");
                    break;
                
                case 2 :
                    int r1, i1, r2, i2, i3, r3;
                    System.out.println("\n\nSum of three Complex numbers C1 + C2 + C3");
                    System.out.println("-----------------------------------------\n>Enter Real part of Complex no. 1 : ");
                    r1 = input.nextInt();
                    System.out.println("\n>Enter Imaginary part of Complex no. 1 : "+r1+" + i");
                    i1 = input.nextInt();
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n>Enter Real part of Complex no. 2 : ");
                    r2 = input.nextInt();
                    System.out.println("\n>Enter Imaginary part of Complex no. 2 : "+r2+" + i");
                    i2 = input.nextInt();
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n>Enter Real part of Complex no. 3 : ");
                    r3 = input.nextInt();
                    System.out.println("\n>Enter Imaginary part of Complex no. 3 : "+r3+" + i");
                    i3 = input.nextInt();
                    methods C1 = new methods(r1, i1);
                    methods C2 = new methods(r2, i2);
                    methods C3 = new methods(r3, i3);
                    methods.add(C1, C2, C3);
                    System.out.println("\n-------------------------------------");
                    break;
                case 3 :
                    System.out.println("Addition of three float values : "+add(12.33f, 54.3f, 4.98f));
                    break;
                case 4 :
                    System.out.println("Addition of two double values : "+add(12.33, 54.3));
                    break;
                case 5 :
                    System.out.println("Addition of two characters : "+add('O', 'O', 'P'));
                    break;
            }
        }while(choose != 6);
    }
}
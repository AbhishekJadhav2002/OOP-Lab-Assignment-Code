/*
============================================================================
 Name : Exception_Handling.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 6
============================================================================
*/
import java.util.*;

public class Exception_Handling 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nChoose Error -\t1.ArithmeticExcepton\t2.NullPointerException\t3.NumberFormatException \t4.ArrayOutOfBoundsExcception\n\t\t\t\t\t\tEnter Choice : ");  //switch case menu for user to choose between types of errors
        int choice = sc.nextInt();
        try
        {
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter two numbers to be divided : ");
                    int n = sc.nextInt();
                    int d = sc.nextInt();
                    System.out.print("\nDivision of "+n+" and "+d+" is : "+n/d);  //Arithmetic error can be caught here if user enters denominator as zero 
                    break;

                case 2:
                    String Null = null;
                    System.out.print(Null.length());  //accessing null variable so NullPointerException can be caught
                    break;

                case 3:
                    System.out.print("\nEnter two elements to be added : ");
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    System.out.print(("\nAddition of "+n1+" and "+n2+" is : "+(n1+n2)));  //Operations on variables of mismatched data types can cause NumberFormatException
                    break;

                case 4:
                    int[] array = {1, 2, 3};
                    System.out.print("\nArray Elements are : ");
                    for(int i = 0; i < 3; i++)
                    {
                        System.out.print(" "+array[i]);  //displaying array with their elements
                    }
                    System.out.print("\nEnter index to get element : ");  //here user asked to enter index which can be out of bound
                    int e = sc.nextInt();
                    System.out.print("\nElement at index "+e+" is : "+array[e-1]);  //here entered index's element is accesses which can cause ArrayIndexOutOfBound Exception
                    break;
            }
        }
        /*-----------------catch block to get user defines messages and JVM default warning messages--------------------*/
        
        catch(ArithmeticException e){System.out.print("\nArithmetic Exception occur by diving the no. by 0 (N/0)\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(NullPointerException e){System.out.print("\nNullPointerException occur by performing any operation on Null pointer\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(NumberFormatException e){System.out.print("\nNumberFormatException occur by performing operations with mismatched data types\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(InputMismatchException e){System.out.print("\nInputMismatchException occur by performing operations with mismatched data types\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(ArrayIndexOutOfBoundsException e){System.out.print("\nArrayIndexOutOfBoundsException occur by accessing array element out of it's range\n");System.out.print("JVM default Error Message : "+e.getMessage());}
    }
}
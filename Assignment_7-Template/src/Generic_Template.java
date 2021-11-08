/*
============================================================================
 Name : Generic_Template.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 7
============================================================================
*/
import java.util.*;

class Examine
{
    private
        static int count = 0;  //used for counting whenever certain condition is satisfied
    public
        void EvenOrOdd(int n)  //method to check passed number is even or odd
        {
            if(n%2 == 0 || n == 0)
            {
                System.out.print("\n  "+n);
                count++;  //count increments by 1 to count total even numbers
            }
            else
            {
                System.out.print("\t\t "+n);
            }
        }

        void isPrime(int n)  //method to check passed number is prime or not
        {
            for(int i = 2; i <= (n/2)+1; i++)  //loop required to check is number prime or not
            {
                if((n == 0 || n == 1 || n%i == 0) && n != 2)  //conditions for corner cases 
                {
                    System.out.print("\n   "+n);
                    break;
                }
                else
                {
                    System.out.print("\t\t "+n);
                    count++;
                }
            }
        }
        
        void checkIntArray(int choice)  //method to take array input and print results for even/odd or prime
        {
            ArrayList<Integer> array = new ArrayList<Integer>();  //declaring ArrayList collection with Integer generic type
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter Array Size : ");
            int size = input.nextInt();
            int n;
            System.out.print("\nEnter "+size+" array elements : ");
            for(int i = 0; i < size; i++)
            {
                n = input.nextInt();
                array.add(n);
            }
            count = 0;
            Iterator<Integer> it = array.iterator();  //iterator through the ArrayList
            if(choice == 1)  //choice decides between even/odd or prime checking method calls
            {
                System.out.print("\nEven No.\tOdd No.\n");
                while(it.hasNext())
                {
                    EvenOrOdd((int)it.next());
                }
                System.out.print("\nNo. of Even elements in ArrayList : "+count+"\nnNo. of Odd elements in ArrayList : "+(size-count));
            }
            else
            {
                System.out.print("\nNon-Prime No.\tPrime No.\n");
                while(it.hasNext())
                {
                    isPrime((int)it.next());
                }
                System.out.print("\nNo. of Prime elements in ArrayList : "+count);
            }
        }

        void isPalindrome(String s)  //method to check given string is palindrome or not
        {
            StringBuilder s1 = new StringBuilder(s);  //StringBuilder collection
            if(s.equals(s1.reverse().toString()))  //logic to check is string palindrome
            {
                System.out.print("\n  "+s);
                count++;  //increments count for palindrome strings
            }
            else
            {
                System.out.print("\t\t "+s);
            }
        }
        
        void checkStringArray()
        {
            ArrayList<String> array = new ArrayList<String>();  //declaring ArrayList collection with String generic type
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter Array Size : ");
            int size = input.nextInt();
            String n;
            System.out.print("\nEnter "+size+" array strings : ");
            for(int i = 0; i < size; i++)
            {
                n = input.next();
                array.add(n);
            }
            count = 0;
            Iterator<String> it = array.iterator();  //iterator through the ArrayList
            System.out.print("\nPalindrome\tNon-Palindrome\n");
            while(it.hasNext())
            {
                isPalindrome((String)it.next());  //looping calls to check the string isPalindrome
            }
            System.out.print("\n\nNo. of Palindrome strings in ArrayList : "+count);
        }
}

public class Generic_Template
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        Examine generic = new Examine();
        while(true)
        {
            System.out.print("\n\nCheck : \t1. Even or Odd  \t2. Prime\t3. Palindrome\n\t\t\tEnter Operation : ");
            int choice = input.nextInt();
            if(choice == 3)
            {
                generic.checkStringArray();
            }
            else
            {
                generic.checkIntArray(choice);
            }
        }   
    }
}
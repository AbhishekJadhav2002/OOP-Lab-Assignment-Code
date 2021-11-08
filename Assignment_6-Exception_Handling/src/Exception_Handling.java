import java.util.*;

public class Exception_Handling 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nChoose Error -\t1.ArithmeticExcepton\t2.NullPointerException\t3.NumberFormatException \t4.ArrayOutOfBoundsExcception\n\t\t\t\t\t\tEnter Choice : ");
        int choice = sc.nextInt();
        try
        {
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter two numbers to be divided : ");
                    int n = sc.nextInt();
                    int d = sc.nextInt();
                    System.out.print("\nDivision of "+n+" and "+d+" is : "+n/d);
                    break;

                case 2:
                    String Null = null;
                    System.out.print(Null.length());
                    break;

                case 3:
                    System.out.print("\nEnter two elements to be added : ");
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();
                    System.out.print(("\nAddition of "+n1+" and "+n2+" is : "+(n1+n2)));
                    break;

                case 4:
                    int[] array = {1, 2, 3};
                    System.out.print("\nArray Elements are : ");
                    for(int i = 0; i < 3; i++)
                    {
                        System.out.print(" "+array[i]);
                    }
                    System.out.print("\nEnter index of element : ");
                    int e = sc.nextInt();
                    System.out.print("\nElement at index "+e+" is : "+array[e-1]);
                    break;
            }
        }
        catch(ArithmeticException e){System.out.print("\nArithmetic Exception occur by diving the no. by 0 (N/0)\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(NullPointerException e){System.out.print("\nNullPointerException occur by performing any operation on Null pointer\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(NumberFormatException e){System.out.print("\nNumberFormatException occur by performing operations with mismatched data types\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(InputMismatchException e){System.out.print("\nInputMismatchException occur by performing operations with mismatched data types\n");System.out.print("JVM default Error Message : "+e.getMessage());}

        catch(ArrayIndexOutOfBoundsException e){System.out.print("\nArrayIndexOutOfBoundsException occur by accessing array element out of it's range\n");System.out.print("JVM default Error Message : "+e.getMessage());}
    }
}
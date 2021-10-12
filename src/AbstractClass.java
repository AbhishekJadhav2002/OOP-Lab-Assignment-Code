import java.util.Scanner;
abstract class Shapes  //declaring abstract class
{
    public
        static double p1;
        static double p2;

        abstract void takeDimensions(); //abstract method with no body and abstract keyword

        abstract double compute_area();
};

class triangle extends Shapes  //inheriting abstract class into other subclasses
{
    @Override  //overriding abstract method below this flag keyword
    public
        void takeDimensions()  //overridden method with own implementation
        {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter height of triangle : ");
            double  h = input.nextDouble();
            p1 = h;
            System.out.print("\nEnter base of triangle : ");
            double b = input.nextDouble();
            p2 = b;
        }

        double compute_area()  //overridden method with own implementation
        {
            return 0.5*p1*p2;
        }
};

class rectangle extends Shapes  //inheriting abstract class into other subclasses
{
    @Override  //overriding abstract method below this flag keyword
    public
        void takeDimensions()  //overridden method with own implementation
        {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter length of rectangle : ");
            double  l = input.nextDouble();
            p1 = l;
            System.out.print("\nEnter breadth of rectangle : ");
            double b = input.nextDouble();
            p2 = b;
        }

        double compute_area()  //overridden method with own implementation
        {
            return p1*p2;
        }
};

public class AbstractClass  //Creating a test class which calls abstract and non-abstract methods
{
    public static void main(String[] args) throws Exception
    {
        Shapes s;  // reference of base/parent class
        Scanner input = new Scanner(System.in);
        char stop = 'n';
        while(stop == 'n')
        {
            System.out.print("\n\nCalculate Area of -\n\t1. Triangle\t2. Rectangle\t3. Exit\n\t\tEnter Choice (1/2/3): ");
            int choice = input.nextInt();
            switch(choice)
            {
                case 1:
                    s = new triangle();  //dynamic binding of reference of other class to other subclass
                    s.takeDimensions();  //calling abstract/overridden method using inherited/subclass
                    System.out.print("\n-------------------------------------------------------\n Area of Triangle with base "+triangle.p2+" and height "+triangle.p1+" is : "+s.compute_area()+"\n-------------------------------------------------------");
                    continue;
                
                case 2:
                    s = new rectangle();  //dynamic binding of reference of other class to other subclass
                    s.takeDimensions();  //calling abstract/overridden method using inherited/subclass
                    System.out.print("\n------------------------------------------------------------\n Area of rectangle with length "+rectangle.p1+" and breadth "+rectangle.p2+" is : "+s.compute_area()+"\n------------------------------------------------------------");
                    continue;
                
                case 3:
                    System.out.print("\n\t-----Program Terminated-----");
                    stop = 'y';
                    break;

                default :
                    System.out.print("\nInvalid Choice !");
            }
        }
    }
}
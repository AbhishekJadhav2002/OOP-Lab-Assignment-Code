/*
============================================================================
 Name : CarFactory.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 9
============================================================================
*/

import java.util.Scanner;
import CarPackage.*;

public class CarFactory
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        Cars buildCar = new Cars();  // creating object of parent class Cars(), its' method can build the objects of base classes 
        String trigger = null;  // String which will storing trigger from user just for continuing the while loops
        while(true)
        {
            System.out.print("\nChoose Car Type -\t1.Small\t\t2.Sedan\t\t3.Luxury\t4.Exit\n\t\t\t\t\tEnter Choice : ");
            int choice = input.nextInt();
            switch(choice)
            {
                case 1:
                    buildCar.setCarType(CarTypeEnum.Small);  // setCarType method creates object of class Small() and then calls its methods
                    buildCar.myCar.KeySpecification();  // object of Small() class is stored in myCar variable of Cars() which used to call child class methods
                    System.out.print("\nPress any key to start Assembling of the "+Cars.model+" car : ");
                    trigger = input.next();
                    while(trigger.isEmpty())  //continues until user press any key for next step to execute
                    {
                        System.out.print("\nEnter any key from keyboard to start assembling the "+Cars.model+" car : ");
                        trigger = input.next();
                    }
                    if(!trigger.isEmpty()) {buildCar.myCar.Assemble(); trigger = null;}  // if triggered is entered then only next methods can perform actions
                    System.out.print("\nPress any key to start exterior Designing of the "+Cars.model+" car : ");
                    trigger = input.next();
                    while(trigger.isEmpty())  //continues until user press any key for next step to execute
                    {
                        System.out.print("\nEnter any key from keyboard to start designing the "+Cars.model+" car : ");
                        trigger = input.next();
                    }
                    if(!trigger.isEmpty()) {buildCar.myCar.Design(); trigger = null;}  // if triggered is entered then only next methods can perform actions
                    break;

                case 2:
                    buildCar.setCarType(CarTypeEnum.Sedan);  // setCarType method creates object of class Sedan() and then calls its methods
                    buildCar.myCar.KeySpecification();  // object of Sedan() class is stored in myCar variable of Cars() which used to call child class methods
                    System.out.print("\nPress any key to start Assembling of the "+Cars.model+" car : ");
                    trigger = input.next();
                    while(trigger.isEmpty())  //continues until user press any key for next step to execute
                    {
                        System.out.print("\nEnter any key from keyboard to start assembling the "+Cars.model+" car : ");
                        trigger = input.next();
                    }
                    if(!trigger.isEmpty()) {buildCar.myCar.Assemble(); trigger = null;}  // if triggered is entered then only next methods can perform actions
                    System.out.print("\nPress any key to start exterior Designing of the "+Cars.model+" car : ");
                    trigger = input.next();
                    while(trigger.isEmpty())  //continues until user press any key for next step to execute
                    {
                        System.out.print("\nEnter any key from keyboard to start designing the "+Cars.model+" car : ");
                        trigger = input.next();
                    }
                    if(!trigger.isEmpty()) {buildCar.myCar.Design(); trigger = null;}  // if triggered is entered then only next methods can perform actions
                    break;

                case 3:
                    buildCar.setCarType(CarTypeEnum.Luxury);  // setCarType method creates object of class Luxury() and then calls its methods
                    buildCar.myCar.KeySpecification();  // object of Luxury() class is stored in myCar variable of Cars() which used to call child class methods
                    System.out.print("\nPress any key to start Assembling of the "+Cars.model+" car : ");
                    trigger = input.next();
                    while(trigger.isEmpty())  //continues until user press any key for next step to execute
                    {
                        System.out.print("\nEnter any key from keyboard to start assembling the "+Cars.model+" car : ");
                        trigger = input.next();
                    }
                    if(!trigger.isEmpty()) {buildCar.myCar.Assemble(); trigger = null;}  // if triggered is entered then only next methods can perform actions
                    System.out.print("\nPress any key to start exterior Designing of the "+Cars.model+" car : ");
                    trigger = input.next();
                    while(trigger.isEmpty())  //continues until user press any key for next step to execute
                    {
                        System.out.print("\nEnter any key from keyboard to start designing the "+Cars.model+" car : ");
                        trigger = input.next();
                    }
                    if(!trigger.isEmpty()) {buildCar.myCar.Design(); trigger = null;}  // if triggered is entered then only next methods can perform actions
                    break;

                case 4:
                    input.close();
                    return;
            }
        }
    }
}
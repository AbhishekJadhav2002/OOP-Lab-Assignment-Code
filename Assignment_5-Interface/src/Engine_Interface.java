import java.util.Scanner;
 /**<p>{@code functionality} is the custom interface containing some important functionalities.<p>This methods are implemented ahead in any vehicle,<ul><li><b>Classes</b><ul><li><i>{@link Car}</i><li><i>{@link Bikes}</i><li><i>{@link Cycle}</i></ul></ul>
 */
/* ^^^^ This type are commenting is for getting info at any particular instance of that specific word in the programme by hovering the cursor over that word.*/
interface functionality
{
    void setGear(int g);
    void increaseSpeed(int speed);
    Boolean brakes();
    void decreaseGear(int g);
    void decreaseSpeed(int speed);
    void displayState();
}

class Car implements functionality
{
    public int gear = 0;  //data members to be manipulated
    public int speed = 0;
    public Boolean brakes = true;

    public void setGear(int g)  //sets gear of user's choice
    {
        if (gear >= 0 && gear <= 5)
        {
            if (g == 0)
            {
                gear = g;
                System.out.print("\nGear set to Neutral");
                return;
            }
            else if(g >= 1 | g < 5)
            {
                gear = g;
                System.out.print("\nGear set to "+gear);
                return;
            }
            else if(g == 5)
            {
                gear = g;
                System.out.print("\nGear is reversed, Car reversing");
                return;
            }
            else
            {
                System.out.print("\n!!! Gear can't be set above 5th or below 0(neutral) !!!\n");
                return;
            }
        }
        else
        {
            System.out.print("\n!!! Invalid Gear Change Request ! because gear is on "+gear+" !!!\n");
            return;
        }
    }

    public void increaseSpeed(int s)  //increases speed by user's choice
    {
        if(brakes == true)
        {
            System.out.print("\n!!! Brakes are pressed, Release them to speed up !!!\n");
            return;
        }
        else
        {
            if (s >= 0 && s <= 20)
            {
                if((speed + s) > 120)
                {
                    System.out.print("\n!!! Maximum speed reached, can't be increased above 120 !!!\n");
                    return;
                }
                speed += s;
            }
            else
            {
                System.out.print("\n!!! Acceleration cannot be greater than 20 at once !!!\n");
                return;
            }
        }
    }

    public void decreaseSpeed()  //method used to decrease current speed by default by 10 
    {
        if(speed >= 10)
        {
            speed -= 10;
            return;
        }
        else
        {
            speed = 0;
            System.out.print("\nSpeed is 0, Car stopped !\n");
            return;
        }
    }

    public void decreaseSpeed(int s)  //overloaded method used to decrease current speed by s 
    {
        if(speed >= 0)
        {
            if(speed < s)
            {
                System.out.print("\n!!! Speed can't be less than 0, current speed is "+speed+" !!!\n");
                return;
            }
            speed -= s;
            return;
        }
        else
        {
            if(brakes == true)
            {
                System.out.print("\nBrakes pressed, Car stopped !\n");
                return;
            }
            System.out.print("\nSpeed is 0, Car stopped !\n");
            return;
        }
    }

    public void decreaseGear(int g)  //decreases gear upto user's choice
    {
        if(gear == 0)
        {
            System.out.print("\n!!! Cannot decrease gear, Gear is at neutral state !!!\n");
            return;
        }
        else if(g > gear)
        {
            System.out.print("\n!!! Invalid gear change request ! (Change of gear > Current Gear) !!!\n");
            return;
        }
        else if(gear > 0 && gear <= 4)
        {
            gear -= g;
            decreaseSpeed();
            System.out.print("\nGear decreased by "+g+", also speed has been decreased by 10\n");
            return;
        }
    }

    public Boolean brakes() //toggles between brakes value i.e. pressed and released
    {
        if(brakes == true)
        {
            brakes = false;
            System.out.print("\nBrakes released\n");
            return brakes;
        }
        else
        {
            brakes = true;
            decreaseSpeed(speed);
            setGear(0);
            System.out.print("\nBrakes pressed, Car stopped !\n");
            return brakes;
        }
    }

    public void displayState()  //display function as a dashboard
    {
        System.out.print("\n\n---------------------- Dashboard ----------------------\n\tSpeed\t\tGear\t\tBrakes\n\t"+speed+" km/h");
        if (gear == 0)
        {
            System.out.print("\t\tNeutral");
        }
        else if(gear == 5)
        {
            System.out.print("\t\tReversing");
        }
        else
        {
            System.out.print("\t\t"+gear);
        }
        if(brakes == true)
        {
            System.out.print("\t\tPressed\n-------------------------------------------------------\n");
        }
        else
        {
            System.out.print("\t\treleased\n------------------------------------------------------\n");
        }
    }
}


class Bikes implements functionality
{
    public int gear = 0;
    public int speed = 0;
    public Boolean brakes = true;

    public void setGear(int g)
    {
        if (gear >= 0 && gear <= 4)
        {
            if (g == 0)
            {
                gear = g;
                System.out.print("\nGear set to Neutral");
                return;
            }
            else if(g >= 1 | g < 4)
            {
                gear = g;
                System.out.print("\nGear set to "+gear);
                return;
            }
            else
            {
                System.out.print("\n!!! Gear can't be set above 4th or below 0(neutral) !!!\n");
                return;
            }
        }
        else
        {
            System.out.print("\n!!! Invalid Gear Change Request ! because gear is on "+gear+" !!!\n");
            return;
        }
    }

    public void increaseSpeed(int s)
    {
        if(brakes == true)
        {
            System.out.print("\n!!! Brakes are pressed, Release them to speed up !!!\n");
            return;
        }
        else
        {
            if (s >= 0 && s <= 20)
            {
                if((speed + s) > 80)
                {
                    System.out.print("\n!!! Maximum speed reached, can't be increased above 80 !!!\n");
                    return;
                }
                speed += s;
            }
            else
            {
                System.out.print("\n!!! Acceleration cannot be greater than 20 at once !!!\n");
                return;
            }
        }
    }

    public void decreaseSpeed()  //method used to decrease current speed by default by 10 
    {
        if(speed >= 10)
        {
            speed -= 10;
            return;
        }
        else
        {
            speed = 0;
            System.out.print("\nSpeed is 0, Bike stopped !\n");
            return;
        }
    }

    public void decreaseSpeed(int s)  //overloaded method used to decrease current speed by s 
    {
        if(speed >= 0)
        {
            if(speed < s)
            {
                System.out.print("\n!!! Speed can't be less than 0, current speed is "+speed+" !!!\n");
                return;
            }
            speed -= s;
            return;
        }
        else
        {
            if(brakes == true)
            {
                System.out.print("\nBrakes pressed, Bike stopped !\n");
                return;
            }
            System.out.print("\nSpeed is 0, Bike stopped !\n");
            return;
        }
    }

    public void decreaseGear(int g)
    {
        if(gear == 0)
        {
            System.out.print("\n!!! Cannot decrease gear, Gear is at neutral state !!!\n");
            return;
        }
        else if(g > gear)
        {
            System.out.print("\n!!! Invalid gear change request ! (Change of gear > Current Gear) !!!\n");
            return;
        }
        else if(gear > 0 && gear <= 4)
        {
            gear -= g;
            decreaseSpeed();
            System.out.print("\nGear decreased by "+g+", also speed has been decreased by 10\n");
            return;
        }
    }

    public Boolean brakes()
    {
        if(brakes == true)
        {
            brakes = false;
            System.out.print("\nBrakes released\n");
            return brakes;
        }
        else
        {
            brakes = true;
            decreaseSpeed(speed);
            setGear(0);
            System.out.print("\nBrakes pressed, Bike stopped !\n");
            return brakes;
        }
    }

    public void displayState()
    {
        System.out.print("\n\n---------------------- Dashboard ----------------------\n\tSpeed\t\tGear\t\tBrakes\n\t"+speed+" km/h");
        if (gear == 0)
        {
            System.out.print("\t\tNeutral");
        }
        else
        {
            System.out.print("\t\t"+gear);
        }
        if(brakes == true)
        {
            System.out.print("\t\tPressed\n-------------------------------------------------------\n");
        }
        else
        {
            System.out.print("\t\tReleased\n------------------------------------------------------\n");
        }
    }
}


class Cycle implements functionality
{
    public int frontgear = 1;
    public int backgear = 1;
    public int speed = 0;
    public Boolean brakes = true;

    public void setGear(int g)
    {
        if (backgear >= 1 && backgear <= 7)
        {
            if(g >= 1 | g < 4)
            {
                backgear = g;
                System.out.print("\nBackgear set to "+backgear);
            }
            else
            {
                System.out.print("\n!!! Backgear can't be set above 7th or below 1st !!!\n");
                return;
            }
        }
        else
        {
            System.out.print("\n!!! Invalid Gear Change Request ! because backgear is on "+backgear+" !!!\n");
            return;
        }
    }

    public void setGear(int g, int f)
    {
        setGear(g);
        if (frontgear >= 1 && frontgear <= 3)
        {
            if(f >= 1 | f < 4)
            {
                frontgear = g;
                System.out.print("\nFrontgear set to "+frontgear);
                return;
            }
            else
            {
                System.out.print("\n!!! Frontgear can't be set above 3rd or below 1st !!!\n");
                return;
            }
        }
        else
        {
            System.out.print("\n!!! Invalid Gear Change Request ! because frontgear is on "+frontgear+" !!!\n");
            return;
        }
    }

    public void increaseSpeed(int s)
    {
        if(brakes == true)
        {
            System.out.print("\n!!! Brakes are pressed, Release them to speed up !!!\n");
            return;
        }
        else
        {
            if (s >= 0 && s <= 20)
            {
                if((speed + s) > 50)
                {
                    System.out.print("\n!!! Maximum speed reached, can't be increased above 50 !!!\n");
                    return;
                }
                speed += s;
            }
            else
            {
                System.out.print("\n!!! Acceleration cannot be greater than 20 at once !!!\n");
                return;
            }
        }
    }

    public void decreaseSpeed()  //method used to decrease current speed by default by 5
    {
        if(speed >= 5)
        {
            speed -= 5;
            return;
        }
        else
        {
            speed = 0;
            System.out.print("\nSpeed is 0, Cycle stopped !\n");
            return;
        }
    }

    public void decreaseSpeed(int s)  //overloaded method used to decrease current speed by s 
    {
        if(brakes == true)
        {
            System.out.print("\n!!! Brakes pressed, speed is already 0 !!!\n");
            return;
        }
        else if(speed > 0)
        {
            if(speed < s)
            {
                System.out.print("\n!!! Reduced speed can't be less than 0, current speed is "+speed+" !!!\n");
                return;
            }
            speed -= s;
            return;
        }
        else
        {
            System.out.print("\n!!! Speed can't be reduced by less than 1 km/h !!!\n");
            return;
        }
    }

    public void decreaseGear(int b)
    {
        if(backgear == 1)
        {
            System.out.print("\n!!! Cannot decrease gear, Backgear is on 1st gear !!!\n");
            return;
        }
        else if(b > backgear)
        {
            System.out.print("\n!!! Invalid gear change request ! (Change of gear > Current backgear) !!!\n");
            return;
        }
        else if(backgear > 1 && backgear <= 7)
        {
            backgear -= b;
            decreaseSpeed();
            System.out.print("\nBackgear decreased by "+b+", also speed has been decreased by 5\n");
            return;
        }
    }

    public void decreaseGear(int b, int f)
    {
        decreaseGear(b);
        if(frontgear == 1)
        {
            System.out.print("\n!!! Cannot decrease gear, Frontgear is on 1st gear !!!\n");
            return;
        }
        else if(f > frontgear)
        {
            System.out.print("\n!!! Invalid gear change request ! (Change of gear > Current frontgear) !!!\n");
            return;
        }
        else if(frontgear > 1 && frontgear <= 3)
        {
            frontgear -= f;
            decreaseSpeed();
            System.out.print("\nFrontgear decreased by "+f+", also speed has been decreased by 5\n");
            return;
        }
    }

    public Boolean brakes()
    {
        if(brakes == true)
        {
            brakes = false;
            System.out.print("\nBrakes released\n");
            return brakes;
        }
        else
        {
            brakes = true;
            decreaseSpeed(speed);
            setGear(1, 1);
            System.out.print("\nBrakes pressed, Cycle stopped !\n");
            return brakes;
        }
    }

    public void displayState()
    {
        System.out.print("\n\n------------------------ Dashboard -------------------------\n\tSpeed\t\t    Gear\t\tBrakes\n\t\t\tFront\tBack\n\t"+speed+" km/h");
            System.out.print("\t\t "+frontgear+"\t "+backgear);
        if(brakes == true)
        {
            System.out.print("\t\tPressed\n------------------------------------------------------------\n");
        }
        else
        {
            System.out.print("\t\tReleased\n-----------------------------------------------------------\n");
        }
    }
}


public class Engine_Interface
{
    public static void main (String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoose Vehicle -\n\t1. Car\t\t2. Bike\t\t3. Cycle\n\t\tEnter Choice : ");
        int vehicle = input.nextInt();
        int action;
        // functionalities Vehicle;
        switch(vehicle)  //switching between vehicles from this switch
        {
            case 1:
                Car Honda = new Car();  //creating object of type Car when user select vehicle car
                Boolean Driving = true;
                System.out.print("\n\t--------- Entered into Car ---------\n\t    Drive Safely, Happy Journey");
                Honda.displayState();
                while(Driving == true)
                {
                    System.out.print("\n\n1.Speed Up\t2. Set Gear\t3. Decrease Speed\t4. Brakes\t5. Turn Off Car\n\t\t\t\tSelect Action : ");
                    action = input.nextInt();
                    switch(action)  //inside car vehicle and perform different actions of car using this switch
                    {
                        case 1:
                            System.out.print("\n Speed up by (<=120): ");
                            int s = input.nextInt();
                            Honda.increaseSpeed(s);
                            Honda.displayState();
                            continue;
                        
                        case 2:
                            System.out.print("\n Set gear to ( 0-Neutral / 5-Reverse / 1,2,3,4-Running ) : ");
                            int g = input.nextInt();
                            Honda.setGear(g);
                            Honda.displayState();
                            continue;

                        case 3:
                            System.out.print("\n Decrease speed up by (<="+Honda.speed+"): ");
                            int d = input.nextInt();
                            Honda.decreaseSpeed(d);
                            Honda.displayState();
                            continue;

                        case 4:
                            if(Honda.brakes == true)
                            {
                                System.out.print("\nBrakes are pressed, Enter '1' to release brakes : ");
                                int release = input.nextInt();
                                if(release == 1)
                                {
                                    Honda.brakes();
                                    Honda.displayState();
                                    continue;
                                }
                                else
                                {
                                    Honda.displayState();
                                    continue;
                                }
                            }
                            else
                            {
                                System.out.print("\nBrakes are released, Enter '1' to press brakes : ");
                                int press = input.nextInt();
                                if(press == 1)
                                {
                                    Honda.brakes();
                                    Honda.displayState();
                                    continue;
                                }
                                else
                                {
                                    Honda.displayState();
                                    continue;
                                }
                            }

                        case 5:
                            System.out.print("\n\t------------ Thank You ! ------------\n\t\tTurning off the car\n");
                            Driving = false;
                    }
                }

            case 2:
                Bikes Bike = new Bikes();
                Boolean Driving2 = true;
                System.out.print("\n\t--------- Started the Bike ---------\n\t    Drive Safely, Happy Journey");
                Bike.displayState();
                while(Driving2 == true)
                {
                    System.out.print("\n\n1.Speed Up\t2. Set Gear\t3. Decrease Speed\t4. Brakes\t5. Turn Off Bike\n\t\t\t\tSelect Action : ");
                    action = input.nextInt();
                    switch(action)  //inside bike vehicle and perform different actions of car using this switch
                    {
                        case 1:
                            System.out.print("\n Speed up by (<=80): ");
                            int s = input.nextInt();
                            Bike.increaseSpeed(s);
                            Bike.displayState();
                            continue;
                        
                        case 2:
                            System.out.print("\n Set gear to ( 0-Neutral / 1,2,3,4-Running ) : ");
                            int g = input.nextInt();
                            Bike.setGear(g);
                            Bike.displayState();
                            continue;

                        case 3:
                            System.out.print("\n Decrease speed up by (<="+Bike.speed+"): ");
                            int d = input.nextInt();
                            Bike.decreaseSpeed(d);
                            Bike.displayState();
                            continue;

                        case 4:
                            if(Bike.brakes == true)
                            {
                                System.out.print("\nBrakes are pressed, Enter '1' to release brakes : ");
                                int release = input.nextInt();
                                if(release == 1)
                                {
                                    Bike.brakes();
                                    Bike.displayState();
                                    continue;
                                }
                                else
                                {
                                    Bike.displayState();
                                    continue;
                                }
                            }
                            else
                            {
                                System.out.print("\nBrakes are released, Enter '1' to press brakes : ");
                                int press = input.nextInt();
                                if(press == 1)
                                {
                                    Bike.brakes();
                                    Bike.displayState();
                                    continue;
                                }
                                else
                                {
                                    Bike.displayState();
                                    continue;
                                }
                            }

                        case 5:
                            System.out.print("\n\t------------ Thank You ! ------------\n\t\tTurning off the bike\n");
                            Driving2 = false;
                    }
                }

            case 3:
                Cycle Racer = new Cycle();
                Boolean Driving3 = true;
                System.out.print("\n\t--------- Started Cycling ---------\n\t     Drive Safely, Happy Journey");
                Racer.displayState();
                while(Driving3 == true)
                {
                    System.out.print("\n\n1.Speed Up\t2. Set Gear\t3. Decrease Speed\t4. Brakes\t5. Stand By Cycle\n\t\t\t\tSelect Action : ");
                    action = input.nextInt();
                    switch(action)  //inside cycle vehicle and perform different actions of cycle using this switch
                    {
                        case 1:
                            System.out.print("\n Speed up by (<=80): ");
                            int s = input.nextInt();
                            Racer.increaseSpeed(s);
                            Racer.displayState();
                            continue;

                        case 2:
                            System.out.print("\n Change -\t1. Both Gears\t2. Back Gear\n\t\tSelect Change : ");
                            int select_gearType = input.nextInt();
                            switch(select_gearType)
                            {
                                case 1:
                                    System.out.print("\n Set Backgear to (1 to 7) : ");
                                    int b = input.nextInt();
                                    System.out.print("\n Set Frontgear to (1 to 3) : ");
                                    int f = input.nextInt();
                                    Racer.setGear(b, f);
                                    Racer.displayState();
                                    continue;

                                case 2:
                                    System.out.print("\n Set Backgear to (1 to 7) : ");
                                    int b1 = input.nextInt();
                                    Racer.setGear(b1);
                                    Racer.displayState();
                                    continue;
                            }

                        case 3:
                            System.out.print("\n Decrease speed up by (<="+Racer.speed+"): ");
                            int d = input.nextInt();
                            Racer.decreaseSpeed(d);
                            Racer.displayState();
                            continue;

                        case 4:
                            if(Racer.brakes == true)
                            {
                                System.out.print("\nBrakes are pressed, Enter '1' to release brakes : ");
                                int release = input.nextInt();
                                if(release == 1)
                                {
                                    Racer.brakes();
                                    Racer.displayState();
                                    continue;
                                }
                                else
                                {
                                    Racer.displayState();
                                    continue;
                                }
                            }
                            else
                            {
                                System.out.print("\nBrakes are released, Enter '1' to press brakes : ");
                                int press = input.nextInt();
                                if(press == 1)
                                {
                                    Racer.brakes();
                                    Racer.displayState();
                                    continue;
                                }
                                else
                                {
                                    Racer.displayState();
                                    continue;
                                }
                            }

                        case 5:
                            System.out.print("\n\t------------ Thank You ! ------------\n\t\tParking cycle aside\n");
                            Driving3 = false;
                    }
                }
        }
    }
};
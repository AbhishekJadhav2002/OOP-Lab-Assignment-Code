package CarPackage;
public class Small extends Cars
{
    @Override
        public void KeySpecification()
        {
            System.out.print("\n------------------------------------------ | KEY SPECS OF SMALL CAR | ------------------------------------------\n"+model+" car type has key features like,\n\t\t\t\tMileage - 23.76 km/l\tEngine Displacement(cc) - 1197\tNo. of cylinder - 4\n\t\t\t\tMax Power(bhp@rpm) - 88.50bhp@6000rpm\tMax Torque(nm@rpm) - 113Nm@4400rpm\n\t\t\t\tSeating Capacity - 5\tTransmission Type - Automatic\tBoot Space(Litres) - 268\n\t\t\t\tFuel Tank Capacity - 37.0\tService Cost(Avg. of 5 years) - Rs.4,703\n----------------------------------------------------------------------------------------------------------------\n");
        }

        public void Assemble()
        {
            System.out.print("\n------------------------------------------- | ASSEMBLING SMALL CAR | -------------------------------------------\n\t\t\t....Assembling all the components to the '"+model+"' car....\n----------------------------------------------------------------------------------------------------------------\n");
        }

        public void Design()
        {
            System.out.print("\n------------------------------------------- | DESIGNING SMALL CAR | --------------------------------------------\n\t\t\t   "+model+" car type comes with the Body Type of Hatchback\n\t\t\t\t  ....Designing the outer framework....\n----------------------------------------------------------------------------------------------------------------\n");
        }
}
package CarPackage;

public class Luxury extends Cars
{
    @Override
        public void KeySpecification()
        {
            System.out.print("\n----------------------------------------- | KEY SPECS OF LUXURY CAR | ----------------------------------------\n"+model+" car type has key features like,\n\t\t\t\tMileage - 15.8 km/l\tFuel Type - Petrol\tEngine Displacement(cc) - 1997\n\t\t\t\tNo. of cylinder - 4\tMax Power(bhp@rpm) - 246.74bhp@5500rpm\n\t\t\t\tMax Torque(nm@rpm) - 365nm@1500-4000rpm \tSeating Capacity - 5\n\t\t\t\tTransmission Type - Automatic\tBoot Space(Litres) - 748\n\t\t\t\tFuel Tank Capacity - 82.0\tBody Type - SUV\n--------------------------------------------------------------------------------------------------------------\n");
        }

        public void Assemble()
        {
            System.out.print("\n----------------------------------------- | ASSEMBLING LUXURY CAR | ------------------------------------------\n\t\t\t....Assembling all the components to the '"+model+"' car....\n--------------------------------------------------------------------------------------------------------------\n");
        }

        public void Design()
        {
            System.out.print("\n------------------------------------------ | DESIGNING LUXURY CAR | ------------------------------------------\n\t\t\t"+model+" car type comes with the Body Type of 'crossover SUV'\n\t\t\t\t  ....Designing the outer framework....\n--------------------------------------------------------------------------------------------------------------\n");
        }
}
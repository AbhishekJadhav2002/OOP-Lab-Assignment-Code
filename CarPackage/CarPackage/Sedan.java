package CarPackage;

public class Sedan extends Cars
{
    @Override
        public void KeySpecification()
        {
            System.out.print("\n--------------------------------------------- | KEY SPECS OF SEDAN CAR | ----------------------------------------------\n"+model+" car type has key features like,\n\t\t\t\tMileage - 12.0 km/l\tFuel Type - Diesel\tEngine Displacement(cc) - 2393\n\t\t\t\tNo. of cylinder - 4\tMax Power(bhp@rpm) - 148bhp@3400rpm\n\t\t\t\tMax Torque(nm@rpm) - 360Nm@1400-2600rpm \tSeating Capacity - 7, 8\n\t\t\t\tTransmission Type - Automatic\tBoot Space(Litres) - 300\tFuel Tank Capacity - 55\n-----------------------------------------------------------------------------------------------------------------------\n");
        }
        
        public void Assemble()
        {
            System.out.print("\n----------------------------------------------- | ASSEMBLING SEDAN CAR | ----------------------------------------------\n\t\t\t\t....Assembling all the components to the '"+model+"' car....\n-----------------------------------------------------------------------------------------------------------------------\n");
        }

        public void Design()
        {
            System.out.print("\n----------------------------------------------- | DESIGNING SEDAN CAR | -----------------------------------------------\n\t\t\t\t   "+model+" car type comes with the Body Type of MUV\n\t\t\t\t\t  ....Designing the outer framework....\n-----------------------------------------------------------------------------------------------------------------------\n");
        }
}
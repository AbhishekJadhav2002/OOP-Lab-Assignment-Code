package CarPackage;
/**This class is consist of just a method {@linkplain  CarPackage.CarObjectFactory#BuildCar(CarTypeEnum) BuildCar(CarTypeEnum)} intended for making object of classes ({@link Small}, {@link Sedan}, {@link Luxury}) and returning them*/
public class CarObjectFactory
{
    /**This method have the return type {@code Cars} because it returns objects of referring to the base class {@link Cars}. It takes 
     * @param CarName - {@link CarTypeEnum} string is given which decides which car type object to be returned using switch cases.
     * @return {@code Small()/Sedan()/Luxury()} - objects of ({@link Small}, {@link Sedan}, {@link Luxury}) classes referred from parent class {@link Cars}, otherwise {@code null} - if other than {@link CarTypeEnum} string is passed to it.
     */
    protected Cars BuildCar(CarTypeEnum CarName)
    {
        switch(CarName)
        {
            case Small:
                System.out.print("\n-----------------------------------------------------------------------------\nCar type sanctioned is of \"Small\" category, returning object of car Small()\n-----------------------------------------------------------------------------\n");
                return new Small();
    
            case Sedan:
                System.out.print("\n---------------------------------------------------------------------------\nCar type sanctioned is of \"Sedan\" category, returning object of car Sedan()\n---------------------------------------------------------------------------\n");
                return new Sedan();

            case Luxury:
                System.out.print("\n-------------------------------------------------------------------------------\nCar type sanctioned is of \"Luxury\" category, returning object of car Luxury()\n-------------------------------------------------------------------------------\n");
                return new Luxury();

            default:
                System.out.print("\n---------------------- !! ----------------------\nCar type provided is empty returning null object\n------------------------------------------------\n");
                return null;
        }
    }
}
package CarPackage;

/**This classes implements {@link CarInterface} interface. 
 * <p>{@code Data Members} - {@linkplain CarPackage.Cars#model model}, {@linkplain CarPackage.Cars#myCar myCar}, {@linkplain CarPackage.Cars#car_object car_object}</p>
 * It overrides <ul><li>{@linkplain CarPackage.CarInterface#KeySpecification() KeySpecification()}</li><li>{@linkplain CarPackage.CarInterface#Assemble() Assemble()}</li><li>{@linkplain CarPackage.CarInterface#Design() Design()}</li></ul><break>This class is extended in classes -
 * @see {@link Small}
 * @see {@link Sedan}
 * @see {@link Luxury}*/
public class Cars implements CarInterface
{
    public static CarTypeEnum model;
    /**This {@code public} member of class {@link Cars}, is of the type {@code Cars} stores object of base classes like {@link Small}, {@link Sedan}, {@link Luxury} generated from method<pre>{@link CarObjectFactory#BuildCar(CarTypeEnum)}</pre> which is called in the method {@linkplain CarPackage.Cars#setCarType(CarTypeEnum) setCarType(CarTypeEnum)}*/
    public Cars myCar;
    /**This {@code protected} member of class {@link Cars}, is of the type {@link CarObjectFactory}. This object is used to access method <pre>{@link CarObjectFactory#BuildCar()}</pre> which return object of derived classes ({@link Small}, {@link Sedan}, {@link Luxury}) and then stored in {@link Cars#myCar}*/
    protected CarObjectFactory car_object = new CarObjectFactory();

    /**This method is intended to be called in {@link main} and not intended to be overridden in derived classes.
     * @param c - It is of the type {@link CarTypeEnum}. Used to specify which {@code Cars}'s child class object to be stored in {@link Cars#myCar}.
     */
    public void setCarType(CarTypeEnum c)
    {
        model = c;
        this.myCar = car_object.BuildCar(model);
    }
    /**This method of {@link Cars} displays many key specifications of car to the user. It is further overridden specifically in child classes where it'll displays respective specifications of that car type.
     * @see Small#KeySpecification()
     * @see Sedan#KeySpecification()
     * @see Luxury#KeySpecification()*/
    public void KeySpecification(){};
    
    /**This method of {@link Cars} displays notice about assembling components of particular car type, to the user. It is further overridden specifically in child classes where it'll displays respective message for that car type.
     * @see Small#Assemble()
     * @see Sedan#Assemble()
     * @see Luxury#Assemble()*/
    public void Assemble(){};

    /**This method of {@link Cars} displays notice about designing outer framework of car to the user. It is further overridden specifically in child classes where it'll displays respective message for that car type.
     * @see Small#Design()
     * @see Sedan#Design()
     * @see Luxury#Design()*/
    public void Design(){};
}
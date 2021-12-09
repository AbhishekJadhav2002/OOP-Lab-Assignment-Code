package CarPackage;
/**
 * {@link CarInterface} consist of declaration of abstract methods which are overridden in the class {@link Cars} and further its child classes. It declares abstract methods like - <br><ul><li>{@link Cars#KeySpecification()}</li><li>{@link Cars#Design()}</li><li>{@link Cars#Assemble()}</li>
 */
public abstract interface CarInterface
{
    public
        abstract void KeySpecification();
        abstract void Design();
        abstract void Assemble();
}
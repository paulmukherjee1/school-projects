import java.io.Serializable;

/**
 * 	 @author Paul Mukherjee
 *       @version 1.0 
 *       ITEC 3150 September 26th 2021
 *	 Abstract parent class for dog and cat
 * 
 * 
 *
 */
public abstract class Pet implements Serializable
{

    // common pet attributes
    protected String name;
    protected int yearOfBirth;
    protected boolean isDog;

    /**
     * Only constructor must include all arguments in this order
     * 
     * @param name
     * @param yearOfBirth
     * @param isDog
     */
    public Pet(String name, int yearOfBirth, boolean isDog)
    {

        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.isDog = isDog;
    }

    /**
     * toString for Pet class only
     */
    @Override
    public String toString()
    {
        return "Pet [name=" + name + ", yearOfBirth=" + yearOfBirth + ", isDog=" + isDog + "]";
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the yearOfBirth
     */
    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /**
     * @return the isDog
     */
    public boolean isDog()
    {
        return isDog;
    }

}

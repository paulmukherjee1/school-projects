import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 	 @author Paul Mukherjee
 *       @version 1.0 
 *       ITEC 3150 September 26th 2021
 *	 Used to generate pet file
 * 
 * 
 *
 */
public class GeneratePetFile
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // create 10 dogs and cats
        ArrayList<Pet> pets = new ArrayList<Pet>();

        // create 5 dogs
        Dog d = new Dog("Spot", 2020, true, "dalmation", 86);
        pets.add(d);
        d = new Dog("Charlie", 2015, true, "spaniel", 5);
        pets.add(d);
        d = new Dog("Fritz", 2016, true, "dachshound", 7);
        pets.add(d);
        d = new Dog("Schultz", 2010, true, "German Shepherd", 60);
        pets.add(d);
        d = new Dog("Scottie", 2019, true, "Golden Lab", 50);
        pets.add(d);
        d = new Dog("Fluffy", 2013, true, "Chocolate Lab", 55);
        pets.add(d);
        d = new Dog("Max", 2017, true, "Husky", 40);
        pets.add(d);
        d = new Dog("Mollie", 2018, true, "Boxer", 30);
        pets.add(d);
        // now cats
        Cat c = new Cat("Petey", 2013, false, false, 17);
        pets.add(c);
        c = new Cat("Nico", 2013, false, false, 12);
        pets.add(c);
        c = new Cat("Fluffy", 2020, false, true, 6);
        pets.add(c);
        c = new Cat("Garfield", 1982, false, false, 29);
        pets.add(c);
        c = new Cat("Cat", 2011, false, true, 10);
        pets.add(c);
        c = new Cat("Minx", 2013, false, false, 11);
        pets.add(c);
        c = new Cat("Oreo", 2014, false, true, 12);
        pets.add(c);
        c = new Cat("Oliver", 2013, false, true, 13);
        pets.add(c);

        // Now write file using ObjectOutputStream
        try
        { // Create an output stream for file object.dat
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pets.dat"));

            for (Pet p : pets)
            {
                output.writeObject(p);
            }
            output.close();

        } catch (IOException ex)
        {
            ex.printStackTrace();
            System.out.println("Problem writing output file");
        }

    }

}

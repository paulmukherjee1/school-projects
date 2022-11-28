import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.ObservableList;

/**
 * Class: Library
 * 
 *       @author Paul Mukherjee
 *       @version 1.0 
 *       ITEC 3150 September 26th 2021
 * 
 * 
 *          This class describes the library used to contain the Pet
 *          library. 
 * 
 *          Purpose: Methods and attributes needed to create a library of
 *          Pet objects. 
 *
 */
public class PetLibrary
{

    private ArrayList<Pet> libraryItems = new ArrayList<Pet>();

    public ArrayList<Pet> getTheList()
    {
        return libraryItems;
    }
    
    /**
     * addItem()
     * 
     * This method adds the parameter m to the libraryItems array list
     * 
     * @param m
     * 
     */
    
    public void addItem(Pet m)
    {
        libraryItems.add(m);
    }
    
    /**
     * printLibraryItems()
     * 
     * This method prints items in librayItems to console
     */
    
    public void printLibraryItems()
    {
        //output to console
        for (int i = 0; i < libraryItems.size(); i++)
        {
            Pet temp = libraryItems.get(i);
            System.out.println(temp);
        }

    }

    /**
     * readBinaryFile()
     * 
     * This method populates the libraryItems array list from a binary files
     */
    
    public void readBinaryFile()
    {
        try
        { // Create an input stream for file pets.dat
            
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("pets.dat"));
            while (true)
            {
                Pet m = (Pet) input.readObject();
                addItem(m);
            }
        } catch (EOFException ex)
        {
            // do nothing reached the end of the file
            
        } catch (IOException i)
        {
            System.out.println("Unable to read from file");
            i.printStackTrace();
        } catch (ClassNotFoundException c)
        {
            System.out.println("Object read is not a java.util.Date instance");
        }

    }
       
        /**
     * writeListToFile()
     * 
     * This method overwites the original binary file (pets.dat) with new added objects
     * 
     * @param ObservableList<Pet>
     */
    
    public void writeListToFile(ObservableList<Pet> items)
    {
            try

            { // Create an input stream for file pets.dat
                
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pets.dat"));
            for (Pet p : items)
            {
                output.writeObject(p);

            }
            output.close();
        } catch (IOException i)
        {
            System.out.println("Unable to write to file");
            i.printStackTrace();
        }

    }
    

}



import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * Class: NewDogStage
 * 
 *       @author Paul Mukherjee
 *       @version 1.0 
 *       ITEC 3150 September 26th 2021
 * 
 * 
 *          This class is used to enter new info for new dog object
 * 
 *          Purpose: methods and attributes for adding new dog object
 *
 */
 
public class NewDogStage extends Stage
{
    // fields shared by methods
    
    private TextField name = new TextField();
    private TextField yearBirth = new TextField();
    private TextField weight = new TextField();
    private TextField breed = new TextField();
    private TextField isDog = new TextField();
    private ObservableList<Pet> obserPet;

    /**
     * Constructor that creates and makes Stage for Pet entry visible
     * 
     * @param list
     */
    public NewDogStage(ObservableList<Pet> list)
    {
        obserPet = list;
        // Create a pane and set its properties
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // add fields
        // Place nodes in the pane
        
        pane.add(new Label("Name:"), 0, 0);
        pane.add(name, 1, 0);
        pane.add(new Label("Year of Birth:"), 0, 1);
        pane.add(yearBirth, 1, 1);
       
        
        //add button to add new dog object
        
        Button btAdd = new Button("Add New Dog");
        pane.add(btAdd, 1, 4);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
        btAdd.setOnAction(e -> addDog());

        // Create a scene and place it in the stage
        
        Scene scene = new Scene(pane);
        this.setTitle("Add New Dog"); 
        this.setScene(scene); 
        this.show(); 
    }

    /**
     * Method:addDog()
     * 
     * This method reads the entries made by user in textfields and
     * converts to a Pet object.  This object is added to ObservableList 
     * in attributes.
     * 
     * 
     */
    public void addDog()
    {
        // get attributes from text field
        
        String nameField = name.getText();
        String yearBirthField = yearBirth.getText();
        String weightField = weight.getText();
        String breedField = breed.getText();
        String dog = isDog.getText();
        // create Pet object
        
        Pet p = new Dog(nameField, Integer.parseInt(yearBirthField),Boolean.parseBoolean(dog), breedField, Double.parseDouble(weightField));
        obserPet.add(p);

        // close stage
        
        this.close();
    }

}

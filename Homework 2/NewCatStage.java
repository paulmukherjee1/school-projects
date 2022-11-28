
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
 * Class: NewCatStage
 * 
 *       @author Paul Mukherjee
 *       @version 1.0 
 *       ITEC 3150 September 26th 2021
 * 
 * 
 *          This class is used to enter new info for new cat object
 * 
 *          Purpose: methods and attributes for adding new cat object
 *
 */
public class NewCatStage extends Stage
{
    // fields shared by methods
    private TextField name = new TextField();
    private TextField yearBirth = new TextField();
    private TextField weight = new TextField();
    private TextField longHair= new TextField();
    private TextField isDog = new TextField();
    private ObservableList<Pet> obserPet;

    /**
     * Constructor that creates and makes Stage for Pet entry visible
     * 
     * @param list
     */
    public NewCatStage(ObservableList<Pet> list)
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

        // add button to add net cat object
        
        Button btAdd = new Button("Add New Cat");
        pane.add(btAdd, 1, 4);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
        btAdd.setOnAction(e -> addCat());

        // Create a scene and place it in the stage
        
        Scene scene = new Scene(pane);
        this.setTitle("Add New Cat"); 
        this.setScene(scene); 
        this.show(); 
    }

    /**
     * Method:addCat()
     * 
     * This method reads the entries made by user in textfields and
     * converts to a Person object.  This object is added to ObservableList 
     * in attributes.
     * 
     * 
     */
    public void addCat()
    {
        // get attributes from text field
        
        String nameField = name.getText();
        String yearBirthField = yearBirth.getText();
        String weightField = weight.getText();
        String hairField = longHair.getText();
        String dog = isDog.getText();
        // create Pet object
        
        Pet p = new Cat(nameField, Integer.parseInt(yearBirthField),Boolean.parseBoolean(dog), Boolean.parseBoolean(hairField), Double.parseDouble(weightField));
        obserPet.add(p);

        // close stage
        
        this.close();
    }

}

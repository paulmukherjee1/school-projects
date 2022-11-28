import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class: Library
 * 
 *       @author Paul Mukherjee
 *       @version 1.0 
 *       ITEC 3150 September 26th 2021
 * 
 * 
 *          This class is used to create a GUI for viewing available pets, adding new 
 *          pets to the GUI, and updating the GUI with new added pets once closed.
 * 
 *          Purpose: Methods and attributes needed to create a GUI for Pet Objects
 *
 */
public class MainGUI extends Application
{
    private PetLibrary myLibrary = new PetLibrary();
    private ObservableList<Pet> items;

        /*
     * Method:start()
     * 
     * This method adds the parameter m to the libraryItems array list
     * 
     * @param Stage primaryStage
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // read in file and create library
        myLibrary.readBinaryFile();

        // display list of library items
        VBox mainPane = new VBox();
        Label mainLabel = new Label("Available Pets");

        mainPane.getChildren().add(mainLabel);
        ListView<Pet> list = new ListView<Pet>();
        items = FXCollections.observableArrayList(myLibrary.getTheList());
        list.setItems(items);

        mainPane.getChildren().add(list);

        // make list selectable and popup info on selected item in a separate
        // stage
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pet>()
        {

            public void changed(ObservableValue<? extends Pet> observable, Pet oldValue, Pet newValue)
            {
                // pop up detail stage of selected Pet object
                Stage newStage = null;
                newStage = createPetStage(newValue);

                newStage.show();
            }
        });

        Button newButton = new Button("New Dog");
        newButton.setOnAction(e -> getNewDog());
        mainPane.getChildren().add(newButton);
        
        Button newButton2 = new Button("New Cat");
        newButton2.setOnAction(e -> getNewCat());
        mainPane.getChildren().add(newButton2);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> writeAndClose());
        mainPane.getChildren().add(closeButton);

        // Create a scene and place it in the stage line
        Scene scene = new Scene(mainPane, 500, 200);
        primaryStage.setTitle("Pet Library"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 

    }

    /*
     * Method to create new Stage for details about a Pet object Called by
     * ListView selection handler
     * 
     * @param Media
     * 
     * @return Stage
     */
    private Stage createPetStage(Pet m)
    {
        Stage s = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        Pet b = (Pet) m;
        
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label(b.getName()), 1, 0);
        pane.add(new Label("Year Born:"), 0, 1);
        pane.add(new Label("" + b.getYearOfBirth()), 1, 1);
        
        

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        s.setScene(scene);
        s.setTitle("Pet");
        return s;
    }

    /**
     * Method: getNewPet
     * 
     * Called by event handler for new button Launches a new stage to enter dog
     * info
     * 
     *
     */
    public void getNewDog()
    {
        // code to launch dog form stage

        new NewDogStage(items);
    }
    /**
     * Method: getNewPet
     * 
     * Called by event handler for new button Launches a new stage to enter cat
     * info
     * 
     *
     */
    public void getNewCat()
    {
        // code to launch cat form stage

        new NewCatStage(items);
    }
    /*
     * Called by event handler for close button
     * 
     * Writes observable list to original binary file
     * 
     *
     */
    public void writeAndClose()
    {
        //code to write list

        myLibrary.writeListToFile(items);
        System.exit(0);
    }

    /**
     * Main method and starting point of the program
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);

    }

}

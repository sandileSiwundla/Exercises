package example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The guiWorld class handles the creation of the graphical user interface for the game world.
 */
public class guiWorld {

    /**
     * Creates the graphical user interface for the game world.
     *
     * @param worldWidth     the width of the game world
     * @param worldHeight    the height of the game world
     * @param gameWorldPane  the Pane to which the GUI elements will be added
     */


    public void createGui(double worldWidth,double worldHeight, Pane gameWorldPane){
        BorderPane pane = new BorderPane();
        pane.setMaxWidth(worldWidth);
        pane.setMaxHeight(worldHeight);

        // Load the background image
        Image backgroundImage = loadImage("example/f.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(worldWidth);
        backgroundView.setFitHeight(worldHeight);

        // Add the background and player to the game world Pane
        gameWorldPane.getChildren().addAll(backgroundView);
    }


    /**
     * Default constructor for guiWorld.
     */
    public guiWorld(){}

    private Image loadImage(String imagePath) {
        try {
            return new Image(new FileInputStream(imagePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

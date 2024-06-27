package example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Scanner;

public class Main extends Application {

    private ImageView avatarView;
    private int moving = 0;
    private int mover;
    private String direction;
    private int avatarTracker;
    private String userPrompt;



    @Override
    public void start(Stage primaryStage) {
        Pane gameWorldPane = new Pane();
        Scene scene = new Scene(gameWorldPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        gameWorldPane.setPrefSize(800, 600);


        guiWorld newGui = new guiWorld();
        newGui.createGui(1000, 800, gameWorldPane);


        avatarView = new ImageView();
        avatarView.setFitWidth(50);
        avatarView.setFitHeight(50);
        avatarView.setX(400);
        avatarView.setY(300);
        gameWorldPane.getChildren().add(avatarView);

        mover = avatarMove();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            moving += 1;

            switch(direction) {
                case "back":
                    avatarView.setY(avatarView.getY() + 1);
                    if (avatarTracker == 1){
                        avatarView.setImage(new Image("boy_up_2.png"));
                        avatarTracker = 2;
                    } else if (avatarTracker == 2){
                        avatarView.setImage(new Image("boy_up_1.png"));
                        avatarTracker = 1;
                    }
                    break;
                case "forward":
                    avatarView.setY(avatarView.getY() - 1);
                    if (avatarTracker == 1){
                        avatarView.setImage(new Image("boy_down_2.png"));
                        avatarTracker = 2;
                    } else if (avatarTracker == 2){
                        avatarView.setImage(new Image("boy_down_1.png"));
                        avatarTracker = 1;
                    }
                    break;
                case "right":
                    avatarView.setX(avatarView.getX() + 1);
                    if (avatarTracker == 1){
                        avatarView.setImage(new Image("boy_left_2.pn"));
                        avatarTracker = 2;

                    }else if (avatarTracker == 2){
                        avatarView.setImage(new Image("boy_left_1.png"));
                        avatarTracker = 1;
                    }
                    break;
                case "left":
                    avatarView.setX(avatarView.getX() - 1);
                    if (avatarTracker == 1){
                        avatarView.setImage(new Image("boy_right_2.pn"));
                        avatarTracker = 2;
                    }else if (avatarTracker == 2){
                        avatarView.setImage(new Image("boy_right_1.png"));
                        avatarTracker = 1;
                    }
                    break;

                default:
                    avatarView.setX(avatarView.getX() + 1);
                    avatarView.setY(avatarView.getY() + 1);
            }


        }));
        if (moving >= mover) {
            timeline.stop();
        }
        timeline.setCycleCount(mover); // Set the number of key frames to mover
        timeline.play();
    }

    public int avatarMove() {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("What will you?");
        userPrompt = newScanner.nextLine();
        direction = userPrompt.split(" ")[0].toLowerCase();
        int number = Integer.parseInt(userPrompt.split(" ")[1]);
        if (direction.equals("back")) {
            avatarView.setImage(new Image("boy_up_1.png"));
        } else if (direction.equals("forward")) {
            avatarView.setImage(new Image("boy_down_1.png"));
        } else if (direction.equals("right")) {
            avatarView.setImage(new Image("boy_left_1.png"));
        } else if (direction.equals("left")) {
            avatarView.setImage(new Image("boy_right_2.png"));
        }
        avatarTracker = 1;

        return number;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

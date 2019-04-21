package Controller;

import Physics.Coordinates;
import Physics.Frames;
import Physics.MoveEngine;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {

    @FXML
    private Button closebtn;
    @FXML
    private Button playbtn;
    @FXML
    private Button breakbtn;
    @FXML
    private Button repeatbtn;
    @FXML
    private Pane gamePane;
    @FXML
    private Label fpsLabel;

    AnimationTimer animationTimer;
    boolean living = true;
    Circle circle;

    public static int startVx = 0;
    public static int startVy = 50;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void quitGame() {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
    }

    public void playGame() {

        circle = new Circle(30, Color.VIOLET);
        gamePane.getChildren().add(circle);

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                    circle.setCenterX(Coordinates.getStartX());
                    circle.setCenterY(Coordinates.getStartY());
                    new MoveEngine(now);
                    Frames.showFPS02(now, fpsLabel);



            }
        };
        animationTimer.start();


    }

    public void stopGame() {
        animationTimer.stop(); }
}

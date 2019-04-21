package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameScreenController {

    @FXML
    private Button closebtn;
    @FXML
    private Button playbtn;
    @FXML
    private Button breakbtn;
    @FXML
    private Button repeatbtn;
    @FXML
    private Label fpsLabel;

    public void quitGame() {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
    }
}

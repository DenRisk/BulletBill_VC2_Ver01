package Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class StartScreenController {

    @FXML
    private Button startbtn;

    @FXML
    private Button quitbtn;

    @FXML
    private AnchorPane aPane;


    public void quitGame() {
        Stage stage = (Stage) quitbtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void loadGame() {
        loadFXML("/fxml/Simulation.fxml");

    }

    public void loadFXML(String fxml) {
        AnchorPane pane = null;
        try {
          pane = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aPane.getChildren().add(pane);


    }

}

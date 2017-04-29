package team1.kjm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class ControlController implements Initializable {

    @FXML
    private Button btnLight;
    @FXML
    private Button btnGas;
    @FXML
    private Button btnDoor;
    @FXML
    private Button btnSound;
    @FXML
    private StackPane stackPane;

    private static StackPane rootPane;
    private List<Parent> parent = new ArrayList<>();

    public ControlController() {
        try {
            this.parent.add(FXMLLoader.load(getClass().getResource("light.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("gas.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("security.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("sound.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = stackPane;
        btnLight.setOnAction(e -> handleBtn(e, 0));
        btnGas.setOnAction(e -> handleBtn(e, 1));
        btnDoor.setOnAction(e -> handleBtn(e, 2));
        btnSound.setOnAction(e -> handleBtn(e, 3));
    }

    private void handleBtn(ActionEvent e, int num) {
        rootPane.getChildren().clear();
        stackPane.getChildren().add(parent.get(num));
        translateX(num);
    }

    private void translateX(int num) {
        parent.get(num).setTranslateX(800);
        KeyValue keyValue = new KeyValue(parent.get(num).translateXProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}

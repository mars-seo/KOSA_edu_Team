package team1.kjm;

import java.io.IOException;
import java.net.URL;
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
    private Parent parent[] = new Parent[4];

    public ControlController() {
        try {
            this.parent[0] = FXMLLoader.load(getClass().getResource("lighting.fxml"));
            this.parent[1] = FXMLLoader.load(getClass().getResource("gas.fxml"));
            this.parent[2] = FXMLLoader.load(getClass().getResource("door.fxml"));
            this.parent[3] = FXMLLoader.load(getClass().getResource("sound.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = stackPane;
        btnLight.setOnAction(e -> handleBtnLight(e));
        btnGas.setOnAction(e -> handleBtnGas(e));
        btnDoor.setOnAction(e -> handleBtnDoor(e));
        btnSound.setOnAction(e -> handleBtnSound(e));
    }

    private void handleBtnLight(ActionEvent e) {
        rootPane.getChildren().clear();
        stackPane.getChildren().add(parent[0]);
        parent[0].setTranslateX(800);
        // parent.translateXProperty() 을 0까지             
        KeyValue keyValue = new KeyValue(parent[0].translateXProperty(), 0);
        // 0.1초간 진행
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
        // 아래 두개를 쌍으로
        Timeline timeline = new Timeline();
        // 애니메이션을 여러개 정의해 놓고 진행 가능
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    private void handleBtnGas(ActionEvent e) {
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent[1]);
    }

    private void handleBtnDoor(ActionEvent e) {
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent[2]);
    }

    private void handleBtnSound(ActionEvent e) {
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent[3]);
    }

}

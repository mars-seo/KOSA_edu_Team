package team1.jdj;

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

public class RootController implements Initializable {

    @FXML
    private Button btnGasFee;
    @FXML
    private Button btnElectricFee;
    @FXML
    private Button btnWaterFee;

    private static StackPane rootPane;
    @FXML
    private StackPane changeableStackPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = changeableStackPane;

        btnGasFee.setOnAction((event) -> {
            handlerBtnGasFee(event);
        });
        btnElectricFee.setOnAction((event) -> {
            handlerBtnElectricFee(event);
        });
        btnWaterFee.setOnAction((event) -> {
            handlerBtnWaterFee(event);
        });
    }

    public RootController() {

    }

    private void handlerBtnGasFee(ActionEvent event) {
        try {
            rootPane.getChildren().clear();

            Parent scene = FXMLLoader.load(getClass().getResource("mini.fxml"));
            rootPane.getChildren().add(scene);
            scene.setTranslateX(840);
            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(scene.translateXProperty(), 0);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handlerBtnElectricFee(ActionEvent event) {
        try {
            rootPane.getChildren().clear();
            Parent scene = FXMLLoader.load(getClass().getResource("electric.fxml"));
            rootPane.getChildren().add(scene);
            scene.setTranslateX(840);
            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(scene.translateXProperty(), 0);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handlerBtnWaterFee(ActionEvent event) {
        try {
            rootPane.getChildren().clear();
            Parent scene = FXMLLoader.load(getClass().getResource("water.fxml"));
            rootPane.getChildren().add(scene);

            scene.setTranslateX(840);
            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(scene.translateXProperty(), 0);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

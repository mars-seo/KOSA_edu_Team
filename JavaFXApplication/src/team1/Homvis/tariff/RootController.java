package team1.Homvis.tariff;

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

public class RootController implements Initializable {

    @FXML
    private Button btnGasFee;
    @FXML
    private Button btnElectricFee;
    @FXML
    private Button btnWaterFee;
    private List<Parent> parent = new ArrayList<>();
    private static StackPane rootPane;
    @FXML
    private StackPane changeableStackPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = changeableStackPane;

        btnGasFee.setOnAction((event) -> {
            handlerBtn(event,0);
        });
        btnElectricFee.setOnAction((event) -> {
            handlerBtn(event,1);
        });
        btnWaterFee.setOnAction((event) -> {
            handlerBtn(event,2);
        });
    }

    public RootController() {
        try {
            this.parent.add(FXMLLoader.load(getClass().getResource("gas.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("electric.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("water.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

//    private void handlerBtnGasFee(ActionEvent event) {
//        try {
//            rootPane.getChildren().clear();
//
//            Parent scene = FXMLLoader.load(getClass().getResource("gas.fxml"));
//            rootPane.getChildren().add(scene);
//            scene.setTranslateX(840);
//            Timeline timeline = new Timeline();
//            KeyValue keyValue = new KeyValue(scene.translateXProperty(), 0);
//            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
//            timeline.getKeyFrames().add(keyFrame);
//            timeline.play();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    private void handlerBtnElectricFee(ActionEvent event) {
//        try {
//            rootPane.getChildren().clear();
//            Parent scene = FXMLLoader.load(getClass().getResource("electric.fxml"));
//            rootPane.getChildren().add(scene);
//            scene.setTranslateX(840);
//            Timeline timeline = new Timeline();
//            KeyValue keyValue = new KeyValue(scene.translateXProperty(), 0);
//            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
//            timeline.getKeyFrames().add(keyFrame);
//            timeline.play();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    private void handlerBtnWaterFee(ActionEvent event) {
//        try {
//            rootPane.getChildren().clear();
//            Parent scene = FXMLLoader.load(getClass().getResource("water.fxml"));
//            rootPane.getChildren().add(scene);
//
//            scene.setTranslateX(840);
//            Timeline timeline = new Timeline();
//            KeyValue keyValue = new KeyValue(scene.translateXProperty(), 0);
//            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
//            timeline.getKeyFrames().add(keyFrame);
//            timeline.play();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
    private void handlerBtn(ActionEvent e, int num) {
        rootPane.getChildren().clear();
        changeableStackPane.getChildren().add(parent.get(num));
        translateX(num);
    }

    private void translateX(int num) {
        parent.get(num).setTranslateX(840);
        KeyValue keyValue = new KeyValue(parent.get(num).translateXProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}

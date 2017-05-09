package team1.Homvis.controlElectNGas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import team1.Homvis.main.MainController;

public class ControlMiniController implements Initializable {

    @FXML
    private ImageView btnLight;
    @FXML
    private ImageView btnGas;
    @FXML
    private ImageView btnDoor;
    @FXML
    private StackPane stackPane;

    private static StackPane rootPane;
    private List<Parent> parent = new ArrayList<>();
    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane miniControlRoot;
    @FXML
    private ImageView fullscreen;

    public ControlMiniController() {
        try {
            this.parent.add(FXMLLoader.load(getClass().getResource("lightMini.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("gasContMini.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("securityMini.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = stackPane;

        btnLight.setOnMouseClicked(e -> handleBtn(e, 0));
        btnGas.setOnMouseClicked(e -> handleBtn(e, 1));
        btnDoor.setOnMouseClicked(e -> handleBtn(e, 2));

        btnLight.setOnMousePressed(e -> handleBtnPressed(e, 0));
        btnGas.setOnMousePressed(e -> handleBtnPressed(e, 1));
        btnDoor.setOnMousePressed(e -> handleBtnPressed(e, 2));
        exit.setOnMousePressed(e -> handleBtnPressed(e, 3));
        fullscreen.setOnMousePressed(e -> handleBtnPressed(e, 4));

        exit.setOnMouseClicked(e -> exit());
        fullscreen.setOnMouseClicked(e -> fullscreen());
    }

    private void handleBtn(MouseEvent e, int num) {
        rootPane.getChildren().clear();
        stackPane.getChildren().add(parent.get(num));
//        translateX(num);

        if (num == 0) {
            btnLight.setImage(new Image(getClass().getResource("controlImg/elecNgas_light_clicked.png").toString()));
            btnGas.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_default.png").toString()));
            btnDoor.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_default.png").toString()));
            exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
            fullscreen.setImage(new Image(getClass().getResource("controlImg/fullscreen.png").toString()));
        } else if (num == 1) {
            btnLight.setImage(new Image(getClass().getResource("controlImg/elecNgas_light_default.png").toString()));
            btnGas.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_clicked.png").toString()));
            btnDoor.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_default.png").toString()));
            exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
            fullscreen.setImage(new Image(getClass().getResource("controlImg/fullscreen.png").toString()));
        } else if (num == 2) {
            btnLight.setImage(new Image(getClass().getResource("controlImg/elecNgas_light_default.png").toString()));
            btnGas.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_default.png").toString()));
            btnDoor.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_clicked.png").toString()));
            exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
            fullscreen.setImage(new Image(getClass().getResource("controlImg/fullscreen.png").toString()));
        }
    }

    private void translateX(int num) {
        parent.get(num).setTranslateX(800);
        KeyValue keyValue = new KeyValue(parent.get(num).translateXProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    private void handleBtnPressed(MouseEvent e, int num) {
        if (num == 0) {
            btnLight.setImage(new Image(getClass().getResource("controlImg/elecNgas_light_pressed.png").toString()));
        } else if (num == 1) {
            btnGas.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_pressed.png").toString()));
        } else if (num == 2) {
            btnDoor.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_pressed.png").toString()));
        } else if (num == 3) {
            exit.setImage(new Image(getClass().getResource("controlImg/exit_clicked.png").toString()));
        } else if (num == 4) {
            fullscreen.setImage(new Image(getClass().getResource("controlImg/fullscreen_clicked.png").toString()));
        }
    }

    private void exit() {
        exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
        fullscreen.setImage(new Image(getClass().getResource("controlImg/fullscreen.png").toString()));
        MainController.menuicon[2].setImage(new Image(getClass().getResource("../main/images/main_elecNgas_default.png").toString()));
        MainController.stackPane.getChildren().remove(miniControlRoot);
        MainController.menuicon[2].setDisable(false);
    }

    private void fullscreen() {
        exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
        fullscreen.setImage(new Image(getClass().getResource("controlImg/fullscreen.png").toString()));
        MainController.stackPane.getChildren().remove(MainController.parent.get(2));
        MainController.stackPane.getChildren().add(MainController.parent.get(2));
    }

}

package team1.Homvis.elecNgas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import team1.Homvis.MainController;

public class ControlController implements Initializable {

    @FXML
    private ImageView btnLight;
    @FXML
    private ImageView btnGas;
    @FXML
    private ImageView btnDoor;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane controlRoot;

    List<String> fxmlList = new ArrayList<>();
    Parent[] parent = new Parent[3];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxmlList.add("light.fxml");
        fxmlList.add("gasCont.fxml");
        fxmlList.add("security.fxml");

        btnLight.setOnMouseClicked(e -> handleBtn(e, 0));
        btnGas.setOnMouseClicked(e -> handleBtn(e, 1));
        btnDoor.setOnMouseClicked(e -> handleBtn(e, 2));

        btnLight.setOnMousePressed(e -> handleBtnPressed(e, 0));
        btnGas.setOnMousePressed(e -> handleBtnPressed(e, 1));
        btnDoor.setOnMousePressed(e -> handleBtnPressed(e, 2));
        exit.setOnMousePressed(e -> handleBtnPressed(e, 3));

        exit.setOnMouseClicked(e -> exit());
    }

    private void handleBtn(MouseEvent e, int num) {
        try {
            stackPane.getChildren().clear();
            if (parent[num] == null) {
                parent[num] = FXMLLoader.load(getClass().getResource(fxmlList.get(num)));
            }
            stackPane.getChildren().add(parent[num]);
            System.gc();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (num == 0) {
            btnLight.setImage(new Image(getClass().getResource("controlImg/elecNgas_light_clicked.png").toString()));
            btnGas.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_default.png").toString()));
            btnDoor.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_default.png").toString()));
            exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
        } else if (num == 1) {
            btnLight.setImage(new Image(getClass().getResource("controlImg/elecNgas_light_default.png").toString()));
            btnGas.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_clicked.png").toString()));
            btnDoor.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_default.png").toString()));
            exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
        } else if (num == 2) {
            btnLight.setImage(new Image(getClass().getResource("controlImg/elecNgas_light_default.png").toString()));
            btnGas.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_default.png").toString()));
            btnDoor.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_clicked.png").toString()));
            exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
        }
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
        }
    }

    private void exit() {
        exit.setImage(new Image(getClass().getResource("controlImg/exit_default.png").toString()));
        MainController.menuicon[2].setImage(new Image(getClass().getResource("controlImg/main_elecNgas_default.png").toString()));
        MainController.stackPane.getChildren().remove(controlRoot);
        MainController.menuicon[2].setDisable(false);
    }
}

package team1.Homvis.elecNgas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LightController implements Initializable {

    @FXML
    private ImageView imgLightOn;
    @FXML
    private ImageView imgLightOff;
    @FXML
    private BorderPane borderRoom1;
    @FXML
    private ImageView imgRoom1;
    @FXML
    private BorderPane borderRoom2;
    @FXML
    private ImageView imgRoom2;
    @FXML
    private BorderPane borderRoom3;
    @FXML
    private ImageView imgRoom3;
    @FXML
    private BorderPane borderRoom4;
    @FXML
    private ImageView imgRoom4;
    @FXML
    private BorderPane borderRoom5;
    @FXML
    private ImageView imgRoom5;
    @FXML
    private BorderPane borderRoom6;
    @FXML
    private ImageView imgRoom6;
    @FXML
    private BorderPane borderRoom7;
    @FXML
    private ImageView imgRoom7;
    @FXML
    private BorderPane borderRoom8;
    @FXML
    private ImageView imgRoom8;
    @FXML
    private BorderPane borderRoom9;
    @FXML
    private ImageView imgRoom9;

    public ObservableList<BorderPane> borderList;
    private ObservableList<ImageView> imageViewList;

    private String bulbOn = "controlImg/elecNgas_lighticon_on.png";
    private String bulbOff = "controlImg/elecNgas_lighticon_off.png";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borderList = FXCollections.observableArrayList();
        imageViewList = FXCollections.observableArrayList();

        borderList.add(borderRoom1);
        borderList.add(borderRoom2);
        borderList.add(borderRoom3);
        borderList.add(borderRoom4);
        borderList.add(borderRoom5);
        borderList.add(borderRoom6);
        borderList.add(borderRoom7);
        borderList.add(borderRoom8);
        borderList.add(borderRoom9);

        imageViewList.add(imgRoom1);
        imageViewList.add(imgRoom2);
        imageViewList.add(imgRoom3);
        imageViewList.add(imgRoom4);
        imageViewList.add(imgRoom5);
        imageViewList.add(imgRoom6);
        imageViewList.add(imgRoom7);
        imageViewList.add(imgRoom8);
        imageViewList.add(imgRoom9);

        for (int i = 0; i < ControlMiniController.lblRoom.length; i++) {
            ControlMiniController.labelList.add(ControlMiniController.lblRoom[i]);
        }

        // 각 공간의 조명 터치
        for (int i = 0; i < borderList.size(); i++) {
            int num = i;
            borderList.get(i).setOnMouseClicked(e -> handleRoom(e, num));
            ControlMiniController.labelList.get(i).textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.equals("on")) {
                        imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOn).toString()));
                        ControlMiniController.list.get(num).setOnOff(true);
                    } else {
                        imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOff).toString()));
                        ControlMiniController.list.get(num).setOnOff(false);
                    }
//                    System.out.println(num + ": " + newValue);
                }
            });
        }

        imgLightOn.setOnMouseClicked(e -> handleAllOn(e));
        imgLightOff.setOnMouseClicked(e -> handleAllOff(e));
        handleRoom();
    }

    // 각 공간의 조명 on/off
    private void handleRoom(MouseEvent e, int num) {
        if (!ControlMiniController.list.get(num).getOnOff()) {
            imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOn).toString()));
            ControlMiniController.list.get(num).setOnOff(true);
            ControlMiniController.labelList.get(num).setText("on");
        } else if (ControlMiniController.list.get(num).getOnOff()) {
            imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOff).toString()));
            ControlMiniController.list.get(num).setOnOff(false);
            ControlMiniController.labelList.get(num).setText("off");
        }
    }

    private void handleRoom() {
        for (int i = 0; i < ControlMiniController.list.size(); i++) {
            if (ControlMiniController.list.get(i).getOnOff()) {
                imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOn).toString()));
                ControlMiniController.list.get(i).setOnOff(true);
            } else if (!ControlMiniController.list.get(i).getOnOff()) {
                imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOff).toString()));
                ControlMiniController.list.get(i).setOnOff(false);
            }
        }

    }

    // 전체 조명 on
    private void handleAllOn(MouseEvent e) {
        for (int i = 0; i < imageViewList.size(); i++) {
            imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOn).toString()));
            ControlMiniController.list.get(i).setOnOff(true);
            ControlMiniController.labelList.get(i).setText("on");
        }
    }

    // 전체 조명 off
    private void handleAllOff(MouseEvent e) {
        for (int i = 0; i < imageViewList.size(); i++) {
            imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOff).toString()));
            ControlMiniController.list.get(i).setOnOff(false);
            ControlMiniController.labelList.get(i).setText("off");
        }
    }
}

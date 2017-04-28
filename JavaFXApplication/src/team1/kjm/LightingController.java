package team1.kjm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LightingController implements Initializable {

    @FXML
    private BorderPane borderRoomBoiler;
    @FXML
    private ImageView imgRoomBoiler;
    @FXML
    private BorderPane borderRoomUtility;
    @FXML
    private ImageView imgRoomUtility;
    @FXML
    private BorderPane borderRoom1;
    @FXML
    private ImageView imgRoom1;
    @FXML
    private BorderPane borderRoomKitchen;
    @FXML
    private ImageView imgRoomKitchen;
    @FXML
    private BorderPane borderRoomLiving;
    @FXML
    private ImageView imgRoomLiving;
    @FXML
    private BorderPane borderRoomBath;
    @FXML
    private ImageView imgRoomBath;
    @FXML
    private BorderPane borderRoomEntrance;
    @FXML
    private ImageView imgRoomEntrance;
    @FXML
    private BorderPane borderRoom2;
    @FXML
    private ImageView imgRoom2;
    @FXML
    private BorderPane borderRoom3;
    @FXML
    private ImageView imgRoom3;
    @FXML
    private ImageView imgLightOn;
    @FXML
    private ImageView imgLightOff;

    private ObservableList<Light> list;
    private ObservableList<BorderPane> borderList;
    private ObservableList<ImageView> imageViewList;
    private String bulbOn = "images/light-bulb-icon.png";
    private String bulbOff = "images/bulb-icon.png";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = FXCollections.observableArrayList();
        borderList = FXCollections.observableArrayList();
        imageViewList = FXCollections.observableArrayList();

        list.add(new Light("boiler", false));
        list.add(new Light("utility", false));
        list.add(new Light("room1", false));
        list.add(new Light("room2", false));
        list.add(new Light("room3", false));
        list.add(new Light("bath", false));
        list.add(new Light("kitchen", false));
        list.add(new Light("living", false));
        list.add(new Light("entrance", false));

        borderList.add(borderRoomBoiler);
        borderList.add(borderRoomUtility);
        borderList.add(borderRoom1);
        borderList.add(borderRoom2);
        borderList.add(borderRoom3);
        borderList.add(borderRoomBath);
        borderList.add(borderRoomKitchen);
        borderList.add(borderRoomLiving);
        borderList.add(borderRoomEntrance);

        imageViewList.add(imgRoomBoiler);
        imageViewList.add(imgRoomUtility);
        imageViewList.add(imgRoom1);
        imageViewList.add(imgRoom2);
        imageViewList.add(imgRoom3);
        imageViewList.add(imgRoomBath);
        imageViewList.add(imgRoomKitchen);
        imageViewList.add(imgRoomLiving);
        imageViewList.add(imgRoomEntrance);

        // 각 공간의 이벤트
        for (int i = 0; i < borderList.size(); i++) {
            int num = i;
            borderList.get(i).setOnMouseClicked(e -> {
                handleRoom(e, num);
            });
        }

        imgLightOn.setOnMouseClicked(e -> handleAllOn(e));
        imgLightOff.setOnMouseClicked(e -> handleAllOff(e));
    }

    // 각 공간의 조명 on/off
    private void handleRoom(MouseEvent e, int num) {
        if (list.get(num).getOnOff() == false) {
            imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOn).toString()));
            list.get(num).setOnOff(true);
        } else if (list.get(num).getOnOff() == true) {
            imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOff).toString()));
            list.get(num).setOnOff(false);
        }
    }

    // 전체 조명 on
    private void handleAllOn(MouseEvent e) {
        for (int i = 0; i < imageViewList.size(); i++) {
            imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOn).toString()));
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOnOff(true);
        }
    }

    // 전체 조명 off
    private void handleAllOff(MouseEvent e) {
        for (int i = 0; i < imageViewList.size(); i++) {
            imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOff).toString()));
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOnOff(false);
        }
    }
}

package team1.Homvis.controlElectNGas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    public static Label lblRoom1 = new Label("");
    public static Label lblRoom2 = new Label("");
    public static Label lblRoom3 = new Label("");
    public static Label lblRoom4 = new Label("");
    public static Label lblRoom5 = new Label("");
    public static Label lblRoom6 = new Label("");
    public static Label lblRoom7 = new Label("");
    public static Label lblRoom8 = new Label("");
    public static Label lblRoom9 = new Label("");

    private ObservableList<Light> list;
    public ObservableList<BorderPane> borderList;
    private ObservableList<ImageView> imageViewList;
    public static ObservableList<Label> labelList;
    private String bulbOn = "controlImg/light-bulb-icon.png";
    private String bulbOff = "controlImg/bulb-icon.png";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = FXCollections.observableArrayList();
        borderList = FXCollections.observableArrayList();
        imageViewList = FXCollections.observableArrayList();
        labelList = FXCollections.observableArrayList();

        list.add(new Light("boiler", false));
        list.add(new Light("utility", false));
        list.add(new Light("room1", false));
        list.add(new Light("room2", false));
        list.add(new Light("room3", false));
        list.add(new Light("bath", false));
        list.add(new Light("kitchen", false));
        list.add(new Light("living", false));
        list.add(new Light("entrance", false));

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

        labelList.add(lblRoom1);
        labelList.add(lblRoom2);
        labelList.add(lblRoom3);
        labelList.add(lblRoom4);
        labelList.add(lblRoom5);
        labelList.add(lblRoom6);
        labelList.add(lblRoom7);
        labelList.add(lblRoom8);
        labelList.add(lblRoom9);

        // 각 공간의 조명 터치
        for (int i = 0; i < borderList.size(); i++) {
            int num = i;
            borderList.get(i).setOnMouseClicked(e -> handleRoom(e, num));
            labelList.get(i).textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.equals("on")) {
                        imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOn).toString()));
                        list.get(num).setOnOff(true);
                    } else {
                        imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOff).toString()));
                        list.get(num).setOnOff(false);
                    }
                    System.out.println(num + ": " + newValue);
                }
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
            labelList.get(num).setText("on");
        } else if (list.get(num).getOnOff() == true) {
            imageViewList.get(num).setImage(new Image(getClass().getResource(bulbOff).toString()));
            list.get(num).setOnOff(false);
            labelList.get(num).setText("off");
        }
    }

    // 전체 조명 on
    private void handleAllOn(MouseEvent e) {
        for (int i = 0; i < imageViewList.size(); i++) {
            imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOn).toString()));
            list.get(i).setOnOff(true);
            labelList.get(i).setText("on");
        }
    }

    // 전체 조명 off
    private void handleAllOff(MouseEvent e) {
        for (int i = 0; i < imageViewList.size(); i++) {
            imageViewList.get(i).setImage(new Image(getClass().getResource(bulbOff).toString()));
            list.get(i).setOnOff(false);
            labelList.get(i).setText("off");
        }
    }
}

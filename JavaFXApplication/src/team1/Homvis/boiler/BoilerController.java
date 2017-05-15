package team1.Homvis.boiler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import static team1.Homvis.boiler.BoilerminiController.goOutState;
import static team1.Homvis.boiler.BoilerminiController.heatOnState;
import static team1.Homvis.boiler.BoilerminiController.hopeHeat;
import static team1.Homvis.boiler.BoilerminiController.hopeWater;
import static team1.Homvis.boiler.BoilerminiController.nowHeat;
import static team1.Homvis.boiler.BoilerminiController.waterOnState;
import static team1.Homvis.boiler.BoilerminiController.wifiState;
import static team1.Homvis.boiler.BoilerminiController.nightmodeState;

import team1.Homvis.MainController;

public class BoilerController implements Initializable {

    @FXML
    private AnchorPane boilerRoot;
    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane displayPane;
    @FXML
    private ImageView graph;
    @FXML
    private ImageView bar1;
    @FXML
    private ImageView bar2;
    @FXML
    private ImageView bar3;
    @FXML
    private ImageView bar4;
    @FXML
    private ImageView bar5;
    @FXML
    private ImageView bar6;
    @FXML
    private ImageView bar7;
    @FXML
    private ImageView bar8;
    @FXML
    private ImageView bar9;
    @FXML
    private ImageView bar10;
    @FXML
    private ImageView bar11;
    @FXML
    private ImageView bar12;
    @FXML
    private ImageView bar13;
    @FXML
    private ImageView bar14;
    @FXML
    private ImageView bar15;
    @FXML
    private ImageView bar16;
    @FXML
    private ImageView bar17;
    @FXML
    private ImageView bar18;
    @FXML
    private ImageView bar19;
    @FXML
    private ImageView bar20;
    @FXML
    private ImageView bar21;
    @FXML
    private ImageView bar22;
    @FXML
    private ImageView bar23;
    @FXML
    private ImageView bar24;
    @FXML
    private ImageView gasDisplay;
    @FXML
    private ImageView heatDisplay;
    @FXML
    private ImageView modeDisplay;
    @FXML
    private ImageView waterDisplay;
    @FXML
    private Label txtnowHeat;
    @FXML
    private Label txthopeHeat;
    @FXML
    private Label txtWater;
    @FXML
    private ImageView heatUp;
    @FXML
    private ImageView wifi;
    @FXML
    private ImageView heatOn;
    @FXML
    private ImageView heatDown;
    @FXML
    private ImageView modeOn;
    @FXML
    private ImageView waterUp;
    @FXML
    private ImageView waterOn;
    @FXML
    private ImageView waterDown;
    @FXML
    private ImageView goOut;
    @FXML
    private StackPane stackDisplay;

    public static ImageView modeImage;
    public static ImageView bars1;

    public static Parent boilermodeView;
    public static List<ImageView> barList = new ArrayList<>();
    public static StackPane boilerModeStack;

    public static int count = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bars1=bar1;
        barList.add(bars1);
        barList.add(bar2);
        barList.add(bar3);
        barList.add(bar4);
        barList.add(bar5);
        barList.add(bar6);
        barList.add(bar7);
        barList.add(bar8);
        barList.add(bar9);
        barList.add(bar10);
        barList.add(bar11);
        barList.add(bar12);
        barList.add(bar13);
        barList.add(bar14);
        barList.add(bar15);
        barList.add(bar16);
        barList.add(bar17);
        barList.add(bar18);
        barList.add(bar19);
        barList.add(bar20);
        barList.add(bar21);
        barList.add(bar22);
        barList.add(bar23);
        barList.add(bar24);
        for (ImageView list : barList) {
            list.setOpacity(0);
        }
        

        if (wifiState == true) {

            displayOn(wifi, "wifi_on");
        } else {
            displayOn(wifi, "wifi_off");
        }
        if (goOutState == true) {
            keyPressed(goOut, "goout");
        } else {
            keyClicked(goOut, "goout");
        }
        if (heatOnState == false) {
            gasDisplay.setOpacity(0);
            heatDisplay.setOpacity(0);
            txthopeHeat.setOpacity(0);
        } else {
            heatDisplay.setOpacity(1);
            txthopeHeat.setOpacity(1);
            txthopeHeat.setText(String.valueOf(hopeHeat));
            if (hopeHeat > nowHeat) {
                gasDisplay.setOpacity(1);
            }
        }
        if (waterOnState == false) {
            waterDisplay.setOpacity(0);
            txtWater.setOpacity(0);
        } else {
            txtWater.setOpacity(1);
            txtWater.setText(String.valueOf(hopeWater));
            waterDisplay.setOpacity(1);
        }
        
        modeDisplay.setOpacity(0);
        if (BoilerminiController.ecomodeState == true) {
            displayOn(modeDisplay, "modeECO");
        } else if (nightmodeState == true) {
            displayOn(modeDisplay, "modeSLEEPING");
        } else if (BoilerminiController.usermodeState == true) {
            displayOn(modeDisplay, "modeUSER");
        } else {
        modeDisplay.setOpacity(0);
        }

        for (int i = 0; i < BoilerminiController.barStateArray.length; i++) {
            if (BoilerminiController.barStateArray[i] == true) {
                barList.get(i).setOpacity(1);
            }
        }
        
        try {
            boilermodeView = FXMLLoader.load(getClass().getResource("modechange.fxml"));
        } catch (IOException ex) {
        }

        txtnowHeat.setText(String.valueOf(nowHeat));
        boilerModeStack = stackDisplay;
        modeImage = modeDisplay;

        wifi.setOnMouseClicked(event -> wifi());
        heatUp.setOnMouseClicked(event -> heatUp());
        heatDown.setOnMouseClicked(event -> heatDown());
        waterUp.setOnMouseClicked(event -> waterUp());
        waterDown.setOnMouseClicked(event -> waterDown());
        modeOn.setOnMouseClicked(event -> modeOn());
        exit.setOnMouseClicked(event -> exit());

        heatOn.setOnMouseClicked(event -> heatOn());
        waterOn.setOnMouseClicked(event -> waterOn());
        goOut.setOnMouseClicked(event -> goOut());

    }

    private void keyClicked(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/boiler_" + name + "_default.png").toString()));
    }

    private void keyDragged(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/boiler_" + name + "_default.png").toString()));
    }

    private void keyPressed(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/boiler_" + name + "_clicked.png").toString()));
    }

    private void displayOn(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/boiler_" + name + ".png").toString()));
    }

    public Label getTxthopeHeat() {
        return txthopeHeat;
    }

    private void exit() {
        MainController.menuicon[1].setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
        MainController.stackPane.getChildren().remove(boilerRoot);
				MainController.stackPane.getChildren().remove(MainController.miniVeiw[2]);
		MainController.menuicon[1].setDisable(false);

        /*     boilerRoot.setOpacity(1);
        boilerRoot.setTranslateX(0);
        KeyValue keyValue = new KeyValue(boilerRoot.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                (event) -> {
                    Root1Controller.stackPane.getChildren().remove(boilerRoot);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        Root1Controller.menuicon2.setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
         */
    }

    private void wifi() {
        if (wifiState == false) {
            displayOn(wifi, "wifi_on");  //WIFi On됬을때 사진넣기
            wifiState = true;
        } else {
            displayOn(wifi, "wifi_off");//WIFi off됬을때 사진넣기
            wifiState = false;
        }
    }

    private void heatOn() {

        if (heatDisplay.getOpacity() == 0) {
            if (hopeHeat > nowHeat) {
                gasDisplay.setOpacity(1);
            }
            heatDisplay.setOpacity(1);
            txthopeHeat.setOpacity(1);
            heatOnState = true;
        } else {
            if (gasDisplay.getOpacity() == 1) {
                gasDisplay.setOpacity(0);
            }
            heatDisplay.setOpacity(0);
            heatOnState = false;
            txthopeHeat.setOpacity(0);
        }

    }

    private void waterOn() {
        if (waterDisplay.getOpacity() == 0) {
            waterDisplay.setOpacity(1);
            txtWater.setOpacity(1);
            waterOnState = true;
        } else {
            waterDisplay.setOpacity(0);
            txtWater.setOpacity(0);
            waterOnState = false;
        }
    }

    private void goOut() {
        if (goOutState == false) {
            displayOn(goOut, "goout_clicked");    //외출 On됬을때 사진넣기
            goOutState = true;
        } else {
            displayOn(goOut, "goout_default");//외출 off됬을때 사진넣기
            goOutState = false;
        }

    }

    private void heatUp() {
        if (heatOnState == true) {
            hopeHeat += 1;
            txthopeHeat.setText(String.valueOf(hopeHeat));
            if (hopeHeat > nowHeat) {
                gasDisplay.setOpacity(1);
            } else {
                gasDisplay.setOpacity(0);
            }
        }
    }

    private void heatDown() {
        if (heatOnState == true) {
            hopeHeat += -1;
            txthopeHeat.setText(String.valueOf(hopeHeat));
            if (hopeHeat > nowHeat) {
                gasDisplay.setOpacity(1);
            } else {
                gasDisplay.setOpacity(0);
            }
        }

    }

    private void waterUp() {
        if (waterOnState == true) {
            hopeWater += 1;
            txtWater.setText(String.valueOf(hopeWater));
        }
    }

    private void waterDown() {
        if (waterOnState == true) {
            hopeWater -= 1;
            txtWater.setText(String.valueOf(hopeWater));
        }
    }

    private void modeOn() {
        if (count == 0) {
            stackDisplay.getChildren().add(boilermodeView);
            boilermodeView.setTranslateX(0);
            //   boilermodeView.setOpacity(0);
            //     KeyValue keyValue = new KeyValue(boilermodeView.opacityProperty(), 1);
            //    KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
            //    Timeline timeline = new Timeline();
            //    timeline.getKeyFrames().add(keyFrame);
            //   timeline.play();
            count = 1;
        } else {

            count = 0;
        }

    }

}

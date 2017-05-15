package team1.Homvis.boiler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import team1.Homvis.MainController;

public class BoilerminiController implements Initializable {

    @FXML
    private AnchorPane boilerminiRoot;
    @FXML
    private ImageView heatUp;
    @FXML
    private ImageView heatOn;
    @FXML
    private ImageView heatDown;
    @FXML
    private ImageView waterUp;
    @FXML
    private ImageView waterOn;
    @FXML
    private ImageView waterDown;
    @FXML
    private ImageView heatDisplay;
    @FXML
    private Label txthopeHeat;
    @FXML
    private Label txtnowHeat;
    @FXML
    private ImageView waterDisplay;
    @FXML
    private ImageView gasDisplay;
    @FXML
    private Label txtWater;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView fullscreen;
    
    public static Parent boilers;

    public static Boolean wifiState = false;
    public static Boolean goOutState = false;
    public static int hopeWater = 14;
    public static int hopeHeat = 24;
    public static int nowHeat = 27;
    public static boolean heatOnState = false;
    public static boolean waterOnState = false;
    public static boolean ecomodeState = false;
    public static boolean usermodeState = false;
    public static boolean nightmodeState = false;
    public static boolean bar1State = false;
    public static boolean bar2State = false;
    public static boolean bar3State = false;
    public static boolean bar4State = false;
    public static boolean bar5State = false;
    public static boolean bar6State = false;
    public static boolean bar7State = false;
    public static boolean bar8State = false;
    public static boolean bar9State = false;
    public static boolean bar10State = false;
    public static boolean bar11State = false;
    public static boolean bar12State = false;
    public static boolean bar13State = false;
    public static boolean bar14State = false;
    public static boolean bar15State = false;
    public static boolean bar16State = false;
    public static boolean bar17State = false;
    public static boolean bar18State = false;
    public static boolean bar19State = false;
    public static boolean bar20State = false;
    public static boolean bar21State = false;
    public static boolean bar22State = false;
    public static boolean bar23State = false;
    public static boolean bar24State = false;
    public static boolean[] barStateArray={bar1State,bar2State,bar3State,bar4State,bar5State,bar6State,bar7State,bar8State,bar9State,bar10State,bar11State,
    bar12State,bar13State,bar14State,bar15State,bar16State,bar17State,bar18State,bar19State,bar20State,bar21State,bar22State,bar23State,bar24State,};
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gasDisplay.setOpacity(0);

        heatDisplay.setOpacity(0);
        txthopeHeat.setOpacity(0);
        waterDisplay.setOpacity(0);
        txtWater.setOpacity(0);
        txtnowHeat.setText(String.valueOf(nowHeat));
        heatUp.setOnMouseClicked(event -> heatUp());
        heatDown.setOnMouseClicked(event -> heatDown());
        waterUp.setOnMouseClicked(event -> waterUp());
        waterDown.setOnMouseClicked(event -> waterDown());
        exit.setOnMouseClicked(event -> exit());
        heatOn.setOnMouseClicked(event -> heatOn());
        waterOn.setOnMouseClicked(event -> waterOn());
        fullscreen.setOnMouseClicked(event -> fullscreen());
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

    private void exit() {
        MainController.menuicon[1].setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
        MainController.stackPane.getChildren().remove(boilerminiRoot);
        MainController.menuicon[1].setDisable(false);
    }

    public void fullscreen() {
        try {
          //  if(MainController.veiw[1]==null) 
					MainController.veiw[1] = FXMLLoader.load(getClass().getResource(MainController.menuList.get(1)+".fxml"));
			MainController.stackPane.getChildren().add(MainController.veiw[1]);
            MainController.veiw[1].setTranslateY(0);
            MainController.veiw[1].setTranslateX(0);

        } catch (IOException ex) {
        }

        MainController.stackPane.getChildren().remove(boilerminiRoot);
    }

}

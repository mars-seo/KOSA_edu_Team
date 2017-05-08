
package team1.Homvis.boiler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static team1.Homvis.boiler.BoilerController.heatOnState;
import static team1.Homvis.boiler.BoilerController.hopeHeat;
import static team1.Homvis.boiler.BoilerController.hopeWater;
import static team1.Homvis.boiler.BoilerController.nowHeat;
import static team1.Homvis.boiler.BoilerController.waterOnState;
import team1.Homvis.main.MainController;

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
            if(gasDisplay.getOpacity()==1){
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
        
        MainController.stackPane.getChildren().add(MainController.parent.get(1));
        MainController.stackPane.getChildren().remove(boilerminiRoot);
    }
    
}

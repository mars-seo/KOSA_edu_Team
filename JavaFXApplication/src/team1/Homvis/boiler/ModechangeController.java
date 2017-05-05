
package team1.Homvis.boiler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ModechangeController implements Initializable {

    @FXML
    private ImageView ecoMode;
    @FXML
    private ImageView userMode;
    @FXML
    private ImageView nightMode;
    @FXML
    private ImageView ok;
    @FXML
    private AnchorPane userModeView;
    @FXML
    private ImageView am;
    @FXML
    private ImageView pm;
    @FXML
    private ImageView one;
    @FXML
    private ImageView two;
    @FXML
    private ImageView three;
    @FXML
    private ImageView four;
    @FXML
    private ImageView five;
    @FXML
    private ImageView six;
    @FXML
    private ImageView seven;
    @FXML
    private ImageView eight;
    @FXML
    private ImageView nine;
    @FXML
    private ImageView ten;
    @FXML
    private ImageView eleven;
    @FXML
    private ImageView twelve;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userModeView.setOpacity(0);
        
       ecoMode.setOnMouseClicked(event->ecoMode());
       userMode.setOnMouseClicked(event->userMode());
       nightMode.setOnMouseClicked(event->nightMode());
       ok.setOnMouseClicked(event->ok());
       
    }    

    private void ecoMode() {
        userModeView.setOpacity(0);
        if (BoilerController.ecomodeState == false) {
            
            BoilerController.modeImage.setOpacity(1);
            ecoMode.setImage(new Image(getClass().getResource("images/ecoOn.png").toString()));   //ecomode On됬을때 사진넣기
            userMode.setImage(new Image(getClass().getResource("images/usermode.PNG").toString()));
            nightMode.setImage(new Image(getClass().getResource("images/nightmode.PNG").toString()));
            BoilerController.ecomodeState = true;
            BoilerController.nightmodeState=false;
            BoilerController.usermodeState=false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/ecoOn.png").toString())); 
        } else {
            ecoMode.setImage(new Image(getClass().getResource("images/ecomode.png").toString()));//dcomode off됬을때 사진넣기
            BoilerController.ecomodeState= false;
            BoilerController.modeImage.setOpacity(0);
        }
    }

    private void userMode() {
        
         if (BoilerController.usermodeState == false) {
            userModeView.setOpacity(1);
            userMode.setImage(new Image(getClass().getResource("images/userOn.PNG").toString()));   //ecomode On됬을때 사진넣기
            ecoMode.setImage(new Image(getClass().getResource("images/ecomode.PNG").toString()));
            nightMode.setImage(new Image(getClass().getResource("images/nightmode.PNG").toString()));
            BoilerController.modeImage.setOpacity(1);
            BoilerController.usermodeState = true;
            BoilerController.nightmodeState=false;
            BoilerController.ecomodeState=false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/userOn.PNG").toString())); 
        } else {
             userModeView.setOpacity(0);
            userMode.setImage(new Image(getClass().getResource("images/usermode.PNG").toString()));//dcomode off됬을때 사진넣기
            BoilerController.usermodeState= false;
            BoilerController.modeImage.setOpacity(0);
        }
        
    }

    private void nightMode() {
        userModeView.setOpacity(0);
        if (BoilerController.nightmodeState == false) {
            
            nightMode.setImage(new Image(getClass().getResource("images/nightmodeOn.PNG").toString()));   //nightmode On됬을때 사진넣기
            userMode.setImage(new Image(getClass().getResource("images/usermode.PNG").toString()));   //nightmode On됬을때 사진넣기
            ecoMode.setImage(new Image(getClass().getResource("images/ecomode.PNG").toString()));   //nightmode On됬을때 사진넣기
            BoilerController.nightmodeState = true;
            BoilerController.usermodeState=false;
            BoilerController.ecomodeState=false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/nightmodeOn.PNG").toString()));   //boiler쪽 mode이미지변경
            BoilerController.modeImage.setOpacity(1);
        } else {
            nightMode.setImage(new Image(getClass().getResource("images/nightmode.png").toString()));//nightmode off됬을때 사진넣기
            BoilerController.nightmodeState= false;
            BoilerController.modeImage.setOpacity(0);
        }
        
    }

    private void ok() {
        BoilerController.boilerModeStack.getChildren().remove(BoilerController.boilermodeView);
        BoilerController.count=0;
    }
    
}

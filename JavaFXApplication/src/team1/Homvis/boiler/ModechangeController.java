
package team1.Homvis.boiler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ModechangeController implements Initializable {

    @FXML
    private ImageView ecoMode;
    @FXML
    private ImageView userMode;
    @FXML
    private ImageView nightMode;
    @FXML
    private ImageView ok;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ecoMode.setOnMouseClicked(event->ecoMode());
       userMode.setOnMouseClicked(event->userMode());
       nightMode.setOnMouseClicked(event->nightMode());
       ok.setOnMouseClicked(event->ok());
    }    

    private void ecoMode() {
        if (BoilerController.ecomodeState == false) {
            ecoMode.setImage(new Image(getClass().getResource("images/ecoOn.png").toString()));   //WIFi On됬을때 사진넣기
            BoilerController.ecomodeState = true;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/ecoOn.png").toString())); 
        } else {
            ecoMode.setImage(new Image(getClass().getResource("images/ecomode.png").toString()));//WIFi off됬을때 사진넣기
            BoilerController.ecomodeState= false;
        }
    }

    private void userMode() {
        
        
    }

    private void nightMode() {
        
    }

    private void ok() {
        BoilerController.boilerModeStack.getChildren().remove(BoilerController.boilermodeView);
    }
    
}

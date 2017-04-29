
package team1.kjm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class DoorController implements Initializable {

    @FXML
    private ImageView imgDoorState;
    @FXML
    private ImageView imgDoorOpen;
    @FXML
    private ImageView imgDoorClose;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgDoorOpen.setOnMouseClicked(e->handleDoorOpen(e));
        imgDoorClose.setOnMouseClicked(e->handleDoorClose(e));
    }    

    private void handleDoorOpen(MouseEvent e) {
        imgDoorState.setImage(new Image(getClass().getResource("images/unlock1.png").toString()));    
    }

    private void handleDoorClose(MouseEvent e) {
        imgDoorState.setImage(new Image(getClass().getResource("images/lock1.png").toString()));    
    }
    
}

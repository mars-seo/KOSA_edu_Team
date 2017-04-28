
package team1.kjm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class GasController implements Initializable {

    @FXML
    private ImageView imgGasState;
    @FXML
    private ImageView imgGasOn;
    @FXML
    private ImageView imgGasOff;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgGasOn.setOnMouseClicked(e->handleGasOn(e));
        imgGasOff.setOnMouseClicked(e->handleGasOff(e));
    }    

    private void handleGasOn(MouseEvent e) {
        imgGasState.setImage(new Image(getClass().getResource("images/gason.png").toString()));
    }

    private void handleGasOff(MouseEvent e) {
        imgGasState.setImage(new Image(getClass().getResource("images/gasoff.png").toString()));
    }
    
}

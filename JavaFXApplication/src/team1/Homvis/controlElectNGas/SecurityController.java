package team1.Homvis.controlElectNGas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SecurityController implements Initializable {

    @FXML
    private ImageView imgSecurityState;
    @FXML
    private ImageView imgScurityOnoff;

    private boolean securityState;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgScurityOnoff.setOnMouseClicked(e -> handleSecurityOnOff(e));
    }

    private void handleSecurityOnOff(MouseEvent e) {
        if (securityState) {
//            imgSecurityState.setImage(new Image(getClass().getResource("controlImg/securityo.png").toString()));
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_on.png").toString()));
        } else {
//            imgSecurityState.setImage(new Image(getClass().getResource("controlImg/securityx.png").toString()));
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_off.png").toString()));
        }
        securityState = !securityState;
    }
}

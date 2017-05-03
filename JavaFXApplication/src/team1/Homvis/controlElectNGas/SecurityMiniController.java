package team1.Homvis.controlElectNGas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SecurityMiniController implements Initializable {

    @FXML
    private ImageView imgSecurityState;
    @FXML
    private ImageView imgScurityOnoff;
    @FXML
    private Label lblSecurityState;

    private boolean securityState;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgScurityOnoff.setOnMouseClicked(e -> handleSecurityOnOff(e));
    }

    private void handleSecurityOnOff(MouseEvent e) {
        if (securityState) {
            imgSecurityState.setImage(new Image(getClass().getResource("images/securityo.png").toString()));
            imgScurityOnoff.setImage(new Image(getClass().getResource("images/on1.png").toString()));
            lblSecurityState.setText("보안이 작동중입니다.");
        } else {
            imgSecurityState.setImage(new Image(getClass().getResource("images/securityx.png").toString()));
            imgScurityOnoff.setImage(new Image(getClass().getResource("images/off1.png").toString()));
            lblSecurityState.setText("보안이 해제되었습니다.");
        }
        securityState = !securityState;
    }

}

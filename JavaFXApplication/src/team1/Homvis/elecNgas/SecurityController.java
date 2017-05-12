package team1.Homvis.elecNgas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SecurityController implements Initializable {

    @FXML
    public ImageView imgScurityOnoff;

    public boolean isSecurityState() {
        return ControlMiniController.securityState;
    }

    public void setSecurityState(boolean securityState) {
        ControlMiniController.securityState = securityState;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleSecurityOnOff();
        ControlMiniController.lblSecurityState.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("on")) {
                    imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_on.png").toString()));
                    setSecurityState(true);
                } else {
                    imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_off.png").toString()));
                    setSecurityState(false);
                }
//                System.out.println("Security: " + isSecurityState());
            }
        });
        imgScurityOnoff.setOnMouseClicked(e -> handleSecurityOnOff(e));
    }

    private void handleSecurityOnOff(MouseEvent e) {
        if (!isSecurityState()) {
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_on.png").toString()));
            ControlMiniController.lblSecurityState.setText("on");
        } else {
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_off.png").toString()));
            ControlMiniController.lblSecurityState.setText("off");
        }
    }

    private void handleSecurityOnOff() {
        if (isSecurityState()) {
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_on.png").toString()));
        } else {
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_off.png").toString()));
        }
    }
}

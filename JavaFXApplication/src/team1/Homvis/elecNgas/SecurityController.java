package team1.Homvis.elecNgas;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SecurityController implements Initializable {

    @FXML
    public ImageView imgScurityOnoff;

    public boolean securityState = true;
    // static 이 됨으로 두 파일 모두에 관여함
    public static Label lblSecurityState = new Label("");

    public boolean isSecurityState() {
        return securityState;
    }

    public void setSecurityState(boolean securityState) {
        this.securityState = securityState;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblSecurityState.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("on")) {
                    imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_on.png").toString()));
                    setSecurityState(true);
                } else {
                    imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_off.png").toString()));
                    setSecurityState(false);
                }
                System.out.println("Security: " + isSecurityState());
            }
        });
        imgScurityOnoff.setOnMouseClicked(e -> handleSecurityOnOff(e));
    }

    private void handleSecurityOnOff(MouseEvent e) {

        if (!isSecurityState()) {
//            imgSecurityState.setImage(new Image(getClass().getResource("controlImg/securityo.png").toString()));
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_on.png").toString()));
            lblSecurityState.setText("on");
        } else {
//            imgSecurityState.setImage(new Image(getClass().getResource("controlImg/securityx.png").toString()));
            imgScurityOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_security_off.png").toString()));
            lblSecurityState.setText("off");
        }
    }
}

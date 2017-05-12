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

public class GasContController implements Initializable {

    @FXML
    private ImageView imgGasOnoff;

    public boolean isGasState() {
        return ControlMiniController.gasState;
    }

    public void setGasState(boolean gasState) {
        ControlMiniController.gasState = gasState;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleGasOnOff();
        ControlMiniController.lblGasState.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("on")) {
                    imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_on.png").toString()));
                    setGasState(true);
                } else {
                    imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_off.png").toString()));
                    setGasState(false);
                }
//                System.out.println("Gas: " + isGasState());
            }
        });
        imgGasOnoff.setOnMouseClicked(e -> handleGasOnOff(e));
    }

    private void handleGasOnOff(MouseEvent e) {
        if (!isGasState()) {
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_on.png").toString()));
            ControlMiniController.lblGasState.setText("on");
        } else {
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_off.png").toString()));
            ControlMiniController.lblGasState.setText("off");
        }
    }

    private void handleGasOnOff() {
        if (isGasState()) {
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_on.png").toString()));
        } else {
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_off.png").toString()));
        }
    }
}

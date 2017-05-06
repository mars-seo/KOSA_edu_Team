package team1.Homvis.controlElectNGas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GasContMiniController implements Initializable {

    @FXML
    private ImageView imgGasState;
    @FXML
    private ImageView imgGasOnoff;

    private boolean gasState;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgGasOnoff.setOnMouseClicked(e -> handleGasOnOff(e));
    }

    private void handleGasOnOff(MouseEvent e) {
        if (gasState) {
//            imgGasState.setImage(new Image(getClass().getResource("controlImg/gason.png").toString()));
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_on.png").toString()));
        } else {
//            imgGasState.setImage(new Image(getClass().getResource("controlImg/gasoff.png").toString()));
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_off.png").toString()));
        }
        gasState = !gasState;
    }

}

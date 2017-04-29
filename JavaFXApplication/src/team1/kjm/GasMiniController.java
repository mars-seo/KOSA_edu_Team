package team1.kjm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GasMiniController implements Initializable {

    @FXML
    private ImageView imgGasState;
    @FXML
    private ImageView imgGasOnoff;
    @FXML
    private Label lblGasState;

    private boolean gasState;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgGasOnoff.setOnMouseClicked(e -> handleGasOnOff(e));
    }

    private void handleGasOnOff(MouseEvent e) {
        if (gasState) {
            imgGasState.setImage(new Image(getClass().getResource("images/gason.png").toString()));
            imgGasOnoff.setImage(new Image(getClass().getResource("images/on1.png").toString()));
            lblGasState.setText("가스 밸브가 열려있습니다.");
        } else {
            imgGasState.setImage(new Image(getClass().getResource("images/gasoff.png").toString()));
            imgGasOnoff.setImage(new Image(getClass().getResource("images/off1.png").toString()));
            lblGasState.setText("가스 밸브가 닫혀있습니다.");
        }
        gasState = !gasState;
    }

}

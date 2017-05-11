package team1.Homvis.elecNgas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GasContController implements Initializable {

    @FXML
    private ImageView imgGasState;
    @FXML
    private ImageView imgGasOnoff;

    private boolean gasState = true;
    
    public static Label lblGasState = new Label("");

    public boolean isGasState() {
        return gasState;
    }

    public void setGasState(boolean gasState) {
        this.gasState = gasState;
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblGasState.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.equals("on")) {
                    imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_on.png").toString()));
                    setGasState(true);      
                } else {
                    imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_off.png").toString()));
                    setGasState(false);      
                }                
                System.out.println("Gas: " + isGasState());                          
            }            
        });
        imgGasOnoff.setOnMouseClicked(e -> handleGasOnOff(e));        
    }

    private void handleGasOnOff(MouseEvent e) {
        if (!isGasState()) {
//            imgGasState.setImage(new Image(getClass().getResource("controlImg/gason.png").toString()));
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_on.png").toString()));
            lblGasState.setText("on");
        } else {
//            imgGasState.setImage(new Image(getClass().getResource("controlImg/gasoff.png").toString()));
            imgGasOnoff.setImage(new Image(getClass().getResource("controlImg/elecNgas_gas_off.png").toString()));
            lblGasState.setText("off");
        }
    }
}


package team1.Homvis.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class BoilerController implements Initializable {

    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane boilerRoot;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exit.setOnMouseClicked(event->exit());
    }    

    private void exit() {
        Root1Controller.menuicon2.setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
        Root1Controller.stackPane.getChildren().remove(boilerRoot);
   /*     boilerRoot.setOpacity(1);
        boilerRoot.setTranslateX(0);
        KeyValue keyValue = new KeyValue(boilerRoot.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                (event) -> {
                    Root1Controller.stackPane.getChildren().remove(boilerRoot);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        Root1Controller.menuicon2.setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
*/
        
    }
    
}

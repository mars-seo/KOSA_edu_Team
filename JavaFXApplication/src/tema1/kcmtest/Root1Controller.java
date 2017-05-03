package tema1.kcmtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Root1Controller implements Initializable {

    @FXML
    private ImageView main;
    public static StackPane rootPane;
    @FXML
    private StackPane stackpane;
    private static int count = -1;
    private static Parent icon;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = stackpane;

        main.setOnMouseClicked(event -> {
            count = count *(-1);
            if (count == 1) {
                open();
            } else {
                close();
            }
        });
        
    }

    private void open() {
        System.out.println("open");
        try {
            icon = FXMLLoader.load(getClass().getResource("icon.fxml"));

            stackpane.getChildren().add(icon);
            icon.setTranslateY(500);
            KeyValue keyValue = new KeyValue(icon.translateYProperty(), 200);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void close() {
        System.out.println("close");
        
      // Parent icon=stackpane.getChildren().get(icon);

        KeyValue keyValue = new KeyValue(icon.translateYProperty(),500);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                (event) -> {
                    rootPane.getChildren().remove(icon);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

}

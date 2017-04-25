package team1.kjm;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController implements Initializable {

    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView2;
    @FXML
    private ImageView imgView3;
    
    
    private static StackPane rootPane;
    
    @FXML
    private StackPane stackPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = stackPane;
        imgView1.setOnMouseClicked(e -> handleBtn1(e));
        imgView2.setOnMouseClicked(e -> handleBtn2(e));
    }

    private void handleBtn1(MouseEvent e) {
        System.out.println("1");
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("menu1.fxml"));
            // login.fxml 이 올라오는데 stackPane위에 BorderPane이 올라옴
            
            stackPane.getChildren().add(parent);
            // x좌표를 이동시켜서 스택패인에서는 보이지 않게 됨
            parent.setTranslateX(800);
            // parent.translateXProperty() 을 0까지             
            KeyValue keyValue = new KeyValue(parent.translateXProperty(), 0);
            // 0.1초간 진행
            KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
            // 아래 두개를 쌍으로

            Timeline timeline = new Timeline();
            // 애니메이션을 여러개 정의해 놓고 진행 가능
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtn2(MouseEvent e) {
        System.out.println("2");
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("menu2.fxml"));
            // login.fxml 이 올라오는데 stackPane위에 BorderPane이 올라옴
            
            stackPane.getChildren().add(parent);
            // x좌표를 이동시켜서 스택패인에서는 보이지 않게 됨
            parent.setTranslateX(800);
            // parent.translateXProperty() 을 0까지             
            KeyValue keyValue = new KeyValue(parent.translateXProperty(), 0);
            // 0.1초간 진행
            KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
            // 아래 두개를 쌍으로

            Timeline timeline = new Timeline();
            // 애니메이션을 여러개 정의해 놓고 진행 가능
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

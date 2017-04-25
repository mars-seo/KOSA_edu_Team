package team1.kcm;

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

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		rootPane=stackpane;
		
		main.setOnMouseClicked(event->open());
	//	main.setOnMousePressed(event->open());
	}	

	private void open() {
		System.out.println("ㅋㅋ");
			try {
						Parent parent = FXMLLoader.load(getClass().getResource("icon.fxml"));
						stackpane.getChildren().add(parent); 
						parent.setTranslateY(10000);
						KeyValue keyValue = new KeyValue(parent.translateYProperty(),300);
						KeyFrame keyFrame = new KeyFrame(Duration.millis(2000),keyValue); 
						Timeline timeline = new Timeline();
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
	}

}

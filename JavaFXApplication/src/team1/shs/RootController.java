package team1.shs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class RootController implements Initializable {

	@FXML
	private ImageView img1;
	@FXML
	private ImageView img2;
	@FXML
	private ImageView img3;
	@FXML
	private ImageView img4;
	@FXML
	private ImageView img5;
	@FXML
	private ImageView img6;
	@FXML
	private ImageView img7;
	@FXML
	private ImageView img8;
	@FXML
	private ImageView img9;


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		img1.setOnMouseClicked(e->handleimg(e, img1));
		img1.setOnMouseExited(e->handelimg(e, img1));
		img2.setOnMouseClicked(e->handleimg(e, img2));
		img3.setOnMouseMoved(e->handleimg(e, img3));
		img4.setOnMouseMoved(e->handleimg(e, img4));
		img5.setOnMouseMoved(e->handleimg(e, img5));
		img6.setOnMouseMoved(e->handleimg(e, img6));
		img7.setOnMouseMoved(e->handleimg(e, img7));
		img8.setOnMouseMoved(e->handleimg(e, img8));
		img9.setOnMouseMoved(e->handleimg(e, img9));
	}	

	private void handleimg(MouseEvent e, ImageView img) {
			
			KeyValue keyValue = new KeyValue(img.translateYProperty(), -20);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
			Timeline timeline = new Timeline();
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
	
	}

	private void handelimg(MouseEvent e, ImageView img) {
		
			KeyValue keyValue = new KeyValue(img.translateYProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(200), keyValue);
			Timeline timeline = new Timeline();
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
			img.setTranslateY(0);
	}

	
	
}

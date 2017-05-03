package team1.Homvis.newMain;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class Root2Controller implements Initializable {

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
		img2.setOnMouseExited(e->handelimg(e, img2));
		img3.setOnMouseClicked(e->handleimg(e, img3));
		img3.setOnMouseExited(e->handelimg(e, img3));
		img4.setOnMouseClicked(e->handleimg(e, img4));
		img4.setOnMouseExited(e->handelimg(e, img4));
		img5.setOnMouseClicked(e->handleimg(e, img5));
		img5.setOnMouseExited(e->handelimg(e, img5));
		img6.setOnMouseClicked(e->handleimg(e, img6));
		img6.setOnMouseExited(e->handelimg(e, img6));
		img7.setOnMouseClicked(e->handleimg(e, img7));
		img7.setOnMouseExited(e->handelimg(e, img7));
		img8.setOnMouseClicked(e->handleimg(e, img8));
		img8.setOnMouseExited(e->handelimg(e, img8));
		img9.setOnMouseClicked(e->handleimg(e, img9));
		img9.setOnMouseExited(e->handelimg(e, img9));
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
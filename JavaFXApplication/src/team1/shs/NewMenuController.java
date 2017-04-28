package team1.shs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class NewMenuController implements Initializable {

	@FXML
	private ImageView menu1;
	@FXML
	private ImageView menu2;
	@FXML
	private ImageView menu3;
	@FXML
	private ImageView menu4;
	@FXML
	private ImageView menu5;
	@FXML
	private ImageView menu6;
	@FXML
	private ImageView menuBtn;

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		menuBtn.setOnMouseClicked(e->handleMenu());
	}	

	private void handleMenu() {
		KeyValue key1 = new KeyValue(menu1.translateXProperty(),-150);
		KeyFrame keyFrame1 = new KeyFrame(Duration.millis(100), key1);
		
		KeyValue key2_1 = new KeyValue(menu2.translateXProperty(),-120);
		KeyValue key2_2 = new KeyValue(menu2.translateYProperty(),-80);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(120), key2_1, key2_2);
		
		KeyValue key3_1 = new KeyValue(menu3.translateXProperty(),-50);
		KeyValue key3_2 = new KeyValue(menu3.translateYProperty(),-120);
		KeyFrame keyFrame3 = new KeyFrame(Duration.millis(140), key3_1, key3_2);
		
		KeyValue key4_1 = new KeyValue(menu4.translateXProperty(),50);
		KeyValue key4_2 = new KeyValue(menu4.translateYProperty(),-120);
		KeyFrame keyFrame4 = new KeyFrame(Duration.millis(160), key4_1, key4_2);
		
		KeyValue key5_1 = new KeyValue(menu5.translateXProperty(),120);
		KeyValue key5_2 = new KeyValue(menu5.translateYProperty(),-80);
		KeyFrame keyFrame5 = new KeyFrame(Duration.millis(180), key5_1, key5_2);
		
		KeyValue key6 = new KeyValue(menu6.translateXProperty(),150);
		KeyFrame keyFrame6 = new KeyFrame(Duration.millis(200), key6);
		
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame1);
		timeline.getKeyFrames().add(keyFrame2);
		timeline.getKeyFrames().add(keyFrame3);
		timeline.getKeyFrames().add(keyFrame4);
		timeline.getKeyFrames().add(keyFrame5);
		timeline.getKeyFrames().add(keyFrame6);
		
		timeline.play();
		menuBtn.setOnMouseClicked(e->handleMenu2());
	}

	private void handleMenu2() {
		KeyValue key1 = new KeyValue(menu1.translateXProperty(),0);
		KeyFrame keyFrame1 = new KeyFrame(Duration.millis(200), key1);
		
		KeyValue key2_1 = new KeyValue(menu2.translateXProperty(),0);
		KeyValue key2_2 = new KeyValue(menu2.translateYProperty(),0);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(180), key2_1, key2_2);
		
		KeyValue key3_1 = new KeyValue(menu3.translateXProperty(),0);
		KeyValue key3_2 = new KeyValue(menu3.translateYProperty(),0);
		KeyFrame keyFrame3 = new KeyFrame(Duration.millis(160), key3_1, key3_2);
		
		KeyValue key4_1 = new KeyValue(menu4.translateXProperty(),0);
		KeyValue key4_2 = new KeyValue(menu4.translateYProperty(),0);
		KeyFrame keyFrame4 = new KeyFrame(Duration.millis(140), key4_1, key4_2);
		
		KeyValue key5_1 = new KeyValue(menu5.translateXProperty(),0);
		KeyValue key5_2 = new KeyValue(menu5.translateYProperty(),0);
		KeyFrame keyFrame5 = new KeyFrame(Duration.millis(120), key5_1, key5_2);
		
		KeyValue key6 = new KeyValue(menu6.translateXProperty(),0);
		KeyFrame keyFrame6 = new KeyFrame(Duration.millis(100), key6);
		
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame6);
		timeline.getKeyFrames().add(keyFrame5);
		timeline.getKeyFrames().add(keyFrame4);
		timeline.getKeyFrames().add(keyFrame3);
		timeline.getKeyFrames().add(keyFrame2);
		timeline.getKeyFrames().add(keyFrame1);
		
		timeline.play();
		menuBtn.setOnMouseClicked(e->handleMenu());
	}
	
}

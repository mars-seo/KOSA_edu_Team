package team1.shs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
	@FXML
	private StackPane stackPane;

//	private Parent parent[] = new Parent[1];
//	
//	NewMenuController() throws IOException{
//		parent[0] = FXMLLoader.load(getClass().getResource("interPhone.fxml"));
//	}
	private double[] x = {-150, -120, -50};
	private double[] y = {-80, -120};

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		menuBtn.setOnMouseClicked(e -> handleMainMenu());
		menu1.setOnMouseMoved(e -> handleMenuAction(menu1));
		menu2.setOnMouseMoved(e -> handleMenuAction(menu2));
		menu3.setOnMouseMoved(e -> handleMenuAction(menu3));
		menu4.setOnMouseMoved(e -> handleMenuAction(menu4));
		menu5.setOnMouseMoved(e -> handleMenuAction(menu5));
		menu6.setOnMouseMoved(e -> handleMenuAction(menu6));

		menu2.setOnMouseClicked(e -> handlesubMenu2(menu2));

	}

	private void handleMainMenu() {
		KeyValue key1 = new KeyValue(menu1.translateXProperty(), x[0]);
		KeyFrame keyFrame1 = new KeyFrame(Duration.millis(100), key1);

		KeyValue key2_1 = new KeyValue(menu2.translateXProperty(), x[1]);
		KeyValue key2_2 = new KeyValue(menu2.translateYProperty(), y[0]);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(120), key2_1, key2_2);

		KeyValue key3_1 = new KeyValue(menu3.translateXProperty(), x[2]);
		KeyValue key3_2 = new KeyValue(menu3.translateYProperty(), y[1]);
		KeyFrame keyFrame3 = new KeyFrame(Duration.millis(140), key3_1, key3_2);

		KeyValue key4_1 = new KeyValue(menu4.translateXProperty(), -x[2]);
		KeyValue key4_2 = new KeyValue(menu4.translateYProperty(), y[1]);
		KeyFrame keyFrame4 = new KeyFrame(Duration.millis(160), key4_1, key4_2);

		KeyValue key5_1 = new KeyValue(menu5.translateXProperty(), -x[1]);
		KeyValue key5_2 = new KeyValue(menu5.translateYProperty(), y[0]);
		KeyFrame keyFrame5 = new KeyFrame(Duration.millis(180), key5_1, key5_2);

		KeyValue key6 = new KeyValue(menu6.translateXProperty(), -x[0]);
		KeyFrame keyFrame6 = new KeyFrame(Duration.millis(200), key6);

		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame1);
		timeline.getKeyFrames().add(keyFrame2);
		timeline.getKeyFrames().add(keyFrame3);
		timeline.getKeyFrames().add(keyFrame4);
		timeline.getKeyFrames().add(keyFrame5);
		timeline.getKeyFrames().add(keyFrame6);

		timeline.play();
		menuBtn.setOnMouseClicked(e -> handleMainMenu2());
	}

	private void handleMainMenu2() {
		KeyValue key1 = new KeyValue(menu1.translateXProperty(), 0);
		KeyFrame keyFrame1 = new KeyFrame(Duration.millis(200), key1);

		KeyValue key2_1 = new KeyValue(menu2.translateXProperty(), 0);
		KeyValue key2_2 = new KeyValue(menu2.translateYProperty(), 0);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(180), key2_1, key2_2);

		KeyValue key3_1 = new KeyValue(menu3.translateXProperty(), 0);
		KeyValue key3_2 = new KeyValue(menu3.translateYProperty(), 0);
		KeyFrame keyFrame3 = new KeyFrame(Duration.millis(160), key3_1, key3_2);

		KeyValue key4_1 = new KeyValue(menu4.translateXProperty(), 0);
		KeyValue key4_2 = new KeyValue(menu4.translateYProperty(), 0);
		KeyFrame keyFrame4 = new KeyFrame(Duration.millis(140), key4_1, key4_2);

		KeyValue key5_1 = new KeyValue(menu5.translateXProperty(), 0);
		KeyValue key5_2 = new KeyValue(menu5.translateYProperty(), 0);
		KeyFrame keyFrame5 = new KeyFrame(Duration.millis(120), key5_1, key5_2);

		KeyValue key6 = new KeyValue(menu6.translateXProperty(), 0);
		KeyFrame keyFrame6 = new KeyFrame(Duration.millis(100), key6);

		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame6);
		timeline.getKeyFrames().add(keyFrame5);
		timeline.getKeyFrames().add(keyFrame4);
		timeline.getKeyFrames().add(keyFrame3);
		timeline.getKeyFrames().add(keyFrame2);
		timeline.getKeyFrames().add(keyFrame1);

		timeline.play();
		menuBtn.setOnMouseClicked(e -> handleMainMenu());
	}

	private void handleMenuAction(ImageView img) {

		KeyValue keyX1 = new KeyValue(img.translateXProperty(), 0);
		KeyValue keyY1 = new KeyValue(img.translateYProperty(), 0);
		KeyValue keyX2 = new KeyValue(menuBtn.translateXProperty(), 0);
		KeyValue keyY2 = new KeyValue(menuBtn.translateYProperty(), 0);

		if (img == menu1) {
			keyX2 = new KeyValue(img.translateXProperty(), x[0]);
			keyY2 = new KeyValue(img.translateYProperty(), 0);

		} else if (img == menu2) {

			keyX2 = new KeyValue(img.translateXProperty(), x[1]);
			keyY2 = new KeyValue(img.translateYProperty(), y[0]);

		} else if (img == menu3) {

			keyX2 = new KeyValue(img.translateXProperty(), x[2]);
			keyY2 = new KeyValue(img.translateYProperty(), y[1]);

		} else if (img == menu4) {

			keyX2 = new KeyValue(img.translateXProperty(), -x[2]);
			keyY2 = new KeyValue(img.translateYProperty(), y[1]);

		} else if (img == menu5) {

			keyX2 = new KeyValue(img.translateXProperty(), -x[1]);
			keyY2 = new KeyValue(img.translateYProperty(), y[0]);

		} else if (img == menu6) {

			keyX2 = new KeyValue(img.translateXProperty(), -x[0]);
			keyY2 = new KeyValue(img.translateYProperty(), 0);

		}

		KeyFrame keyFrame1 = new KeyFrame(Duration.millis(5), keyX1, keyY1);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(10), keyX2, keyY2);

		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame2);
		timeline.getKeyFrames().add(keyFrame1);
		timeline.play();

	}

	private void handlesubMenu2(ImageView img) {
		KeyValue keyX1 = new KeyValue(img.translateXProperty(), 0);
		KeyValue keyY1 = new KeyValue(img.translateYProperty(), 0);

		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("interPhone.fxml"));
			stackPane.getChildren().add(parent);
			
			KeyValue key = new KeyValue(parent.translateYProperty(), 480);

			KeyFrame keyFrame1 = new KeyFrame(Duration.millis(50), keyX1, keyY1);
			KeyFrame keyFrame2 = new KeyFrame(Duration.millis(300), key);

			Timeline timeline = new Timeline();
			timeline.getKeyFrames().add(keyFrame2);
			timeline.getKeyFrames().add(keyFrame1);

		} catch (IOException ex) {
			Logger.getLogger(NewMenuController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}

package team1.Homvis.tariff;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import team1.Homvis.MainController;

public class RootMiniController implements Initializable {

	@FXML
	private ImageView btnGasFee;
	@FXML
	private ImageView btnElectricFee;
	@FXML
	private ImageView btnWaterFee;
	private List<Parent> parent = new ArrayList<>();
	private static StackPane rootPane;
	@FXML
	private StackPane changeableStackPane;
	@FXML
	private ImageView exit;
	@FXML
	private StackPane tariffRoot;
	@FXML
	private ImageView maximize;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		rootPane = changeableStackPane;

		btnGasFee.setOnMouseClicked((event) -> {
			handlerBtn(event, 0);
		});
		btnElectricFee.setOnMouseClicked((event) -> {
			handlerBtn(event, 1);
		});
		btnWaterFee.setOnMouseClicked((event) -> {
			handlerBtn(event, 2);
		});
		btnGasFee.setOnMousePressed((event) -> {
			handlerBtnPressed(event, 0);
		});
		btnElectricFee.setOnMousePressed((event) -> {
			handlerBtnPressed(event, 1);
		});
		btnWaterFee.setOnMousePressed((event) -> {
			handlerBtnPressed(event, 2);
		});

		exit.setOnMouseClicked(e -> exit());
		maximize.setOnMouseClicked(e -> maximizeScreen());

	}

	public RootMiniController() {
		try {
			this.parent.add(FXMLLoader.load(getClass().getResource("gasMini.fxml")));
			this.parent.add(FXMLLoader.load(getClass().getResource("electricMini.fxml")));
			this.parent.add(FXMLLoader.load(getClass().getResource("waterMini.fxml")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	private void handlerBtn(MouseEvent e, int num) {
		rootPane.getChildren().clear();
		changeableStackPane.getChildren().add(parent.get(num));
		translateX(num);

		if (num == 0) {
			btnGasFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_gas_clicked.png").toString()));
			btnElectricFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_lighticon_off.png").toString()));
			btnWaterFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_water_default.png").toString()));
		} else if (num == 1) {
			btnGasFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_gas_default.png").toString()));
			btnElectricFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_lighticon_on.png").toString()));
			btnWaterFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_water_default.png").toString()));
		} else if (num == 2) {
			btnGasFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_gas_default.png").toString()));
			btnElectricFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_lighticon_off.png").toString()));
			btnWaterFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_water_clicked.png").toString()));
		}

	}

	private void handlerBtnPressed(MouseEvent e, int num) {
		if (num == 0) {
			btnGasFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_gas_clicked.png").toString()));
		} else if (num == 1) {
			btnElectricFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_lighticon_on.png").toString()));
		} else if (num == 2) {
			btnWaterFee.setImage(new Image(getClass().getResource("tariffImg/elecNgas_water_clicked.png").toString()));
		}
	}

	private void translateX(int num) {
		parent.get(num).setTranslateX(840);
		KeyValue keyValue = new KeyValue(parent.get(num).translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

	private void exit() {
		MainController.menuicon[6].setImage(new Image(getClass().getResource("tariffImg/main_tariff_default.png").toString()));
		MainController.stackPane.getChildren().remove(tariffRoot);
	}

	private void maximizeScreen() {
		try {
			if (MainController.veiw[6] == null) {
				Parent view = FXMLLoader.load(getClass().getResource(MainController.menuList.get(6) + ".fxml"));
				MainController.stackPane.getChildren().add(view);
			}
			
			MainController.stackPane.getChildren().remove(tariffRoot);
		} catch (IOException ex) {
			Logger.getLogger(RootMiniController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

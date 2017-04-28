package team1.jdj;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RootController implements Initializable {

	@FXML
	private StackPane stackPane;
	@FXML
	private Button btnGasFee;
	@FXML
	private Button btnElectricFee;
	@FXML
	private Button btnWaterFee;
	
	private static StackPane rootPane;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnGasFee.setOnAction((event) -> {
			handlerBtnGasFee(event);
		});
		btnElectricFee.setOnAction((event) -> {
			handlerBtnElectricFee(event);
		});
		btnWaterFee.setOnAction((event) -> {
			handlerBtnWaterFee(event);
		});
	}

	public RootController() {

	}

	private void handlerBtnGasFee(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
			Scene scene = new Scene(parent);
			Stage primaryStage = (Stage) btnGasFee.getScene().getWindow();
			primaryStage.setScene(scene);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void handlerBtnElectricFee(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
			Scene scene = new Scene(parent);
			Stage primaryStage = (Stage) btnElectricFee.getScene().getWindow();
			primaryStage.setScene(scene);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void handlerBtnWaterFee(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
			Scene scene = new Scene(parent);
			Stage primaryStage = (Stage) btnWaterFee.getScene().getWindow();
			primaryStage.setScene(scene);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}

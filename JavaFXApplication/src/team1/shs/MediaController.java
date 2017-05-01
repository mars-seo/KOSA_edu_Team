package team1.shs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;


public class MediaController implements Initializable {

	@FXML
	private Button previousBtn;
	@FXML
	private Button pauseBtn;
	@FXML
	private Button playBtn;
	@FXML
	private Button stopBtn;
	@FXML
	private Button nextBtn;
	@FXML
	private Button uploadBtn;
	@FXML
	private ImageView imgSound;
	@FXML
	private Slider volumeSlider;
	@FXML
	private MediaView media;
	@FXML
	private Slider mediaSlider;
	@FXML
	private Label playTime;
	@FXML
	private ListView<?> mediaLIst;


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}	
	
}

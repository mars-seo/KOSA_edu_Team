package team1.shs;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;


public class MiniMediaController implements Initializable {

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
	private Slider mediaSlider;
	@FXML
	private Label playTime;
	@FXML
	private MediaView mediaView;
	@FXML
	private ListView<String> mediaList;

	private ObservableList<String> nameList;
	private ObservableList<File> mediaFileList;
	private boolean mute;
	private double volume;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}	
	
}

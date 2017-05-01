package team1.shs;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


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
	private ListView<String> mediaList;
	
	private ObservableList<String> nameList;
	private ObservableList<File> mediaFileList;



	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	
		uploadBtn.setOnAction(e->handleAddList(e));
		
		//파일이 비었을 때 처리 하는 작업
		if(mediaFileList.isEmpty()){
			//팝업을 띄어주는 작업 (지금은 그냥 콘솔에)
			System.out.println("미디어 파일을 업로드 해주세요");
		}else{
			handleMedia(mediaFileList.get(0));
		}
	}	

	private void handleAddList(ActionEvent e) {
		//파일을 확장자 필터로 걸러서 받고 객체로 받기
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
			new ExtensionFilter("video files", "*.mp4"),
			new ExtensionFilter("video files", "*.avi"),
			new ExtensionFilter("video files", "*.mkv"),
			new ExtensionFilter("video files", "*.m4v"),
			new ExtensionFilter("music files", "*.wav"),
			new ExtensionFilter("music files", "*.mp3"),
			new ExtensionFilter("music files", "*.wmv")
		);
		File media = fileChooser.showOpenDialog(((Button)e.getSource()).getScene().getWindow());
		//받은 파일을 파일 리스트에 넣기
		mediaFileList.add(media);
		//미디어의 이름을 얻어 리스트뷰에 넣어줌
		String mediaName = media.getName();
		nameList.add(mediaName);
		mediaList.setItems(nameList);
		
	}

	private void handleMedia(File media) {
		
	}

	
}

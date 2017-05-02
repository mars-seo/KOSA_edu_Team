package team1.shs;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;


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
	private Slider mediaSlider;
	@FXML
	private Label playTime;
	@FXML
	private MediaView mediaView;
	@FXML
	private ListView<String> mediaList;
	
	private ObservableList<String> nameList = FXCollections.observableArrayList();
	private ObservableList<File> mediaFileList = FXCollections.observableArrayList();
	private boolean mute;
	private double volume;
	private Media playMedia;
	private MediaPlayer mediaPlayer;
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		uploadBtn.setOnAction(e->handleAddList(e));
		handleMedia(mediaFileList, 0);
	}	
	private void handleAddList(ActionEvent e) {
		
		if(mediaFileList.isEmpty() || nameList.isEmpty()){
			System.out.println("파일을 넣읍시다.");
		}
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
			File mediaFile = fileChooser.showOpenDialog(((Button)e.getSource()).getScene().getWindow());
			//받은 파일을 파일 리스트에 넣기
			mediaFileList.add(mediaFile);
			//미디어의 이름을 얻어 리스트뷰에 넣어줌
			String mediaName = mediaFile.getName();
			nameList.add(mediaName);
			mediaList.setItems(nameList);
	}

	private void handleMedia(ObservableList<File> mediaFile, int index) {
		
		//파일이 비었을 때 처리 하는 작업
		if(mediaFileList.isEmpty() || nameList.isEmpty()){
			//팝업을 띄어주는 작업 (지금은 그냥 콘솔에)
			System.out.println("미디어 파일을 업로드 해주세요");
			return ;
			
		}else{
				
			playMedia = new Media(mediaFile.get(index).getPath());
			mediaPlayer = new MediaPlayer(playMedia);
			mediaView.setMediaPlayer(mediaPlayer);

			mediaPlayer.setOnReady(()->{
				playBtn.setDisable(false);
				pauseBtn.setDisable(true);
				stopBtn.setDisable(true);
			});
			mediaPlayer.setOnPlaying(()->{
				playBtn.setDisable(true);
				pauseBtn.setDisable(false);
				stopBtn.setDisable(false);
			});
			mediaPlayer.setOnPaused(()->{
				playBtn.setDisable(false);
				pauseBtn.setDisable(true);
				stopBtn.setDisable(false);
			});
			mediaPlayer.setOnStopped(()->{
				playBtn.setDisable(false);
				pauseBtn.setDisable(true);
				stopBtn.setDisable(true);
			});
			mediaPlayer.setOnEndOfMedia(()->{

			});

			playBtn.setOnAction(e->mediaPlayer.play());
			pauseBtn.setOnAction(e->{
				mediaPlayer.pause();
			});
			stopBtn.setOnAction(e->{
//				if(mediaPlayer!=null){
					mediaPlayer.stop();
//				}else System.out.println("파일을 업로드 하세요");
			});
			nextBtn.setOnAction(e->handleMedia(mediaFileList, index+1));
			previousBtn.setOnAction(e->handleMedia(mediaFileList, index-1));

			volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					mediaPlayer.setVolume(newValue.doubleValue()/100.0);
					volume = newValue.doubleValue();
					mute = false;
					imgSound.setImage(new Image(getClass().getResource("images/speaker.png").toString()));
				}
			});

			imgSound.setOnMouseClicked(e->{
				if(!mute){
					volumeSlider.setValue(0);
					imgSound.setImage(new Image(getClass().getResource("images/mute.png").toString()));
				}else{
					volumeSlider.setValue(volume);
					imgSound.setImage(new Image(getClass().getResource("images/speaker.png").toString()));
				}
			});
			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration> () {
				@Override
				public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
					double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds() ;
					int currentPlay = (int)newValue.toSeconds();
					// 미디어 플레이어의 시간을 라벨에 세팅
					int[] time = new int[3];
					time[0] = currentPlay % 60;
					time[1] = (currentPlay % 60) % 60;
					time[2] = (currentPlay % (60*60))%60;
					//문자열 타입으로 전환
					String[] strPlay = new String[3];
					strPlay[0] = String.valueOf(time[0] < 10 ? "0" + time[0] : time[0]);
					strPlay[1] = String.valueOf(time[1] < 10 ? "0" + time[1] : time[1]);
					strPlay[2] = String.valueOf(time[2] < 10 ? "0" + time[2] : time[2]);

					playTime.setText(strPlay[2]+":"+strPlay[1]+":"+strPlay[0]);

					mediaSlider.setValue(progress*100);
				}
			});
			mediaSlider.valueProperty().addListener(new ChangeListener<Number> () {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					// 미디어 전체 시간
					double total = mediaPlayer.getTotalDuration().toSeconds();
					// 미디어 슬라이더의 현재 값
					double curSlider = newValue.doubleValue();
					// 이전 값
					double preSlider = oldValue.doubleValue();
					//현재 내가 찾아야하는 시간
					Duration curTime = Duration.seconds((total/curSlider)/100.0);
					
					// 미디어 재생 시간에 따른 값을 조정하기 위한 값
					double std = 1/total;

					//미디어 슬라이더가 값이 변경될 때만 시간을 찾음
	//				if(mediaSlider.isValueChanging()){
	//					mediaPlayer.seek(curTime);
	//				}else{
						//이전슬라이더 값과 현재 찾으려는 슬라이더의 값의 차이가 미세할 때 제외
						if(Math.abs(preSlider-curSlider)>std){
							mediaPlayer.seek(curTime);
						}
	//				}
				}
			});
		}
	}
	
	
}

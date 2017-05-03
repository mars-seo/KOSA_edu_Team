package team1.shs;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Popup;
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
	@FXML
	private Button deleteBtn;
	
	private ObservableList<String> nameList = FXCollections.observableArrayList();
	private ObservableList<File> mediaFileList = FXCollections.observableArrayList();
	private boolean mute;
	private double volume;
	private Media playMedia;
	private MediaPlayer mediaPlayer;
	private int index;
	
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		uploadBtn.setOnAction(e->handleAddList(e));	
		playBtn.setOnAction(e->fileCheck(e));
		pauseBtn.setOnAction(e->fileCheck(e));
		stopBtn.setOnAction(e->fileCheck(e));
		nextBtn.setOnAction(e->fileCheck(e));
		previousBtn.setOnAction(e->fileCheck(e));
		
		// listView 속성 감시하여 시작
		mediaList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                mediaPlayer.stop();
                System.out.println(newValue);
                handleMedia(mediaFileList, nameList.indexOf(newValue));
                mediaPlayer.play();
            }
        });
		deleteBtn.setOnAction(e->handleDelete());
	}	
	private void handleAddList(ActionEvent e) {
		
		//파일을 확장자 필터로 걸러서 받고 객체로 받기
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
			new ExtensionFilter("media files", "*.mp4","*.avi","*.mkv","*.m4v","*.wav","*.mp3","*.wmv")
		);
		File mediaFile = fileChooser.showOpenDialog(((Button)e.getSource()).getScene().getWindow());
		if(mediaFile!=null){
			//받은 파일을 파일 리스트에 넣기
			mediaFileList.add(mediaFile);
			//미디어의 이름을 얻어 리스트뷰에 넣어줌
			String mediaName = mediaFile.getName();
			nameList.add(mediaName);
			mediaList.setItems(nameList);
			handleMedia(mediaFileList, index);
			index+=1;
		}else fileChooserCheck(e);
		
	}

	private void handleMedia(ObservableList<File> mediaFileList, int index) {
			System.out.println(mediaFileList.get(index).toURI().toString());
			playMedia = new Media(mediaFileList.get(index).toURI().toString());
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
			pauseBtn.setOnAction(e->mediaPlayer.pause());
			stopBtn.setOnAction(e->mediaPlayer.stop());
			nextBtn.setOnAction(e->handleMedia(mediaFileList, index+1));
			previousBtn.setOnAction(e->handleMedia(mediaFileList, index-1));
			
			//실행시 처음 볼륨값과 이미지 세팅
			volumeSlider.setValue(50);
			imgSound.setImage(new Image(getClass().getResource("images/speaker.png").toString()));
			
			//슬라이더 속성감시로 볼륨의 크기 세팅
			volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					mediaPlayer.setVolume(newValue.doubleValue()/100.0);
					volume = oldValue.doubleValue(); // 음소거 해제 시 전 설정값 세팅
					imgSound.setImage(new Image(getClass().getResource("images/speaker.png").toString()));
				}
			});
			//음소거와 음소거 해제를 이미지 클릭으로 설정
			imgSound.setOnMouseClicked(e->{
				if(!mute){
					volumeSlider.setValue(0);
					imgSound.setImage(new Image(getClass().getResource("images/mute.png").toString()));
				}else{
					volumeSlider.setValue(volume);
					imgSound.setImage(new Image(getClass().getResource("images/speaker.png").toString()));
				}
				mute = !mute;
			});
			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration> () {
				@Override
				public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
					double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds() ;
					int currentPlay = (int)newValue.toSeconds();
					// 미디어 플레이어의 시간을 라벨에 세팅
					int[] time = new int[3];
					time[0] = currentPlay % 60;
					time[1] = (currentPlay / 60);
					time[2] = currentPlay / (60*60);
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
					Duration curTime = Duration.seconds(total*curSlider/100);

					// 미디어 재생 시간에 따른 값을 조정하기 위한 값
					double std = 10/total;

					//미디어 슬라이더가 값이 변경될 때만 시간을 찾음
					if(mediaSlider.isValueChanging()){
						mediaPlayer.seek(curTime);
					}else{
					//이전슬라이더 값과 현재 찾으려는 슬라이더의 값의 차이가 미세할 때 제외
						if(Math.abs(preSlider-curSlider)>std){
							mediaPlayer.seek(curTime);
						}
					}
				}
			});
//		}
	}
	
	// 업로드 하지 않은 상태에서 버튼을 누르면 뜨는 팝업
	private void fileCheck(ActionEvent e) {
		if(mediaPlayer==null) {
			try {
				Popup popup = new Popup();
				HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("mediaPopup.fxml"));
				popup.getContent().add(hbox);
				popup.setAutoHide(true);
				popup.show(((Button)e.getSource()).getScene().getWindow());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}else return;
	}
	
	//파일 업로드를 하지 않거나 취소하면 뜨는 팝업
	private void fileChooserCheck(ActionEvent e) {
		
			try {
				Popup popup = new Popup();
				HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("mediaPopup.fxml"));
				popup.getContent().add(hbox);
				popup.setAutoHide(true);
				popup.show(((Button)e.getSource()).getScene().getWindow());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}

	private void handleDelete() {
		
	}
	
}

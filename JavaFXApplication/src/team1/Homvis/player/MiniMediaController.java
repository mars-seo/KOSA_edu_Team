package team1.Homvis.player;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.util.Duration;
import team1.Homvis.MainController;



public class MiniMediaController implements Initializable {

	@FXML
	private ImageView previousBtn;
	@FXML
	private ImageView pauseBtn;
	@FXML
	private ImageView playBtn;
	@FXML
	private ImageView stopBtn;
	@FXML
	private ImageView nextBtn;
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
	private ImageView deleteBtn;
	@FXML
	private AnchorPane miniMediaRoot;
	@FXML
	private ImageView exit;
	@FXML
	private ImageView maximize;
	

	private boolean mute;
	private double volume;
	private Media playMedia;
	private MediaPlayer mediaPlayer;
	public static PlayerList playList= new PlayerList();
	private String[] imgName = {"play","pause","stop","forward","backward"};
			
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		mediaList.setItems(playList.getFileName());
						
		playBtn.setOnMousePressed(e->playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_clicked.png").toString())));
		pauseBtn.setOnMousePressed(e->pauseBtn.setImage(new Image(getClass().getResource("playerImg/player_pause_clicked.png").toString())));
		stopBtn.setOnMousePressed(e->stopBtn.setImage(new Image(getClass().getResource("playerImg/player_stop_clicked.png").toString())));
		nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
		previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
		playBtn.setOnMouseClicked(e->fileCheck(e, playBtn, 0));
		pauseBtn.setOnMouseClicked(e->fileCheck(e, pauseBtn, 1));
		stopBtn.setOnMouseClicked(e->fileCheck(e, stopBtn, 2));
		nextBtn.setOnMouseClicked(e->fileCheck(e, nextBtn, 3));
		previousBtn.setOnMouseClicked(e->fileCheck(e, previousBtn, 4));
				
		// listView 속성 감시하여 시작
		mediaList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                handleMedia(playList.getMediaFile(), playList.getFileName().indexOf(newValue));
		deleteBtn.setOnMouseClicked(e->handleDelete(e, newValue));
            }
        });
		exit.setOnMousePressed(e->exit.setImage(new Image(getClass().getResource("playerImg/exit_clicked.png").toString())));
		exit.setOnMouseClicked(e->exit());
		maximize.setOnMousePressed(e->maximize.setImage(new Image(getClass().getResource("playerImg/expension_clicked.png").toString())));
		maximize.setOnMouseClicked(e->maximizeScreen());
	}	
	
	private void handleMedia(ObservableList<File> mediaFileList, int index) {
		if(mediaFileList.isEmpty()||MiniMediaController.playList.getFileName().isEmpty()) return;
		else{
			String path = mediaFileList.get(index).toString();
			path = path.replace('\\', '/');
			
			playMedia = new Media(path);
			mediaPlayer = new MediaPlayer(playMedia);
			mediaView.setMediaPlayer(mediaPlayer);
			
			mediaPlayer.setOnReady(()->{
				playBtn.setDisable(false);
				pauseBtn.setDisable(true);
				stopBtn.setDisable(true);
				//버튼화
				playBtn.setOnMousePressed(e->playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_clicked.png").toString())));
				nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
				previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
				
			});
			mediaPlayer.setOnPlaying(()->{
				playBtn.setDisable(true);
				pauseBtn.setDisable(false);
				stopBtn.setDisable(false);
				//버튼화
				pauseBtn.setOnMousePressed(e->pauseBtn.setImage(new Image(getClass().getResource("playerImg/player_pause_clicked.png").toString())));
				stopBtn.setOnMousePressed(e->stopBtn.setImage(new Image(getClass().getResource("playerImg/player_stop_clicked.png").toString())));
				nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
				previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
				
			});
			mediaPlayer.setOnPaused(()->{
				playBtn.setDisable(false);
				pauseBtn.setDisable(true);
				stopBtn.setDisable(false);
				//버튼화
				playBtn.setOnMousePressed(e->playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_clicked.png").toString())));
				stopBtn.setOnMousePressed(e->stopBtn.setImage(new Image(getClass().getResource("playerImg/player_stop_clicked.png").toString())));
				nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
				previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
				
			});
			mediaPlayer.setOnStopped(()->{
				playBtn.setDisable(false);
				pauseBtn.setDisable(true);
				stopBtn.setDisable(true);
				//버튼화
				playBtn.setOnMousePressed(e->playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_clicked.png").toString())));
				nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
				previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
		
			});
			mediaPlayer.setOnEndOfMedia(() -> {
								mediaPlayer.stop();
								int songIndex = index;
								if (songIndex < mediaFileList.size() - 1) {
										handleMedia(mediaFileList, ++songIndex);
										mediaPlayer.play();
								} else {
										handleMedia(mediaFileList, 0);
										mediaPlayer.play();
								}
								nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
								previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
						});
			
			playBtn.setOnMousePressed(e->playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_clicked.png").toString())));
			pauseBtn.setOnMousePressed(e->pauseBtn.setImage(new Image(getClass().getResource("playerImg/player_pause_clicked.png").toString())));
			stopBtn.setOnMousePressed(e->stopBtn.setImage(new Image(getClass().getResource("playerImg/player_stop_clicked.png").toString())));
			nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
			previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
			
			playBtn.setOnMouseClicked(e->{
								mediaPlayer.play();
								playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_default.png").toString()));
					});
			pauseBtn.setOnMouseClicked(e->{
								mediaPlayer.pause();
								pauseBtn.setImage(new Image(getClass().getResource("playerImg/player_pause_default.png").toString()));
					});
			stopBtn.setOnMouseClicked(e->{
								mediaPlayer.stop();
								stopBtn.setImage(new Image(getClass().getResource("playerImg/player_stop_default.png").toString()));
					});
			nextBtn.setOnMouseClicked(e -> {
								mediaPlayer.stop();
								if (index == mediaFileList.size() - 1) {
										handleMedia(mediaFileList, 0);
										mediaPlayer.play();
										nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_default.png").toString()));
								} else {
										handleMedia(mediaFileList, index + 1);
										mediaPlayer.play();
										nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_default.png").toString()));
								}
						});
			previousBtn.setOnMouseClicked(e -> {
								mediaPlayer.stop();
								if (index == 0) {
										handleMedia(mediaFileList, mediaFileList.size() - 1);
										mediaPlayer.play();
										previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_default.png").toString()));
								} else {
										handleMedia(mediaFileList, index - 1);
										mediaPlayer.play();
										previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_default.png").toString()));
								}
						});
			
			//실행시 처음 볼륨값과 이미지 세팅
			volumeSlider.setValue(50);
			imgSound.setImage(new Image(getClass().getResource("playerImg/player_sound_clicked.png").toString()));
			
			//슬라이더 속성감시로 볼륨의 크기 세팅
			volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					mediaPlayer.setVolume(newValue.doubleValue()/100.0);
					volume = oldValue.doubleValue(); // 음소거 해제 시 전 설정값 세팅
					imgSound.setImage(new Image(getClass().getResource("playerImg/player_sound_clicked.png").toString()));
				}
			});
			//음소거와 음소거 해제를 이미지 클릭으로 설정
			imgSound.setOnMouseClicked(e->{
				if(!mute){
					volumeSlider.setValue(0);
					imgSound.setImage(new Image(getClass().getResource("playerImg/player_sound_default.png").toString()));
				}else{
					volumeSlider.setValue(volume);
					imgSound.setImage(new Image(getClass().getResource("playerImg/player_sound_clicked.png").toString()));
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
					time[0] = currentPlay % 60; // 초
					time[1] = (currentPlay / 60) % 60; // 분
					time[2] = (currentPlay / (60*60)) % 60; // 시
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
					double std = 500/total;

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
		}
	}
	
	// 업로드 하지 않은 상태에서 버튼을 누르면 뜨는 팝업
	private void fileCheck(MouseEvent e, ImageView a, int index) {
		if(mediaPlayer==null) {
			try {
				Popup popup = new Popup();
				HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("mediaPopup.fxml"));
				popup.getContent().add(hbox);
				popup.setAutoHide(true);
				popup.show(((ImageView)e.getSource()).getScene().getWindow());
				a.setImage(new Image(getClass().getResource("playerImg/player_"+imgName[index]+"_default.png").toString()));
			} catch (IOException ex) {

			}
		}else return;
	}
	
	
	// 누르면 리스트뷰와 각각의 리스트 객체에서 해당 파일을 지운다.
	private void handleDelete(MouseEvent e, String selectFile) {
		if(MiniMediaController.playList.getFileName().isEmpty()||MiniMediaController.playList.getMediaFile().isEmpty()){
			mediaPlayer.stop();
		}else{
			int delIndex = MiniMediaController.playList.getFileName().indexOf(selectFile);
			MiniMediaController.playList.getFileName().remove(delIndex);
			MiniMediaController.playList.getMediaFile().remove(delIndex);
			mediaList.setItems(MiniMediaController.playList.getFileName());

			
			if(playList.getFileName().isEmpty()||playList.getMediaFile().isEmpty()){
				mediaPlayer.stop();
				mediaPlayer = null;
			}
		}
	}
	private void exit() {
		MainController.menuicon[5].setImage(new Image(getClass().getResource("playerImg/main_player_default.png").toString()));
		MainController.stackPane.getChildren().remove(miniMediaRoot);
		exit.setImage(new Image(getClass().getResource("playerImg/exit_default.png").toString()));
    }

	private void maximizeScreen() {
		try {
			if(MainController.veiw[5]==null) MainController.veiw[5] = FXMLLoader.load(getClass().getResource(MainController.menuList.get(5)+".fxml"));
			MainController.stackPane.getChildren().add(MainController.veiw[5]);
			MainController.stackPane.getChildren().remove(miniMediaRoot);
		} catch (IOException ex) {
			
		}
    }
	
}

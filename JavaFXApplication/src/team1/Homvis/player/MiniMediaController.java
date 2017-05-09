package team1.Homvis.player;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import team1.Homvis.main.MainController;


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
	private ImageView uploadBtn;
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
	private int index;
	public static PlayerList playList= new PlayerList();
	private String[] imgName = {"play","pause","stop","forward","backward"};
			
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		if(!MiniMediaController.playList.getMediaFile().isEmpty()){
			mediaList.setItems(MiniMediaController.playList.getFileName());
			if(MiniMediaController.playList.getCurrentPlay()!=null){
				mediaPlayer = MiniMediaController.playList.getCurrentPlay();
				mediaPlayer.play();
			}
		}
		uploadBtn.setOnMousePressed(e->uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_clicked.png").toString())));
		playBtn.setOnMousePressed(e->playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_clicked.png").toString())));
		pauseBtn.setOnMousePressed(e->pauseBtn.setImage(new Image(getClass().getResource("playerImg/player_pause_clicked.png").toString())));
		stopBtn.setOnMousePressed(e->stopBtn.setImage(new Image(getClass().getResource("playerImg/player_stop_clicked.png").toString())));
		nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
		previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
		uploadBtn.setOnMouseClicked(e->handleAddList(e));
		playBtn.setOnMouseClicked(e->fileCheck(e, playBtn, 0));
		pauseBtn.setOnMouseClicked(e->fileCheck(e, pauseBtn, 1));
		stopBtn.setOnMouseClicked(e->fileCheck(e, stopBtn, 2));
		nextBtn.setOnMouseClicked(e->fileCheck(e, nextBtn, 3));
		previousBtn.setOnMouseClicked(e->fileCheck(e, previousBtn, 4));
		
		// listView 속성 감시하여 시작
		mediaList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                mediaPlayer.stop();
                System.out.println(newValue);
                handleMedia(MiniMediaController.playList.getMediaFile(), MiniMediaController.playList.getFileName().indexOf(newValue));
				deleteBtn.setOnMouseClicked(e->handleDelete(e, newValue));
            }
        });
		exit.setOnMousePressed(e->exit.setImage(new Image(getClass().getResource("playerImg/exit_clicked.png").toString())));
		exit.setOnMouseClicked(e->exit());
		maximize.setOnMousePressed(e->maximize.setImage(new Image(getClass().getResource("playerImg/expension_clicked.png").toString())));
		maximize.setOnMouseClicked(e->maximizeScreen());
	}	
	private void handleAddList(MouseEvent e) {
		
		//파일을 확장자 필터로 걸러서 받고 객체로 받기
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
			new FileChooser.ExtensionFilter("media files", "*.mp4","*.avi","*.mkv","*.m4v","*.wav","*.mp3","*.wmv")
		);
		File mediaFile = fileChooser.showOpenDialog(((ImageView)e.getSource()).getScene().getWindow());
		if(mediaFile!=null){
			//받은 파일을 파일 리스트에 넣기
			MiniMediaController.playList.getMediaFile().add(mediaFile);
			//미디어의 이름을 얻어 리스트뷰에 넣어줌
			String mediaName = mediaFile.getName();
			MiniMediaController.playList.getFileName().add(mediaName);
			mediaList.setItems(MiniMediaController.playList.getFileName());
			if (MiniMediaController.playList.getFileName().size() < 2) {
				handleMedia(MiniMediaController.playList.getMediaFile(), index);
				mediaPlayer.play();
			}
			index += 1;
			uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_default.png").toString()));
		}else fileEmptyCheck(e);
		
	}

	private void handleMedia(ObservableList<File> mediaFileList, int index) {
		if(mediaFileList.isEmpty()||MiniMediaController.playList.getFileName().isEmpty()) return;
		else{
			uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_default.png").toString()));
			playMedia = new Media(mediaFileList.get(index).toURI().toString());
			mediaPlayer = new MediaPlayer(playMedia);
			mediaView.setMediaPlayer(mediaPlayer);
			
			mediaPlayer.setOnReady(()->{
				playBtn.setDisable(false);
				pauseBtn.setDisable(true);
				stopBtn.setDisable(true);
				//버튼화
				uploadBtn.setOnMousePressed(e->uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_clicked.png").toString())));
				playBtn.setOnMousePressed(e->playBtn.setImage(new Image(getClass().getResource("playerImg/player_play_clicked.png").toString())));
				nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
				previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
				
			});
			mediaPlayer.setOnPlaying(()->{
				playBtn.setDisable(true);
				pauseBtn.setDisable(false);
				stopBtn.setDisable(false);
				//버튼화
				uploadBtn.setOnMousePressed(e->uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_clicked.png").toString())));
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
				uploadBtn.setOnMousePressed(e->uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_clicked.png").toString())));
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
				uploadBtn.setOnMousePressed(e->uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_clicked.png").toString())));
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
								uploadBtn.setOnMousePressed(e->uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_clicked.png").toString())));
								nextBtn.setOnMousePressed(e->nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_clicked.png").toString())));
								previousBtn.setOnMousePressed(e->previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_clicked.png").toString())));
						});
			
			uploadBtn.setOnMousePressed(e->uploadBtn.setImage(new Image(getClass().getResource("playerImg/player_load_clicked.png").toString())));
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
//										mediaList.setSelectionModel(new selection(0));
										mediaPlayer.play();
										nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_default.png").toString()));
								} else {
										handleMedia(mediaFileList, index + 1);
//										mediaList.setSelectionModel(new selection(index+1));
										mediaPlayer.play();
										nextBtn.setImage(new Image(getClass().getResource("playerImg/player_forward_default.png").toString()));
								}
						});
			previousBtn.setOnMouseClicked(e -> {
								mediaPlayer.stop();
								if (index == 0) {
										handleMedia(mediaFileList, mediaFileList.size() - 1);
//										mediaList.setSelectionModel(new selection(mediaFileList.size() - 1));
										mediaPlayer.play();
										previousBtn.setImage(new Image(getClass().getResource("playerImg/player_backward_default.png").toString()));
								} else {
										handleMedia(mediaFileList, index - 1);
//										mediaList.setSelectionModel(new selection(index - 1));
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
					double std = 10/total;

					//미디어 슬라이더가 값이 변경될 때만 시간을 찾음
					if(mediaSlider.isValueChanging()){
						mediaPlayer.seek(curTime);
					}else{
					//이전슬라이더 값과 현재 찾으려는 슬라이더의 값의 차이가 미세할 때 제외
						if(Math.abs(preSlider-curSlider)>0.5){
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
				ex.printStackTrace();
			}
		}else return;
	}
	
	//파일 업로드를 하지 않거나 취소하면 뜨는 팝업
	private void fileEmptyCheck(MouseEvent e) {
			try {
				Popup popup = new Popup();
				HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("mediaPopup.fxml"));
				popup.getContent().add(hbox);
				popup.setAutoHide(true);
				popup.show(((ImageView)e.getSource()).getScene().getWindow());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}
	// 누르면 리스트뷰와 각각의 리스트 객체에서 해당 파일을 지운다.
	private void handleDelete(MouseEvent e, String selectFile) {
		if(MiniMediaController.playList.getFileName().isEmpty()||MiniMediaController.playList.getMediaFile().isEmpty()){
			mediaPlayer.stop();
			fileEmptyCheck(e);
		}else{
			int delIndex = MiniMediaController.playList.getFileName().indexOf(selectFile);
			MiniMediaController.playList.getFileName().remove(delIndex);
			MiniMediaController.playList.getMediaFile().remove(delIndex);
			mediaList.setItems(MiniMediaController.playList.getFileName());
			index--;
			
			if(MiniMediaController.playList.getFileName().isEmpty()||MiniMediaController.playList.getMediaFile().isEmpty()){
				mediaPlayer.stop();
				mediaPlayer = null;
				fileEmptyCheck(e);
			}
		}
	}
	private void exit() {
		MainController.menuicon[5].setImage(new Image(getClass().getResource("../main/images/main_player_default.png").toString()));
        MainController.stackPane.getChildren().remove(miniMediaRoot);
		if(!(MiniMediaController.playList.getMediaFile().isEmpty() && MiniMediaController.playList.getFileName().isEmpty())){
			 MiniMediaController.playList.setCurrentPlay(mediaPlayer);
			 mediaPlayer.stop();
		 }
		exit.setImage(new Image(getClass().getResource("playerImg/exit_default.png").toString()));
    }

	private void maximizeScreen() {
		 MainController.stackPane.getChildren().add(MainController.parent.get(5));
		 if(!(playList.getMediaFile().isEmpty() && playList.getFileName().isEmpty())){
			 playList.setCurrentPlay(mediaPlayer);
			 mediaPlayer.stop();
		 }
		 maximize.setImage(new Image(getClass().getResource("playerImg/expension_defult.png").toString()));
	}
	
}

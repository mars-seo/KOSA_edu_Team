package team1.kjm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class SoundMiniController implements Initializable {

    @FXML
    private ListView<String> listView;
    @FXML
    private Slider sliderVolume;
    @FXML
    private Button btnStop;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnPlay;
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider progressSlider;
    @FXML
    private Label labelTime;
    @FXML
    private ImageView imgSound;

    private boolean mute;
    private Media media;
    private MediaPlayer mediaPlayer;
    private ObservableList<String> list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // listview에 정보 담기
        list = FXCollections.observableArrayList();
        list.add("Kalimba.mp3");
        list.add("Maid with the Flaxen Hair.mp3");
        list.add("Sleep Away.mp3");
        listView.setItems(list);
        handleMediaPlay(list.get(0));

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                mediaPlayer.stop();
                System.out.println(newValue);
                handleMediaPlay(newValue);
                mediaPlayer.play();
            }
        });
    }

    private void handleMediaPlay(String song) {
        media = new Media(getClass().getResource("media/" + song).toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setOnReady(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });
        mediaPlayer.setOnPlaying(() -> {
            btnPlay.setDisable(true);
            btnPause.setDisable(false);
            btnStop.setDisable(false);
        });
        mediaPlayer.setOnPaused(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(false);
        });
        mediaPlayer.setOnStopped(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.stop();
            int songIndex = list.indexOf(song);
            if (songIndex < list.size() - 1) {
                handleMediaPlay(list.get(++songIndex));
                mediaPlayer.play();
            } else {
                handleMediaPlay(list.get(0));
                mediaPlayer.play();
            }
        });

        btnPlay.setOnAction(e -> mediaPlayer.play());
        btnPause.setOnAction(e -> mediaPlayer.pause());
        btnStop.setOnAction(e -> mediaPlayer.stop());
        sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(newValue.doubleValue() / 100.0);
            }
        });

        sliderVolume.setValue(50);
        // 뮤트 클릭시
        imgSound.setOnMouseClicked(e -> {
            if (!mute) {
                sliderVolume.setValue(0);
                imgSound.setImage(new Image(getClass().getResource("images/mute.png").toString()));
            } else {
                sliderVolume.setValue(50);
                imgSound.setImage(new Image(getClass().getResource("images/sound.png").toString()));
            }
            mute = !mute;
        });
        // 볼륨 조정시 뮤트 해제
        sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mute = false;
                imgSound.setImage(new Image(getClass().getResource("images/sound.png").toString()));
            }
        });

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                int playTime = (int) newValue.toSeconds();
                // 재생시간을 00:00:00 로 표현하기
                int[] play = new int[3];
                play[0] = playTime % 60;
                play[1] = (playTime / 60) % 60;
                play[2] = (playTime / (60 * 60)) % 60;
                String[] strPlay = new String[3];
                strPlay[0] = String.valueOf(play[0] < 10 ? "0" + play[0] : play[0]);
                strPlay[1] = String.valueOf(play[1] < 10 ? "0" + play[1] : play[1]);
                strPlay[2] = String.valueOf(play[2] < 10 ? "0" + play[2] : play[2]);

                labelTime.setText(strPlay[2] + ":" + strPlay[1] + ":" + strPlay[0]);

                progressSlider.setValue(progress * 100);
            }
        });

        progressSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // 미디어의 전체 시간 (단위: sec)
                double totalSec = mediaPlayer.getTotalDuration().toSeconds();
                // slider의 현재 값
                double newProgress = newValue.doubleValue();
                // slider의 이전 값
                double oldProgress = oldValue.doubleValue();
                // slider의 슬라이더를 움직으려고 할때
                if (progressSlider.isValueChanging()) {
                    // 미디어의 전체 길이에 대한 현재 slider의 비율로 미디어의 위치를 찾음
                    mediaPlayer.seek(Duration.seconds(totalSec * newProgress / 100));
                } else if (Math.abs(newProgress - oldProgress) > 0.5) {
                    // 영상이 엄청 길어지게 되면 이것만으로는 안됨 / 위에 것이 필요
                    // 영상의 이동 비율이 0.5% 이상일 때만 미디어의 위치를 이동시킴 
                    mediaPlayer.seek(Duration.seconds(totalSec * newProgress / 100));
                }
            }
        });
    }

}

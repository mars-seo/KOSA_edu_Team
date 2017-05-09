package team1.Homvis.player;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.MediaPlayer;


public class PlayerList {
	private ObservableList<File> mediaFile = FXCollections.observableArrayList();
	private ObservableList<String> fileName = FXCollections.observableArrayList();
	private MediaPlayer currentPlay;

	public ObservableList<File> getMediaFile() {
		return mediaFile;
	}

	public void setMediaFile(ObservableList<File> mediaFile) {
		this.mediaFile = mediaFile;
	}

	public ObservableList<String> getFileName() {
		return fileName;
	}

	public void setFileName(ObservableList<String> fileName) {
		this.fileName = fileName;
	}

	public MediaPlayer getCurrentPlay() {
		return currentPlay;
	}

	public void setCurrentPlay(MediaPlayer currentPlay) {
		this.currentPlay = currentPlay;
	}
	
	
}

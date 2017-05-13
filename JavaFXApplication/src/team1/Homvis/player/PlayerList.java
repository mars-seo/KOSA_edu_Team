package team1.Homvis.player;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PlayerList {
	
	private ObservableList<File> mediaFile = FXCollections.observableArrayList();
	private ObservableList<String> fileName = FXCollections.observableArrayList();
	
	public PlayerList(){
	
		mediaFile.add(new File(getClass().getResource("media/oow2010-2.flv").toString()));
		mediaFile.add(new File(getClass().getResource("media/video.mp4").toString()));
		mediaFile.add(new File(getClass().getResource("media/video.m4v").toString()));
		mediaFile.add(new File(getClass().getResource("media/audio.wav").toString()));
		
		for(int i=0;i<mediaFile.size();i++){
			fileName.add(mediaFile.get(i).getName());
		}
	}	
		
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
	
}

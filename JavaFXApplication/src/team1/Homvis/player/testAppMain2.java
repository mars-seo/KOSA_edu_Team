package team1.Homvis.player;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testAppMain2 extends Application{

    @Override
    public void start(Stage primaryStage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("miniMedia.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Team Project");
			primaryStage.show();
		} catch (IOException ex) {
			System.err.println("예외 발생");
		}
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}

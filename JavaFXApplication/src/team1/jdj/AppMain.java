package team1.jdj;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(getClass().getResource("funmenu.css").toString());
        scene.getStylesheets().setAll("fun-menu");
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("창제목");
		primaryStage.show();
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}

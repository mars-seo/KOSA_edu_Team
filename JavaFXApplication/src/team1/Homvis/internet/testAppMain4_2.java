package team1.Homvis.internet;

import team1.Homvis.tariff.*;
import team1.Homvis.move.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testAppMain4_2 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
	      Parent parent = FXMLLoader.load(getClass().getResource("internet.fxml"));
//       Parent parent = FXMLLoader.load(getClass().getResource("control.fxml"));
//        Parent parent = FXMLLoader.load(getClass().getResource("controlMini.fxml"));

        Scene scene = new Scene(parent);
        primaryStage.setTitle("KJM");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

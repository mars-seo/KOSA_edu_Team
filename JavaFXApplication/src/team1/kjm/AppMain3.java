package team1.kjm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain3 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent parent = FXMLLoader.load(getClass().getResource("move.fxml"));
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

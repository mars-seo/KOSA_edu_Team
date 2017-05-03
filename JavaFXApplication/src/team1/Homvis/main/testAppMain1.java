package team1.Homvis.main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testAppMain1 extends Application {
    public static Stage primaryStage;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        testAppMain1.primaryStage= primaryStage; 
        Parent parent = FXMLLoader.load(getClass().getResource("root1.fxml"));

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Panel");
        primaryStage.show();
        primaryStage.setMaxWidth(800);
        primaryStage.setMaxHeight(480);

    }

    public static void main(String[] args) {
        launch(args);
    }


    
}

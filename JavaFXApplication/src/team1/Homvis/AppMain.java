package team1.Homvis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
    public static Stage primaryStage;
    

    @Override
    public void start(Stage primaryStage) throws Exception {

        AppMain.primaryStage= primaryStage; 
        Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));

       
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Panel");
        primaryStage.show();
        primaryStage.setMaxWidth(830);
        primaryStage.setMaxHeight(520);

    }

    public static void main(String[] args) {
        launch(args);
    }


    
}

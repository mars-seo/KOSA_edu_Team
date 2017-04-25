package team1.kjm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
       
        Scene scene = new Scene(parent);
        primaryStage.setTitle("AppMain");
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
   
    public static void main(String[] args) {
        launch(args);
    }
}

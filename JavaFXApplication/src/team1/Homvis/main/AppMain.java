package team1.Homvis.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
    public static Stage primaryStage;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD:JavaFXApplication/src/team1/Homvis/main/testAppMain1.java
        testAppMain1.primaryStage= primaryStage; 
        Parent parent = FXMLLoader.load(testAppMain1.class.getResource("main.fxml"));
=======
        AppMain.primaryStage= primaryStage; 
        Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));
>>>>>>> bcbbf80260112538bb685367d5c9ffd019dab657:JavaFXApplication/src/team1/Homvis/main/AppMain.java
       
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

package team1.Homvis.boiler;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testAppMain1_1 extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        testAppMain1_1.primaryStage = primaryStage;

        Parent parent = FXMLLoader.load(getClass().getResource("boiler.fxml"));


        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Controller");
//        primaryStage.setMaxWidth(800);
//        primaryStage.setMaxHeight(480);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

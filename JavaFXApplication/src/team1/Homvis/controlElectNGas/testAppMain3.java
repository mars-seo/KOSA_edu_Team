package team1.Homvis.controlElectNGas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testAppMain3 extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        testAppMain3.primaryStage = primaryStage;
        System.out.println(getClass().getResource("control.fxml"));
        Parent parent = FXMLLoader.load(getClass().getResource("control.fxml"));
//        Parent parent = FXMLLoader.load(getClass().getResource("controlMini.fxml"));

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Controller");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

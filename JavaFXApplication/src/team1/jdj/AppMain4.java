package team1.jdj;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent parent = FXMLLoader.load(getClass().getResource("mini.fxml")); //작은것
//        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));//요금조회
        Parent parent = FXMLLoader.load(getClass().getResource("internet.fxml"));//인터넷창
        System.out.println(parent);
        Scene scene = new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.setTitle("창제목");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

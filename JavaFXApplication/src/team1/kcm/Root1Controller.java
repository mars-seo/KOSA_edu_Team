package team1.kcm;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.util.Duration;

public class Root1Controller implements Initializable {

    @FXML
    public static StackPane stackPane;
    @FXML
    private ImageView background;
    @FXML
    private HBox menu;

    public static int secretCount = 0;
    private String newPassword;

    private static int count = -1;
    private static double xValue;
    @FXML
    private ImageView menuIcon1;
    @FXML
    private ImageView menuIcon2;
    @FXML
    private ImageView menuIcon3;
    @FXML
    private ImageView menuIcon4;
    @FXML
    private ImageView menuIcon5;
    @FXML
    private ImageView menuIcon6;
    @FXML
    private ImageView menuIcon7;
    @FXML
    private Label clock;
    
    public static Popup popup;
    public static String password;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Popup pop = new Popup();
        popup=pop;

        //clock start
        Thread thread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                while (true) {
                    String strTime = sdf.format(new Date());
                    Platform.runLater(() -> {
                        clock.setText(strTime);
                    });
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                }

            }
        };
        thread.setDaemon(true);
        thread.start();
        ////////////////////////////clock end

        //아이콘 눌렀을때
        menuIcon1.setOnMouseClicked(event -> secretClicked());
        menuIcon1.setOnMouseClicked(event -> secretClicked());
        menuIcon1.setOnMouseClicked(event -> secretClicked());
        menuIcon1.setOnMouseClicked(event -> secretClicked());
        menuIcon1.setOnMouseClicked(event -> secretClicked());
        menuIcon1.setOnMouseClicked(event -> secretClicked());
        menuIcon1.setOnMouseClicked(event -> secretClicked());

        //////////아이콘눌렀을때 끝
        menu.setTranslateX(0);
        menu.setTranslateY(200);
////////////////
        background.setOnMouseClicked(event -> {
            count = count * (-1);
            if (count == 1) {
                menuOpen();
            } else {
                menuClose();
            }
        });

        //      menu.setOnSwipeRight(new EventHandler<SwipeEvent>() {
        //         @Override
        //        public void handle(SwipeEvent event) {
        //            System.out.println("swipeRight");
        //            event.consume();
        //        }
        //   });
        //  menu.setOnMouseReleased(new EventHandler<MouseEvent>() {
        //     @Override
        //      public void handle(MouseEvent event) {
        //          System.out.println("mousereleased");
        //          menu.setTranslateX(menu.getTranslateX() + event.getX());
        //          menu.setTranslateY(menu.getTranslateY() + event.getY());
        //          event.consume();
        //      }
        //   });
        //   menu.setOnMouseReleased((event) -> {
        //      System.out.println("mousereleased");
        // });
        menu.setOnMousePressed((event) -> {
            xValue = event.getSceneX();
            System.out.println(xValue);
        });

        menu.setOnMouseDragged((event) -> {
            System.out.println(menu.getTranslateX());

            if (menu.getTranslateX() < -1000) {
                menu.setTranslateX(-1000);
                System.out.println("if1");
            } else if (menu.getTranslateX() > 0) {
                menu.setTranslateX(0);
                System.out.println("if2");
            } else {
                System.out.println("if3");
                menu.setTranslateX(event.getSceneX() - xValue);
            }

        });

        //      menu.setOnMouseDragOver((event) -> {
        //         System.out.println("mousereleased1");
        //    });
    }

   
    
    

    private void menuOpen() {
        System.out.println("open");
        //sstackPane.getChildren().add(menu);

        KeyValue keyValue = new KeyValue(menu.translateYProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    private void menuClose() {
        System.out.println("close");
        KeyValue keyValue = new KeyValue(menu.translateYProperty(), 200);
        // KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
        //         (event) -> {
        //           sstackPane.getChildren().remove(menu);
        //      },
        //        keyValue);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    

    private void secretClicked() {

        //     try {
        //         Parent parent = FXMLLoader.load(getClass().getResource("newpassword.fxml"));
        //   } catch (IOException ex) {
        //    }
        
        try {
            AnchorPane secretview;

            secretview = (AnchorPane) FXMLLoader.load(getClass().getResource("newpassword.fxml"));

            Label txt1 = (Label) secretview.lookup("#txt1");
            Label txt2 = (Label) secretview.lookup("#txt2");
            PasswordField password1 = (PasswordField) secretview.lookup("#password1");
            Button btnOk = (Button) secretview.lookup("#btnOk");
            
            
            
            if (secretCount > 0) {
                txt1.setText("기존 비밀번호");
                txt2.setText("신규 비밀번호");
                popup.getContent().add(secretview);
                popup.setAutoHide(false);
                popup.show(AppMain1.primaryStage, 400, 200);
                

            } else {
                popup.getContent().add(secretview);

                popup.setAutoHide(false);
                popup.show(AppMain1.primaryStage, 400, 200);
                

                //  imgMessage.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
            }
            
            
            
        } catch (IOException ex) {
        }

    }

}

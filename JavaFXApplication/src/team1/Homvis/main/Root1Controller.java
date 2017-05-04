package team1.Homvis.main;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Root1Controller implements Initializable {

    @FXML
    private StackPane sstackPane;
    @FXML
    private ImageView background;
    @FXML
    private HBox menu;

    public static int secretCount = 0;

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
    private ImageView menuIcon8;
    @FXML
    private Label clock;

    public static ImageView menuicon1;
    public static ImageView menuicon2;
    public static ImageView menuicon3;
    public static ImageView menuicon4;
    public static ImageView menuicon5;
    public static ImageView menuicon6;
    public static ImageView menuicon7;
    public static ImageView menuicon8;

    public static String password;
    public static StackPane stackPane;
    public static boolean menu1PasswordChk = false;
    public static boolean menu2PasswordChk = false;
    public static boolean menu3PasswordChk = false;
    public static boolean menu4PasswordChk = false;
    public static boolean menu5PasswordChk = false;
    public static boolean menu6PasswordChk = false;
    public static boolean menu7PasswordChk = false;
    public static boolean menu8PasswordChk = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //나중에 디폴트로 만들기위해
        menuicon1 = menuIcon1;
        menuicon2 = menuIcon2;
        menuicon3 = menuIcon3;
        menuicon4 = menuIcon4;
        menuicon5 = menuIcon5;
        menuicon6 = menuIcon6;
        menuicon7 = menuIcon7;
        menuicon8 = menuIcon8;

        stackPane = sstackPane;

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
        menuIcon1.setOnMousePressed(event -> homePressed());
        menuIcon1.setOnMouseClicked(event -> homeClicked());
        menuIcon2.setOnMousePressed(event -> boilerPressed());
        menuIcon2.setOnMouseClicked(event -> boilerClicked());
        menuIcon3.setOnMousePressed(event -> elecNgasPressed());
        menuIcon3.setOnMouseClicked(event -> elecNgasClicked());
        menuIcon4.setOnMousePressed(event -> interphonePressed());
        menuIcon4.setOnMouseClicked(event -> interphoneClicked());
        menuIcon5.setOnMousePressed(event -> internetPressed());
        menuIcon5.setOnMouseClicked(event -> internetClicked());
        menuIcon6.setOnMousePressed(event -> playerPressed());
        menuIcon6.setOnMouseClicked(event -> playerClicked());
        menuIcon7.setOnMousePressed(event -> tariffPressed());
        menuIcon7.setOnMouseClicked(event -> tariffClicked());
        menuIcon8.setOnMousePressed(event -> secretPressed());
        menuIcon8.setOnMouseClicked(event -> secretClicked()); //암호설정 서브메뉴이동

        //메뉴시작위치
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

        //      menu.setOnSwipeRight(new EventHandler<SwipeEvent>() {   //터치패드사용
        //         @Override
        //        public void handle(SwipeEvent event) {
        //            System.out.println("swipeRight");
        //            event.consume();
        //        }
        //   });
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
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    private void passwordChk(int value) { //각각의 menuicon들의 번호를 넘겨받음, passwordcontroll에서 암호가 맞을시에 창띄울때 사용
        Parent chkView;
        secretCount = value;
        try {
            chkView = FXMLLoader.load(getClass().getResource("../secret/newpassword.fxml"));
            stackPane.getChildren().add(chkView);
            chkView.setTranslateX(0);
            chkView.setOpacity(0);
            KeyValue keyValue = new KeyValue(chkView.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

            VBox chkboxview = (VBox) chkView.lookup("#chkboxview");
            Label txt1 = (Label) chkView.lookup("#txt1");
            Label txt2 = (Label) chkView.lookup("#txt2");
            PasswordField password2 = (PasswordField) chkView.lookup("#password2");

            txt1.setText("비밀번호");
            txt2.setText("");

            KeyValue keyValue1 = new KeyValue(chkboxview.opacityProperty(), 0);
            KeyFrame keyFrame1 = new KeyFrame(Duration.millis(100), keyValue1);
            Timeline timeline1 = new Timeline();
            timeline1.getKeyFrames().add(keyFrame1);
            timeline1.play();

            KeyValue keyValue2 = new KeyValue(password2.opacityProperty(), 0);
            KeyFrame keyFrame2 = new KeyFrame(Duration.millis(100), keyValue2);
            Timeline timeline2 = new Timeline();
            timeline2.getKeyFrames().add(keyFrame2);
            timeline2.play();

        } catch (IOException ex) {

        }
    }

    private void homePressed() {
        menuIcon1.setImage(new Image(getClass().getResource("images/main_home_pressed.png").toString()));

    }

    private void homeClicked() {
        menuIcon1.setImage(new Image(getClass().getResource("images/main_home_clicked.png").toString()));

    }

    private void boilerPressed() {
        menuIcon2.setImage(new Image(getClass().getResource("images/main_boiler_pressed.png").toString()));
    }

    private void boilerClicked() {
        menuIcon2.setImage(new Image(getClass().getResource("images/main_boiler_clicked.png").toString()));
        if (menu2PasswordChk == false) {
            try {
                Parent boilerview = FXMLLoader.load(getClass().getResource("../boiler/boiler.fxml"));
                stackPane.getChildren().add(boilerview); 
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } catch (IOException ex) {

            }
        } else {
            passwordChk(2);

        }

    }

    private void elecNgasPressed() {
        menuIcon3.setImage(new Image(getClass().getResource("images/main_elecNgas_pressed.png").toString()));

    }

    private void elecNgasClicked() {
        menuIcon3.setImage(new Image(getClass().getResource("images/main_elecNgas_clicked.png").toString()));
        if (menu3PasswordChk == false) {
                    

        } else {
            passwordChk(3);
        }

    }

    private void interphonePressed() {
        menuIcon4.setImage(new Image(getClass().getResource("images/main_interphone_pressed.png").toString()));
    }

    private void interphoneClicked() {
        menuIcon4.setImage(new Image(getClass().getResource("images/main_interphone_clicked.png").toString()));
        if (menu4PasswordChk == false) {

        } else {
            passwordChk(4);
        }
    }

    private void internetPressed() {

    }

    private void internetClicked() {
        if (menu5PasswordChk == false) {

        } else {
            passwordChk(5);
        }

    }

    private void playerPressed() {
        menuIcon6.setImage(new Image(getClass().getResource("images/main_player_pressed.png").toString()));
    }

    private void playerClicked() {
        menuIcon6.setImage(new Image(getClass().getResource("images/main_player_clicked.png").toString()));
        if (menu6PasswordChk == false) {

        } else {
            passwordChk(6);
        }
    }

    private void tariffPressed() {
        menuIcon7.setImage(new Image(getClass().getResource("images/main_tariff_pressed.png").toString()));
    }

    private void tariffClicked() {
        menuIcon7.setImage(new Image(getClass().getResource("images/main_tariff_clicked.png").toString()));
        if (menu7PasswordChk == false) {

        } else {
            passwordChk(7);
        }
    }

    private void secretPressed() {
        menuIcon8.setImage(new Image(getClass().getResource("images/main_secret_pressed.png").toString()));
    }

    private void secretClicked() {
        menuIcon8.setImage(new Image(getClass().getResource("images/main_secret_clicked.png").toString()));
        System.out.println("clicked");
        Parent secretview;
        try {
            secretview = FXMLLoader.load(getClass().getResource("../secret/newpassword.fxml"));
            stackPane.getChildren().add(secretview);
            secretview.setTranslateX(0);
            secretview.setOpacity(0);
            KeyValue keyValue = new KeyValue(secretview.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

            Label txt1 = (Label) secretview.lookup("#txt1");
            Label txt2 = (Label) secretview.lookup("#txt2");
            PasswordField password1 = (PasswordField) secretview.lookup("#password1");

            if (secretCount > 0) {
                txt1.setText("기존 비밀번호");
                txt2.setText("신규 비밀번호");

            }
        } catch (IOException ex) {

        }
    }

}

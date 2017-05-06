package team1.Homvis.main;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

public class MainController implements Initializable {

    @FXML
    private StackPane sstackPane;
    @FXML
    private ImageView background;
    @FXML
    private HBox menu;
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

    public static int secretCount = 0;
    private static int count = -1;
    private static double xValue;

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

    private List<String> menuList = new ArrayList<>();
    public static List<Parent> parent = new ArrayList<>();
    public static List<Parent> miniParent = new ArrayList<>();

    private boolean miniWindow;

    public MainController() {
        try {

            this.parent.add(FXMLLoader.load(getClass().getResource("../newMain/newMenu.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("../boiler/boiler.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("../controlElectNGas/control.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("../interphone/interPhone.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("../internet/internet.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("../player/media.fxml")));
            this.parent.add(FXMLLoader.load(getClass().getResource("../tariff/root.fxml")));
            //this.parent.add(FXMLLoader.load(getClass().getResource("../fxml")));

            this.menuList.add("home");
            this.menuList.add("boiler");
            this.menuList.add("elecNgas");
            this.menuList.add("interphone");
            this.menuList.add("internet");
            this.menuList.add("player");
            this.menuList.add("tariff");

            //미니 메뉴를 위한 구성
            this.miniParent.add(FXMLLoader.load(getClass().getResource("../newMain/newMenu.fxml")));
            this.miniParent.add(FXMLLoader.load(getClass().getResource("../boiler/boilermini.fxml")));
            this.miniParent.add(FXMLLoader.load(getClass().getResource("../controlElectNGas/controlMini.fxml")));
            this.miniParent.add(FXMLLoader.load(getClass().getResource("../interphone/miniInterPhone.fxml")));
            this.miniParent.add(FXMLLoader.load(getClass().getResource("../internet/internet.fxml")));
            this.miniParent.add(FXMLLoader.load(getClass().getResource("../player/miniMedia.fxml")));
            this.miniParent.add(FXMLLoader.load(getClass().getResource("../tariff/mini.fxml")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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
        menuIcon1.setOnMousePressed(event -> menuPressed(menuIcon1, 0));
        menuIcon1.setOnMouseClicked(event -> menuClicked(menuIcon1, 0, menu1PasswordChk));
        menuIcon2.setOnMousePressed(event -> menuPressed(menuIcon2, 1));
        menuIcon2.setOnMouseClicked(event -> menuClicked(menuIcon2, 1, menu2PasswordChk));
        menuIcon3.setOnMousePressed(event -> menuPressed(menuIcon3, 2));
        menuIcon3.setOnMouseClicked(event -> menuClicked(menuIcon3, 2, menu3PasswordChk));
        menuIcon4.setOnMousePressed(event -> menuPressed(menuIcon4, 3));
        menuIcon4.setOnMouseClicked(event -> menuClicked(menuIcon4, 3, menu4PasswordChk));
        menuIcon5.setOnMousePressed(event -> menuPressed(menuIcon5, 4));
        menuIcon5.setOnMouseClicked(event -> menuClicked(menuIcon5, 4, menu5PasswordChk));
        menuIcon6.setOnMousePressed(event -> menuPressed(menuIcon6, 5));
        menuIcon6.setOnMouseClicked(event -> menuClicked(menuIcon6, 5, menu6PasswordChk));
        menuIcon7.setOnMousePressed(event -> menuPressed(menuIcon7, 6));
        menuIcon7.setOnMouseClicked(event -> menuClicked(menuIcon7, 6, menu7PasswordChk));
        menuIcon8.setOnMousePressed(event -> secretPressed());
        menuIcon8.setOnMouseClicked(event -> secretClicked()); //암호설정 서브메뉴이동

        //메뉴시작위치
        menu.setTranslateX(30);
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
        //sstackPane.getChildren().add(menu);
        KeyValue keyValue = new KeyValue(menu.translateYProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(700), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    private void menuClose() {
        KeyValue keyValue = new KeyValue(menu.translateYProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(700), keyValue);
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
            chkView.setTranslateY(-200);
            chkView.setOpacity(0);
            KeyValue keyValue = new KeyValue(chkView.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
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

    private void menuPressed(ImageView menuIcon, int index) {
        menuIcon.setImage(new Image(getClass().getResource("images/main_" + menuList.get(index) + "_pressed.png").toString()));

    }

    private void menuClicked(ImageView menuIcon, int index, boolean chk) {
        menuIcon.setImage(new Image(getClass().getResource("images/main_" + menuList.get(index) + "_clicked.png").toString()));
        if (index == 0) {

            menuIcon.setImage(new Image(getClass().getResource("images/main_" + menuList.get(index) + "_default.png").toString()));
        } else {
            if (chk == false) {

                Parent miniView = miniParent.get(index);
                stackPane.getChildren().add(miniView);
                if (!miniWindow) {
                    miniView.setTranslateX(0);
                    miniView.setTranslateY(0);
                    miniView.setOpacity(0);
                    KeyValue keyValue = new KeyValue(miniView.opacityProperty(), 1);
                    KeyFrame keyFrame = new KeyFrame(Duration.millis(800), keyValue);
                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                } else {
                    miniView.setTranslateX(400);
                    miniView.setTranslateY(0);
                    miniView.setOpacity(0);
                    KeyValue keyValue = new KeyValue(miniView.opacityProperty(), 1);
                    KeyFrame keyFrame = new KeyFrame(Duration.millis(800), keyValue);
                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                }
                miniWindow = !miniWindow;
                //menuIcon.setOnMouseClicked(e->fullmenuClicked(menuIcon, index, chk));

            } else {
                passwordChk(index + 1);
            }
        }
    }

    private void fullmenuClicked(ImageView menuIcon, int index, boolean chk) {
        menuIcon.setImage(new Image(getClass().getResource("images/main_" + menuList.get(index) + "_clicked.png").toString()));
        if (index == 0) {

            menuIcon.setImage(new Image(getClass().getResource("images/main_" + menuList.get(index) + "_default.png").toString()));
        } else {
            if (chk == false) {

                Parent boilerview = parent.get(index);
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();

            } else {
                passwordChk(index + 1);
            }
        }
    }
//    private void homePressed() {
//        menuIcon1.setImage(new Image(getClass().getResource("images/main_home_pressed.png").toString()));
//
//    }
//
//    private void homeClicked() {
//        menuIcon1.setImage(new Image(getClass().getResource("images/main_home_clicked.png").toString()));
//
//    }
//
//    private void boilerPressed() {
//        menuIcon2.setImage(new Image(getClass().getResource("images/main_boiler_pressed.png").toString()));
//    }
//
//    private void boilerClicked() {
//        menuIcon2.setImage(new Image(getClass().getResource("images/main_boiler_clicked.png").toString()));
//        if (menu2PasswordChk == false) {
//			
//			Parent boilerview = parent.get(0);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//            
//        } else {
//            passwordChk(2);
//        }
//
//    }
//
//    private void elecNgasPressed() {
//        menuIcon3.setImage(new Image(getClass().getResource("images/main_elecNgas_pressed.png").toString()));
//
//    }
//
//    private void elecNgasClicked() {
//        menuIcon3.setImage(new Image(getClass().getResource("images/main_elecNgas_clicked.png").toString()));
//        if (menu3PasswordChk == false) {
//                    
//			Parent boilerview = parent.get(1);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//			
//        } else {
//            passwordChk(3);
//        }
//
//    }
//
//    private void interphonePressed() {
//        menuIcon4.setImage(new Image(getClass().getResource("images/main_interphone_pressed.png").toString()));
//    }
//
//    private void interphoneClicked() {
//        menuIcon4.setImage(new Image(getClass().getResource("images/main_interphone_clicked.png").toString()));
//        if (menu4PasswordChk == false) {
//			Parent boilerview = parent.get(2);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(4);
//        }
//    }
//
//    private void internetPressed() {
//
//    }
//
//    private void internetClicked() {
//        if (menu5PasswordChk == false) {
//			Parent boilerview = parent.get(3);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(5);
//        }
//
//    }
//
//    private void playerPressed() {
//        menuIcon6.setImage(new Image(getClass().getResource("images/main_player_pressed.png").toString()));
//    }
//
//    private void playerClicked() {
//        menuIcon6.setImage(new Image(getClass().getResource("images/main_player_clicked.png").toString()));
//        if (menu6PasswordChk == false) {
//			Parent boilerview = parent.get(4);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(6);
//        }
//    }
//
//    private void tariffPressed() {
//        menuIcon7.setImage(new Image(getClass().getResource("images/main_tariff_pressed.png").toString()));
//    }
//
//    private void tariffClicked() {
//        menuIcon7.setImage(new Image(getClass().getResource("images/main_tariff_clicked.png").toString()));
//        if (menu7PasswordChk == false) {
//			Parent boilerview = parent.get(5);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(7);
//        }
//    }

    private void secretPressed() {
        menuIcon8.setImage(new Image(getClass().getResource("images/main_secret_pressed.png").toString()));
    }

    private void secretClicked() {
        menuIcon8.setImage(new Image(getClass().getResource("images/main_secret_clicked.png").toString()));
        Parent secretview;
        try {
            secretview = FXMLLoader.load(getClass().getResource("../secret/newpassword.fxml"));
            
            stackPane.getChildren().add(secretview);
            secretview.setTranslateY(-200);
             if (!miniWindow) {
                    secretview.setTranslateX(0);
                 
                    secretview.setOpacity(0);
                    KeyValue keyValue = new KeyValue(secretview.opacityProperty(), 1);
                    KeyFrame keyFrame = new KeyFrame(Duration.millis(800), keyValue);
                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                } else {
                    secretview.setTranslateX(400);
                  //  secretview.setTranslateY(0);
                    secretview.setOpacity(0);
                    KeyValue keyValue = new KeyValue(secretview.opacityProperty(), 1);
                    KeyFrame keyFrame = new KeyFrame(Duration.millis(800), keyValue);
                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                }
                miniWindow = !miniWindow;


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

package team1.Homvis.secret;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import static team1.Homvis.main.mainController.secretCount;
import static team1.Homvis.main.mainController.stackPane;
import team1.Homvis.main.mainController;

public class NewpasswordController implements Initializable {

    @FXML
    private Button btnok;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private Label warning;
    @FXML
    private AnchorPane secret;
    @FXML
    private AnchorPane keypadroot;
    @FXML
    private ImageView key0;
    @FXML
    private ImageView key1;
    @FXML
    private ImageView key2;
    @FXML
    private ImageView key3;
    @FXML
    private ImageView key4;
    @FXML
    private ImageView key5;
    @FXML
    private ImageView key6;
    @FXML
    private ImageView key7;
    @FXML
    private ImageView key8;
    @FXML
    private ImageView key9;
    @FXML
    private ImageView keydelete;
    @FXML
    private ImageView keyreset;

    private List<String> password1List = new ArrayList<>();
    private List<String> password2List = new ArrayList<>();
    @FXML
    private CheckBox chkBtn1;
    @FXML
    private CheckBox chkBtn2;
    @FXML
    private CheckBox chkBtn3;
    @FXML
    private CheckBox chkBtn4;
    @FXML
    private CheckBox chkBtn5;
    @FXML
    private CheckBox chkBtn6;
    @FXML
    private CheckBox chkBtn7;
    @FXML
    private CheckBox chkBtn8;
    @FXML
    private ImageView exit;

    private boolean temp1PasswordChk = mainController.menu1PasswordChk;
    private boolean temp2PasswordChk = mainController.menu2PasswordChk;
    private boolean temp3PasswordChk = mainController.menu3PasswordChk;
    private boolean temp4PasswordChk = mainController.menu4PasswordChk;
    private boolean temp5PasswordChk = mainController.menu5PasswordChk;
    private boolean temp6PasswordChk = mainController.menu6PasswordChk;
    private boolean temp7PasswordChk = mainController.menu7PasswordChk;
    private boolean temp8PasswordChk = mainController.menu8PasswordChk;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //매번 새롭게 생성되는 password창이기 때문에 password 설정된 메뉴인지체크창 유지하기 위해서
        chkBtn1.setSelected(mainController.menu1PasswordChk);
        chkBtn2.setSelected(mainController.menu2PasswordChk);
        chkBtn3.setSelected(mainController.menu3PasswordChk);
        chkBtn4.setSelected(mainController.menu4PasswordChk);
        chkBtn5.setSelected(mainController.menu5PasswordChk);
        chkBtn6.setSelected(mainController.menu6PasswordChk);
        chkBtn7.setSelected(mainController.menu7PasswordChk);
        chkBtn8.setSelected(mainController.menu8PasswordChk);

        //체크박스가 각각 체크되면 mainroot의 필드에 저장해 놓는다.
        chkBtn1.selectedProperty().addListener((observable) -> {
            if (temp1PasswordChk == true) {
                temp1PasswordChk = false;
            } else {
                temp1PasswordChk = true;
            }
        });
        chkBtn2.selectedProperty().addListener((observable) -> {
            if (temp2PasswordChk == true) {
                temp2PasswordChk = false;
            } else {
                temp2PasswordChk = true;
            }
        });
        chkBtn3.selectedProperty().addListener((observable) -> {
            if (temp3PasswordChk == true) {
                temp3PasswordChk = false;
            } else {
                temp3PasswordChk = true;
            }
        });
        chkBtn4.selectedProperty().addListener((observable) -> {
            if (temp4PasswordChk == true) {
                temp4PasswordChk = false;
            } else {
                temp4PasswordChk = true;
            }
        });
        chkBtn5.selectedProperty().addListener((observable) -> {
            if (temp5PasswordChk == true) {
                temp5PasswordChk = false;
            } else {
                temp5PasswordChk = true;
            }
        });
        chkBtn6.selectedProperty().addListener((observable) -> {
            if (temp6PasswordChk == true) {
                temp6PasswordChk = false;
            } else {
                temp6PasswordChk = true;
            }
        });
        chkBtn7.selectedProperty().addListener((observable) -> {
            if (temp7PasswordChk == true) {
                temp7PasswordChk = false;
            } else {
                temp7PasswordChk = true;
            }
        });
        chkBtn8.selectedProperty().addListener((observable) -> {
            if (temp8PasswordChk == true) {
                temp8PasswordChk = false;
            } else {
                temp8PasswordChk = true;
            }
        });
//////////////////////////////////////////////////////////////
        keypadroot.setOpacity(0);
        secret.setTranslateX(0);
        secret.setTranslateY(-150);

        btnok.setOnAction(event -> handleOk());
        password1.focusedProperty().addListener((observable) -> {
            keypad();
        });
        password2.focusedProperty().addListener((observable) -> {
            keypad2();
        });

        exit.setOnMouseClicked(event -> off());
        keyreset.setOnMouseClicked(event -> passwordReset());

    }

    private void handleOk() {
        String passwordValue = password1.getText();
        String passwordValue2 = password2.getText();

        if (mainController.secretCount == 1) {
            if (!(temp1PasswordChk == false && temp2PasswordChk == false && temp3PasswordChk == false && temp4PasswordChk == false && temp5PasswordChk == false && temp6PasswordChk == false && temp7PasswordChk == false && temp8PasswordChk == false)) {
                if (passwordValue.equals(mainController.password)) {
                    mainController.password = passwordValue2;
                    chkbox();
                    off();
                } else {
                    warning.setText("패스워드를 정확히 입력해주세요.");
                }
            } else {
                warning.setText("비밀번호를 설정할 메뉴를 선택해주세요");
            }
            //////////보일러
        } else if (mainController.secretCount == 2) {
            if (passwordValue.equals(mainController.password)) {
                secretCount = 1;
                off();
                mainController.menuicon8.setImage(new Image(getClass().getResource("images/main_secret_default.png").toString()));

                Parent boilerview = mainController.parent.get(1);
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
/////////전기가스제어
        } else if (mainController.secretCount == 3) {
            if (passwordValue.equals(mainController.password)) {
                secretCount = 1;
                off();
                Parent boilerview = mainController.parent.get(2);
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

            ///인터폰
        } else if (mainController.secretCount == 4) {
            if (passwordValue.equals(mainController.password)) {
                secretCount = 1;
                off();
                Parent boilerview = mainController.parent.get(3);
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

            ///인터넷
        } else if (mainController.secretCount == 5) {          //
            if (passwordValue.equals(mainController.password)) {
                secretCount = 1;
                off();
                Parent boilerview = mainController.parent.get(4);
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

            //미디어플레이어
        } else if (mainController.secretCount == 6) {
            if (passwordValue.equals(mainController.password)) {
                secretCount = 1;
                off();
                Parent boilerview = mainController.parent.get(5);
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
            //사용량조회
        } else if (mainController.secretCount == 7) {
            if (passwordValue.equals(mainController.password)) {
                secretCount = 1;
                off();
                Parent boilerview = mainController.parent.get(6);
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        } else if (mainController.secretCount == 0) {    // secretCount=0번일때는 비번설정 처음띄웠을때(비번설정안되있을때),1은 비번설정된상태,2번은 비번설정된 상태에서 2번메뉴아이콘 눌렀을때
            if (!(temp1PasswordChk == false && temp2PasswordChk == false && temp3PasswordChk == false && temp4PasswordChk == false && temp5PasswordChk == false && temp6PasswordChk == false && temp7PasswordChk == false && temp8PasswordChk == false)) {
                if ((passwordValue.equals(passwordValue2)) && (!password1.getText().isEmpty())) {

                    mainController.password = passwordValue;
                    secretCount = 1;
                    chkbox();
                    off();

                } else {
                    warning.setText("패스워드를 정확히 입력해주세요.");
                }
            } else {
                warning.setText("비밀번호를 설정할 메뉴를 선택해주세요");
            }
        }
    }

    private void chkbox() {
        mainController.menu1PasswordChk = temp1PasswordChk;
        mainController.menu2PasswordChk = temp2PasswordChk;
        mainController.menu3PasswordChk = temp3PasswordChk;
        mainController.menu4PasswordChk = temp4PasswordChk;
        mainController.menu5PasswordChk = temp5PasswordChk;
        mainController.menu6PasswordChk = temp6PasswordChk;
        mainController.menu7PasswordChk = temp7PasswordChk;
        mainController.menu8PasswordChk = temp8PasswordChk;

    }

    private void off() {

        secret.setOpacity(1);
        secret.setTranslateX(0);
        KeyValue keyValue = new KeyValue(secret.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                (event) -> {
                    mainController.stackPane.getChildren().remove(secret);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        mainController.menuicon8.setImage(new Image(getClass().getResource("images/main_secret_default.png").toString()));
    }

    private String zeroClicked() {
        String input = "";
        input += key0.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String oneClicked() {
        String input = "";
        input += key1.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String twoClicked() {
        String input = "";
        input += key2.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String threeClicked() {
        String input = "";
        input += key3.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String fourClicked() {
        String input = "";
        input += key4.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String fiveClicked() {
        String input = "";
        input += key5.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String sixClicked() {
        String input = "";
        input += key6.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String sevenClicked() {
        String input = "";
        input += key7.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String eightClicked() {
        String input = "";
        input += key8.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String nineClicked() {
        String input = "";
        input += key9.getUserData().toString();
        System.out.println(input);
        return input;
    }

    private String field1pswd(int value) {
        String field1pswdValue = "";
        if (value == 0) {                             //password1번창 눌렀을때처리
            for (String text : password1List) {
                field1pswdValue += text;
            }
        } else if (value == 1) {                     //password2번창 눌렀을때 처리
            for (String text : password2List) {
                field1pswdValue += text;
            }
        }
        return field1pswdValue;
    }

    private void keypad() {
        keypadroot.setTranslateX(0);
        KeyValue keyValue = new KeyValue(keypadroot.opacityProperty(), 1);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        key0.setOnMouseClicked(event -> {
            password1List.add(zeroClicked());
            password1.setText(field1pswd(0));
        });
        key1.setOnMouseClicked(event -> {
            password1List.add(oneClicked());
            password1.setText(field1pswd(0));
        });
        key2.setOnMouseClicked(event -> {
            password1List.add(twoClicked());
            password1.setText(field1pswd(0));
        });
        key3.setOnMouseClicked(event -> {
            password1List.add(threeClicked());
            password1.setText(field1pswd(0));
        });
        key4.setOnMouseClicked(event -> {
            password1List.add(fourClicked());
            password1.setText(field1pswd(0));
        });
        key5.setOnMouseClicked(event -> {
            password1List.add(fiveClicked());
            password1.setText(field1pswd(0));
        });
        key6.setOnMouseClicked(event -> {
            password1List.add(sixClicked());
            password1.setText(field1pswd(0));
        });
        key7.setOnMouseClicked(event -> {
            password1List.add(sevenClicked());
            password1.setText(field1pswd(0));
        });
        key8.setOnMouseClicked(event -> {
            password1List.add(eightClicked());
            password1.setText(field1pswd(0));
        });
        key9.setOnMouseClicked(event -> {
            password1List.add(nineClicked());
            password1.setText(field1pswd(0));
        });
        keydelete.setOnMouseClicked(event -> {
            if (!password1List.isEmpty()) {
                password1List.remove(password1List.size() - 1);
                password1.setText(field1pswd(0));
            }
        });

    }

    private void keypad2() {
        keypadroot.setTranslateX(0);
        KeyValue keyValue = new KeyValue(keypadroot.opacityProperty(), 1);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        key0.setOnMouseClicked(event -> {
            password2List.add(zeroClicked());
            password2.setText(field1pswd(1));
        });
        key1.setOnMouseClicked(event -> {
            password2List.add(oneClicked());
            password2.setText(field1pswd(1));
        });
        key2.setOnMouseClicked(event -> {
            password2List.add(twoClicked());
            password2.setText(field1pswd(1));
        });
        key3.setOnMouseClicked(event -> {
            password2List.add(threeClicked());
            password2.setText(field1pswd(1));
        });
        key4.setOnMouseClicked(event -> {
            password2List.add(fourClicked());
            password2.setText(field1pswd(1));
        });
        key5.setOnMouseClicked(event -> {
            password2List.add(fiveClicked());
            password2.setText(field1pswd(1));
        });
        key6.setOnMouseClicked(event -> {
            password2List.add(sixClicked());
            password2.setText(field1pswd(1));
        });
        key7.setOnMouseClicked(event -> {
            password2List.add(sevenClicked());
            password2.setText(field1pswd(1));
        });
        key8.setOnMouseClicked(event -> {
            password2List.add(eightClicked());
            password2.setText(field1pswd(1));
        });
        key9.setOnMouseClicked(event -> {
            password2List.add(nineClicked());
            password2.setText(field1pswd(1));
        });
        keydelete.setOnMouseClicked(event -> {
            if (!password2List.isEmpty()) {

                password2List.remove(password2List.size() - 1);
                password2.setText(field1pswd(1));
            }
        });

    }

    private void passwordReset() {
        secretCount = 0;
        mainController.password = "";
        System.out.println(mainController.password);/////지울거
        mainController.menu1PasswordChk = false;
        mainController.menu2PasswordChk = false;
        mainController.menu3PasswordChk = false;
        mainController.menu4PasswordChk = false;
        mainController.menu5PasswordChk = false;
        mainController.menu6PasswordChk = false;
        mainController.menu7PasswordChk = false;
        mainController.menu8PasswordChk = false;
        chkBtn1.setSelected(false);
        chkBtn2.setSelected(false);
        chkBtn3.setSelected(false);
        chkBtn4.setSelected(false);
        chkBtn5.setSelected(false);
        chkBtn6.setSelected(false);
        chkBtn7.setSelected(false);
        chkBtn8.setSelected(false);
        password1.setText("");
        password2.setText("");
        password1List.removeAll(password1List);
        password2List.removeAll(password2List);
    }

}

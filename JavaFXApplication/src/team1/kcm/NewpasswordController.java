package team1.kcm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import static team1.kcm.Root1Controller.secretCount;
import static team1.kcm.Root1Controller.stackPane;

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

    private boolean resetChk = false;
    private String password;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //매번 새롭게 생성되는 password창이기 때문에 password 설정된 메뉴인지체크창 유지하기 위해서
        chkBtn1.setSelected(Root1Controller.menu1PasswordChk);
        chkBtn2.setSelected(Root1Controller.menu2PasswordChk);
        chkBtn3.setSelected(Root1Controller.menu3PasswordChk);
        chkBtn4.setSelected(Root1Controller.menu4PasswordChk);
        chkBtn5.setSelected(Root1Controller.menu5PasswordChk);
        chkBtn6.setSelected(Root1Controller.menu6PasswordChk);
        chkBtn7.setSelected(Root1Controller.menu7PasswordChk);
        chkBtn8.setSelected(Root1Controller.menu8PasswordChk);

        //체크박스가 각각 체크되면 mainroot의 필드에 저장해 놓는다.
        chkBtn1.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu1PasswordChk == true) {
                Root1Controller.menu1PasswordChk = false;
            } else {
                Root1Controller.menu1PasswordChk = true;
            }
        });
        chkBtn2.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu2PasswordChk == true) {
                Root1Controller.menu2PasswordChk = false;
            } else {
                Root1Controller.menu2PasswordChk = true;
            }
        });
        chkBtn3.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu3PasswordChk == true) {
                Root1Controller.menu3PasswordChk = false;
            } else {
                Root1Controller.menu3PasswordChk = true;
            }
        });
        chkBtn4.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu4PasswordChk == true) {
                Root1Controller.menu4PasswordChk = false;
            } else {
                Root1Controller.menu4PasswordChk = true;
            }
        });
        chkBtn5.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu5PasswordChk == true) {
                Root1Controller.menu5PasswordChk = false;
            } else {
                Root1Controller.menu5PasswordChk = true;
            }
        });
        chkBtn6.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu6PasswordChk == true) {
                Root1Controller.menu6PasswordChk = false;
            } else {
                Root1Controller.menu6PasswordChk = true;
            }
        });
        chkBtn7.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu7PasswordChk == true) {
                Root1Controller.menu7PasswordChk = false;
            } else {
                Root1Controller.menu7PasswordChk = true;
            }
        });
        chkBtn8.selectedProperty().addListener((observable) -> {
            if (Root1Controller.menu8PasswordChk == true) {
                Root1Controller.menu8PasswordChk = false;
            } else {
                Root1Controller.menu8PasswordChk = true;
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

    }

    private void handleOk() {
        String passwordValue = password1.getText();
        String passwordValue2 = password2.getText();

        if (Root1Controller.secretCount == 1) {
            if (passwordValue.equals(Root1Controller.password)) {
                Root1Controller.password = passwordValue2;
                //Root1Controller.popup.hide();
                off();
            } else if (resetChk == true) {
                secretCount = 0;
                off();

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        } else if (Root1Controller.secretCount == 2) {
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                try {
                Parent boilerview = FXMLLoader.load(getClass().getResource("boiler.fxml"));
                stackPane.getChildren().add(boilerview);
                boilerview.setTranslateX(0);
                boilerview.setOpacity(0);
                KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            } catch (IOException ex) {}
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        }else if(Root1Controller.secretCount == 3){
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                ////////////////합칠때 추가해야함
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        
        
        }else if(Root1Controller.secretCount == 4){
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                ////////////////합칠때 추가해야함
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        
        
        }else if(Root1Controller.secretCount == 5){
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                ////////////////합칠때 추가해야함
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        
        
        }else if(Root1Controller.secretCount == 6){
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                ////////////////합칠때 추가해야함
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        
        }else if(Root1Controller.secretCount == 7){
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                ////////////////합칠때 추가해야함
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        
        
        }else if(Root1Controller.secretCount == 8){
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                ////////////////합칠때 추가해야함
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        
        
        } else if(Root1Controller.secretCount == 9){
            if (passwordValue.equals(Root1Controller.password)) {
                secretCount = 1;
                off();
                ////////////////합칠때 추가해야함
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        
        
        } else if(Root1Controller.secretCount == 0){    // secretCount=0번일때는 비번설정 처음띄웠을때(비번설정안되있을때),1은 비번설정된상태,2번은 비번설정된 상태에서 2번메뉴아이콘 눌렀을때
            if ((passwordValue.equals(passwordValue2)) && (!password1.getText().isEmpty())) {

                Root1Controller.password = passwordValue;
                secretCount = 1;
                off();

            } else if (resetChk == true) {   //첫번째 화면열었을때 reset을 누르고 확인누르면 카운트 체크 안됨
                secretCount = 0;
                off();

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
        }
    }

    private void off() {
        secret.setOpacity(1);
        secret.setTranslateX(0);
        KeyValue keyValue = new KeyValue(secret.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                (event) -> {
                    Root1Controller.stackPane.getChildren().remove(secret);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
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
        System.out.println("keypad1");//지울거
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
            password1List.remove(password1List.size() - 1);
            password1.setText(field1pswd(0));
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
            password2List.remove(password2List.size() - 1);
            password2.setText(field1pswd(1));
        });

    }

}

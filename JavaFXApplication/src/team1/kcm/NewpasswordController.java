package team1.kcm;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import static team1.kcm.Root1Controller.secretCount;

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
    
    private boolean resetChk=false;
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
        chkBtn1.selectedProperty().addListener((observable) -> {
            Root1Controller.menu1PasswordChk=true;
        });
    }

    private void handleOk() {
        System.out.println("OK");//지워야됨
        String passwordValue; //임시
        String passwordValue2; //임시

        passwordValue = password1.getText();
        passwordValue2 = password2.getText();

        if (Root1Controller.secretCount > 0) {
            if (passwordValue.equals(Root1Controller.password)) {
                Root1Controller.password = passwordValue2;
                //Root1Controller.popup.hide();
                off();
            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        } else {
            if ((passwordValue.equals(passwordValue2))&&(!password1.getText().isEmpty())) {
                
                Root1Controller.password = passwordValue;
                secretCount += 1;
                off();

            }else if(resetChk==true){
                off();
            
            } 
            else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        }

    }
    private void off(){
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
        // password1.setText(input.getValue());
        System.out.println("KEYPAD1 마우스ZERO");
        return input;
    }

    private String oneClicked() {
        String input = "";

        input += key1.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스one");

        return input;

    }

    private String twoClicked() {
        String input = "";
        input += key2.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스two");
        return input;
    }

    private String threeClicked() {
        String input = "";
        input += key3.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스three");
        return input;
    }

    private String fourClicked() {
        String input = "";
        input += key4.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스four");
        return input;
    }

    private String fiveClicked() {
        String input = "";
        input += key5.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스five");
        return input;
    }

    private String sixClicked() {
        String input = "";
        input += key6.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스six");
        return input;
    }

    private String sevenClicked() {
        String input = "";
        input += key7.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스seven");
        return input;
    }

    private String eightClicked() {
        String input = "";
        input += key8.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스eight");
        return input;
    }

    private String nineClicked() {
        String input = "";
        input += key9.getUserData().toString();
        System.out.println(input);
        System.out.println("KEYPAD1 마우스nine");
        return input;
    }

    private String field1pswd(int value) {
        String field1pswdValue = "";
        if (value == 0) {
            for (String text : password1List) {
                field1pswdValue += text;
            }
        } else if (value == 1) {
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
        keydelete.setOnMouseClicked(event -> {  ////////////수정해야됨
            password1List.remove(password1List.size() - 1);
            password1.setText(field1pswd(0));
        });

    }

    private void keypad2() {
        System.out.println("keypad2");//지울거

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

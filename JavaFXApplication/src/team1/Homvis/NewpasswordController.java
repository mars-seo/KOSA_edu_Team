package team1.Homvis;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import static team1.Homvis.MainController.secretCount;
import static team1.Homvis.MainController.menuList;
import static team1.Homvis.MainController.menuicon;
import static team1.Homvis.MainController.miniVeiw;
import static team1.Homvis.MainController.miniWindow;
import static team1.Homvis.MainController.preIndex1;
import static team1.Homvis.MainController.preIndex2;
import static team1.Homvis.MainController.preindex1;
import static team1.Homvis.MainController.preindex2;

public class NewpasswordController implements Initializable {

    @FXML
    private ImageView btnok;
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

    private boolean temp1PasswordChk = MainController.menu1PasswordChk;
    private boolean temp2PasswordChk = MainController.menu2PasswordChk;
    private boolean temp3PasswordChk = MainController.menu3PasswordChk;
    private boolean temp4PasswordChk = MainController.menu4PasswordChk;
    private boolean temp5PasswordChk = MainController.menu5PasswordChk;
    private boolean temp6PasswordChk = MainController.menu6PasswordChk;
    private boolean temp7PasswordChk = MainController.menu7PasswordChk;
    private boolean temp8PasswordChk = MainController.menu8PasswordChk;
    private final int code = MainController.secretCount;  //secret콘트롤 생성된 순간의 secretcount를 기억하기 위해
    private final boolean windowState = MainController.miniWindow;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //매번 새롭게 생성되는 password창이기 때문에 password 설정된 메뉴인지체크창 유지하기 위해서
        chkBtn1.setSelected(MainController.menu1PasswordChk);
        chkBtn2.setSelected(MainController.menu2PasswordChk);
        chkBtn3.setSelected(MainController.menu3PasswordChk);
        chkBtn4.setSelected(MainController.menu4PasswordChk);
        chkBtn5.setSelected(MainController.menu5PasswordChk);
        chkBtn6.setSelected(MainController.menu6PasswordChk);
        chkBtn7.setSelected(MainController.menu7PasswordChk);
        chkBtn8.setSelected(MainController.menu8PasswordChk);

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
        btnok.setOnMousePressed(event -> keyPressed(btnok, "ok"));
        btnok.setOnMouseDragged(event -> keyDragged(btnok, "ok"));
        exit.setOnMousePressed(event -> keyPressed(exit, "exite"));
        exit.setOnMouseDragged(event -> keyDragged(exit, "exite"));

        btnok.setOnMouseClicked(event -> handleOk());
        password1.focusedProperty().addListener((observable) -> {
            keypad();
        });
        password2.focusedProperty().addListener((observable) -> {
            keypad2();
        });

        exit.setOnMouseClicked(event -> off());
        keyreset.setOnMouseClicked(event -> passwordReset());
        keyreset.setOnMousePressed(event -> keyPressed(keyreset, "reset"));
        keyreset.setOnMouseDragged(event -> keyDragged(keyreset, "reset"));

    }

    private void handleOk() {
        btnok.setImage(new Image(getClass().getResource("images/login_ok_default.png").toString()));
        String passwordValue = password1.getText();
        String passwordValue2 = password2.getText();

        if (code == 1) {
            if (!(temp1PasswordChk == false && temp2PasswordChk == false && temp3PasswordChk == false && temp4PasswordChk == false && temp5PasswordChk == false && temp6PasswordChk == false && temp7PasswordChk == false && temp8PasswordChk == false)) {
                if (passwordValue.equals(MainController.password)) {
                    MainController.password = passwordValue2;
                    chkbox();
                    off();
                } else {
                    warning.setText("패스워드를 정확히 입력해주세요.");
                }
            } else {
                warning.setText("비밀번호를 설정할 메뉴를 선택해주세요");
            }
            //////////보일러
        } else if (code == 2) {
            if (passwordValue.equals(MainController.password)) {
                secretCount = 1;
                off();
                miniScreenOpen(1);

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
/////////전기가스제어
        } else if (code == 3) {
            if (passwordValue.equals(MainController.password)) {
                secretCount = 1;
                off();
                miniScreenOpen(2);

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

            ///인터폰
        } else if (code == 4) {
            if (passwordValue.equals(MainController.password)) {
                secretCount = 1;
                off();
                miniScreenOpen(3);

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

            ///인터넷
        } else if (code == 5) {          //
            if (passwordValue.equals(MainController.password)) {
                secretCount = 1;
                off();

                miniScreenOpen(4);

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

            //미디어플레이어
        } else if (code == 6) {
            if (passwordValue.equals(MainController.password)) {
                secretCount = 1;
                off();
                miniScreenOpen(5);

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }
            //사용량조회
        } else if (code == 7) {
            if (passwordValue.equals(MainController.password)) {
                secretCount = 1;
                off();
                miniScreenOpen(6);

            } else {
                warning.setText("패스워드를 정확히 입력해주세요.");
            }

        } else if (MainController.secretCount == 0) {    // secretCount=0번일때는 비번설정 처음띄웠을때(비번설정안되있을때),1은 비번설정된상태,2번은 비번설정된 상태에서 2번메뉴아이콘 눌렀을때
            if (!(temp1PasswordChk == false && temp2PasswordChk == false && temp3PasswordChk == false && temp4PasswordChk == false && temp5PasswordChk == false && temp6PasswordChk == false && temp7PasswordChk == false && temp8PasswordChk == false)) {
                if ((passwordValue.equals(passwordValue2)) && (!password1.getText().isEmpty())) {

                    MainController.password = passwordValue;
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

    private void miniScreenOpen(int value) {
		try {
			if (miniVeiw[value] == null) {
						miniVeiw[value] = FXMLLoader.load(getClass().getResource(menuList.get(value) + "/Mini" + menuList.get(value) + ".fxml"));
						System.out.println("ssss");
					}
			System.out.println("ssss");
					MainController.stackPane.getChildren().add(miniVeiw[value]);
					if (!miniWindow) {

						if (preIndex1 != null) {
							MainController.stackPane.getChildren().remove(preIndex1);
							menuicon[preindex1].setImage(new Image(getClass().getResource("images/main_" + menuList.get(preindex1) + "_default.png").toString()));
							menuicon[preindex1].setDisable(false);
						}
						miniVeiw[value].setTranslateX(0);
						miniVeiw[value].setTranslateY(0);
						preIndex1 = miniVeiw[value];
						preindex1 = value;
					}else {
						if (preIndex2 != null) {
							MainController.stackPane.getChildren().remove(preIndex2);
							menuicon[preindex2].setImage(new Image(getClass().getResource("images/main_" + menuList.get(preindex2) + "_default.png").toString()));
							menuicon[preindex2].setDisable(false);
						}
						miniVeiw[value].setTranslateX(400);
						miniVeiw[value].setTranslateY(0);
						
						preIndex2 = miniVeiw[value];
						preindex2 = value;
					}
					miniWindow = !miniWindow;
					MainController.miniParent.add(miniVeiw[value]);
					System.gc();

		} catch (IOException ex) {
			
		}
    }

    private void chkbox() {
        MainController.menu1PasswordChk = temp1PasswordChk;
        MainController.menu2PasswordChk = temp2PasswordChk;
        MainController.menu3PasswordChk = temp3PasswordChk;
        MainController.menu4PasswordChk = temp4PasswordChk;
        MainController.menu5PasswordChk = temp5PasswordChk;
        MainController.menu6PasswordChk = temp6PasswordChk;
        MainController.menu7PasswordChk = temp7PasswordChk;
        MainController.menu8PasswordChk = temp8PasswordChk;

    }

    private void off() {

        secret.setOpacity(1);
        KeyValue keyValue = new KeyValue(secret.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
                (event) -> {
                    MainController.stackPane.getChildren().remove(secret);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        MainController.menuicon[0].setImage(new Image(getClass().getResource("images/main_home_default.png").toString()));
        MainController.menuicon[1].setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
        MainController.menuicon[2].setImage(new Image(getClass().getResource("images/main_elecNgas_default.png").toString()));
        MainController.menuicon[3].setImage(new Image(getClass().getResource("images/main_interphone_default.png").toString()));
        MainController.menuicon[4].setImage(new Image(getClass().getResource("images/main_internet_default.png").toString()));
        MainController.menuicon[5].setImage(new Image(getClass().getResource("images/main_player_default.png").toString()));
        MainController.menuicon[6].setImage(new Image(getClass().getResource("images/main_tariff_default.png").toString()));
        MainController.menuicon[7].setImage(new Image(getClass().getResource("images/main_secret_default.png").toString()));

        MainController.menuicon[7].setDisable(false);
    }

    private void keyClicked(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/login_" + name + "_default.png").toString()));
    }

    private void keyDragged(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/login_" + name + "_default.png").toString()));
    }

    private void keyPressed(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/login_" + name + "_clicked.png").toString()));
    }

    private String zeroClicked() {
        keyClicked(key0, "0");
        String input = "";
        input += key0.getUserData().toString();
        return input;
    }

    private String oneClicked() {
        keyClicked(key1, "1");
        key1.setImage(new Image(getClass().getResource("images/login_1_default.png").toString()));
        String input = "";
        input += key1.getUserData().toString();
        return input;
    }

    private String twoClicked() {
        keyClicked(key2, "2");
        key2.setImage(new Image(getClass().getResource("images/login_2_default.png").toString()));
        String input = "";
        input += key2.getUserData().toString();
        return input;
    }

    private String threeClicked() {
        keyClicked(key3, "3");
        String input = "";
        input += key3.getUserData().toString();
        return input;
    }

    private String fourClicked() {
        keyClicked(key4, "4");
        String input = "";
        input += key4.getUserData().toString();
        return input;
    }

    private String fiveClicked() {
        keyClicked(key5, "5");
        String input = "";
        input += key5.getUserData().toString();
        return input;
    }

    private String sixClicked() {
        keyClicked(key6, "6");
        String input = "";
        input += key6.getUserData().toString();
        return input;
    }

    private String sevenClicked() {
        keyClicked(key7, "7");
        String input = "";
        input += key7.getUserData().toString();
        return input;
    }

    private String eightClicked() {
        keyClicked(key8, "8");
        String input = "";
        input += key8.getUserData().toString();
        return input;
    }

    private String nineClicked() {
        keyClicked(key9, "9");
        String input = "";
        input += key9.getUserData().toString();
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
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        key0.setOnMousePressed(event -> keyPressed(key0, "0"));
        key1.setOnMousePressed(event -> keyPressed(key1, "1"));
        key2.setOnMousePressed(event -> keyPressed(key2, "2"));
        key3.setOnMousePressed(event -> keyPressed(key3, "3"));
        key4.setOnMousePressed(event -> keyPressed(key4, "4"));
        key5.setOnMousePressed(event -> keyPressed(key5, "5"));
        key6.setOnMousePressed(event -> keyPressed(key6, "6"));
        key7.setOnMousePressed(event -> keyPressed(key7, "7"));
        key8.setOnMousePressed(event -> keyPressed(key8, "8"));
        key9.setOnMousePressed(event -> keyPressed(key9, "9"));
        keydelete.setOnMousePressed(event -> keyPressed(keydelete, "delete"));
        key0.setOnMouseDragged(event -> keyDragged(key0, "0"));
        key1.setOnMouseDragged(event -> keyDragged(key1, "1"));
        key2.setOnMouseDragged(event -> keyDragged(key2, "2"));
        key3.setOnMouseDragged(event -> keyDragged(key3, "3"));
        key4.setOnMouseDragged(event -> keyDragged(key4, "4"));
        key5.setOnMouseDragged(event -> keyDragged(key5, "5"));
        key6.setOnMouseDragged(event -> keyDragged(key6, "6"));
        key7.setOnMouseDragged(event -> keyDragged(key7, "7"));
        key8.setOnMouseDragged(event -> keyDragged(key8, "8"));
        key9.setOnMouseDragged(event -> keyDragged(key9, "9"));
        keydelete.setOnMouseDragged(event -> keyDragged(keydelete, "delete"));

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
            keyClicked(keydelete, "delete");
            if (!password1List.isEmpty()) {
                password1List.remove(password1List.size() - 1);
                password1.setText(field1pswd(0));
            }
        });

    }

    private void keypad2() {
        keypadroot.setTranslateX(0);
        KeyValue keyValue = new KeyValue(keypadroot.opacityProperty(), 1);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        key0.setOnMousePressed(event -> keyPressed(key0, "0"));
        key1.setOnMousePressed(event -> keyPressed(key1, "1"));
        key2.setOnMousePressed(event -> keyPressed(key2, "2"));
        key3.setOnMousePressed(event -> keyPressed(key3, "3"));
        key4.setOnMousePressed(event -> keyPressed(key4, "4"));
        key5.setOnMousePressed(event -> keyPressed(key5, "5"));
        key6.setOnMousePressed(event -> keyPressed(key6, "6"));
        key7.setOnMousePressed(event -> keyPressed(key7, "7"));
        key8.setOnMousePressed(event -> keyPressed(key8, "8"));
        key9.setOnMousePressed(event -> keyPressed(key9, "9"));
        key0.setOnMouseDragged(event -> keyDragged(key0, "0"));
        key1.setOnMouseDragged(event -> keyDragged(key1, "1"));
        key2.setOnMouseDragged(event -> keyDragged(key2, "2"));
        key3.setOnMouseDragged(event -> keyDragged(key3, "3"));
        key4.setOnMouseDragged(event -> keyDragged(key4, "4"));
        key5.setOnMouseDragged(event -> keyDragged(key5, "5"));
        key6.setOnMouseDragged(event -> keyDragged(key6, "6"));
        key7.setOnMouseDragged(event -> keyDragged(key7, "7"));
        key8.setOnMouseDragged(event -> keyDragged(key8, "8"));
        key9.setOnMouseDragged(event -> keyDragged(key9, "9"));

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
            keyClicked(keydelete, "delete");
            if (!password2List.isEmpty()) {

                password2List.remove(password2List.size() - 1);
                password2.setText(field1pswd(1));
            }
        });

    }

    private void passwordReset() {
        secretCount = 0;
        MainController.password = "";
        MainController.menu1PasswordChk = false;
        MainController.menu2PasswordChk = false;
        MainController.menu3PasswordChk = false;
        MainController.menu4PasswordChk = false;
        MainController.menu5PasswordChk = false;
        MainController.menu6PasswordChk = false;
        MainController.menu7PasswordChk = false;
        MainController.menu8PasswordChk = false;
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
				keyreset.setImage(new Image(getClass().getResource("images/login_reset_default.png").toString()));
    }

}

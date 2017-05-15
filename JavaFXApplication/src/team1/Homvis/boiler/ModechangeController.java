package team1.Homvis.boiler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static team1.Homvis.boiler.BoilerController.boilerModeStack;
import static team1.Homvis.boiler.BoilerminiController.ecomodeState;
import static team1.Homvis.boiler.BoilerminiController.nightmodeState;
import static team1.Homvis.boiler.BoilerminiController.usermodeState;
import team1.Homvis.MainController;

public class ModechangeController implements Initializable {

    @FXML
    private ImageView ecoMode;
    @FXML
    private ImageView userMode;
    @FXML
    private ImageView nightMode;
    @FXML
    private ImageView ok;
    @FXML
    private AnchorPane userModeView;
    @FXML
    private ImageView am;
    @FXML
    private ImageView pm;
    @FXML
    private ImageView one;
    @FXML
    private ImageView two;
    @FXML
    private ImageView three;
    @FXML
    private ImageView four;
    @FXML
    private ImageView five;
    @FXML
    private ImageView six;
    @FXML
    private ImageView seven;
    @FXML
    private ImageView eight;
    @FXML
    private ImageView nine;
    @FXML
    private ImageView ten;
    @FXML
    private ImageView eleven;
    @FXML
    private ImageView twelve;

    private boolean amState = true;
    private List<String> imageName = new ArrayList<>();
    private List<ImageView> keyList = new ArrayList<>();

    private boolean numStateChk1 = false;
    private boolean numStateChk2 = false;
    private boolean numStateChk3 = false;
    private boolean numStateChk4 = false;
    private boolean numStateChk5 = false;
    private boolean numStateChk6 = false;
    private boolean numStateChk7 = false;
    private boolean numStateChk8 = false;
    private boolean numStateChk9 = false;
    private boolean numStateChk10 = false;
    private boolean numStateChk11 = false;
    private boolean numStateChk12 = false;
    private boolean numStateChk13 = false;
    private boolean numStateChk14 = false;
    private boolean numStateChk15 = false;
    private boolean numStateChk16 = false;
    private boolean numStateChk17 = false;
    private boolean numStateChk18 = false;
    private boolean numStateChk19 = false;
    private boolean numStateChk20 = false;
    private boolean numStateChk21 = false;
    private boolean numStateChk22 = false;
    private boolean numStateChk23 = false;
    private boolean numStateChk24 = false;

    private boolean[] amNumchk = {numStateChk1, numStateChk2, numStateChk3, numStateChk4, numStateChk5, numStateChk6,
        numStateChk7, numStateChk8, numStateChk9, numStateChk10, numStateChk11, numStateChk12};
    private boolean[] pmNumchk = {numStateChk13, numStateChk14, numStateChk15, numStateChk16, numStateChk17, numStateChk18,
        numStateChk19, numStateChk20, numStateChk21, numStateChk22, numStateChk23, numStateChk24};

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        imageName.add("boiler_timesetup_1_clicked");
        imageName.add("boiler_timesetup_2_clicked");
        imageName.add("boiler_timesetup_3_clicked");
        imageName.add("boiler_timesetup_4_clicked");
        imageName.add("boiler_timesetup_5_clicked");
        imageName.add("boiler_timesetup_6_clicked");
        imageName.add("boiler_timesetup_7_clicked");
        imageName.add("boiler_timesetup_8_clicked");
        imageName.add("boiler_timesetup_9_clicked");
        imageName.add("boiler_timesetup_10_clicked");
        imageName.add("boiler_timesetup_11_clicked");
        imageName.add("boiler_timesetup_12_clicked");
        imageName.add("boiler_timesetup_1_default");
        imageName.add("boiler_timesetup_2_default");
        imageName.add("boiler_timesetup_3_default");
        imageName.add("boiler_timesetup_4_default");
        imageName.add("boiler_timesetup_5_default");
        imageName.add("boiler_timesetup_6_default");
        imageName.add("boiler_timesetup_7_default");
        imageName.add("boiler_timesetup_8_default");
        imageName.add("boiler_timesetup_9_default");
        imageName.add("boiler_timesetup_10_default");
        imageName.add("boiler_timesetup_11_default");
        imageName.add("boiler_timesetup_12_default");

        keyList.add(one);
        keyList.add(two);
        keyList.add(three);
        keyList.add(four);
        keyList.add(five);
        keyList.add(six);
        keyList.add(seven);
        keyList.add(eight);
        keyList.add(nine);
        keyList.add(ten);
        keyList.add(eleven);
        keyList.add(twelve);

        userModeView.setOpacity(0);

        ecoMode.setOnMouseClicked(event -> ecoMode());
        userMode.setOnMouseClicked(event -> userMode());
        nightMode.setOnMouseClicked(event -> nightMode());
        ok.setOnMouseClicked(event -> ok());
        am.setOnMousePressed(event -> am());
        pm.setOnMousePressed(event -> pm());
        one.setOnMouseClicked(event -> timeSetting(one, 0));
        two.setOnMouseClicked(event -> timeSetting(two, 1));
        three.setOnMouseClicked(event -> timeSetting(three, 2));
        four.setOnMouseClicked(event -> timeSetting(four, 3));
        five.setOnMouseClicked(event -> timeSetting(five, 4));
        six.setOnMouseClicked(event -> timeSetting(six, 5));
        seven.setOnMouseClicked(event -> timeSetting(seven, 6));
        eight.setOnMouseClicked(event -> timeSetting(eight, 7));
        nine.setOnMouseClicked(event -> timeSetting(nine, 8));
        ten.setOnMouseClicked(event -> timeSetting(ten, 9));
        eleven.setOnMouseClicked(event -> timeSetting(eleven, 10));
        twelve.setOnMouseClicked(event -> timeSetting(twelve, 11));

    }

    private void ecoMode() {
        for (ImageView bar : BoilerController.barList) {
            bar.setOpacity(0);
        }
        for (int i = 0; i < BoilerminiController.barStateArray.length; i++) {
            BoilerminiController.barStateArray[i] = false;
        }
        ///////////4시간에 한번씩 돌아가는 에코모드
        for (int i = 0; i < 6; i++) {
            BoilerController.barList.get(i * 4).setOpacity(1);
            BoilerminiController.barStateArray[i * 4] = true;
        }

        userModeView.setOpacity(0);
        if (ecomodeState == false) {

            BoilerController.modeImage.setOpacity(1);
            keyPressed(ecoMode,"timesetup_modeECO"); //ecomode On됬을때 사진넣기
            keyDefault(userMode, "timesetup_modeUSER");
            keyDefault(nightMode, "timesetup_modeSLEEPING");
            ecomodeState = true;
            nightmodeState = false;
            usermodeState = false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/boiler_modesECO.png").toString()));
        } else {
            keyDefault(ecoMode,"timesetup_modeECO");
            ecomodeState = false;
            BoilerController.modeImage.setOpacity(0);
        }
    }

    private void userMode() {
        for (ImageView bar : BoilerController.barList) {
            bar.setOpacity(0);
        }
        for (int i = 0; i < 24; i++) {
            if (BoilerminiController.barStateArray[i] == true) {
                BoilerController.barList.get(i).setOpacity(1);
            } else {
                BoilerController.barList.get(i).setOpacity(0);
            }
        }

        if (usermodeState == false) {
            userModeView.setOpacity(1);
            keyPressed(userMode,"timesetup_modeUSER"); //ecomode On됬을때 사진넣기
            keyDefault(ecoMode, "timesetup_modeECO");
            keyDefault(nightMode, "timesetup_modeSLEEPING");  //ecomode On됬을때 사진넣기
            BoilerController.modeImage.setOpacity(1);
            usermodeState = true;
            nightmodeState = false;
            ecomodeState = false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/boiler_modeUSER.png").toString()));
        } else {
            userModeView.setOpacity(0);
            keyDefault(userMode,"timesetup_modeUSER");//dcomode off됬을때 사진넣기
            usermodeState = false;
            BoilerController.modeImage.setOpacity(0);
        }

    }

    private void nightMode() {
        for (ImageView bar : BoilerController.barList) {
            bar.setOpacity(0);
        }
        for (int i = 0; i < BoilerminiController.barStateArray.length; i++) {
            BoilerminiController.barStateArray[i] = false;
        }

        //숙면을 취할수 있게 해주는모드
        for (int i = 1; i < 3; i++) {
            BoilerController.barList.get(i).setOpacity(1);
            BoilerminiController.barStateArray[i] = true;
        }
        for (int i = 5; i < 7; i++) {
            BoilerController.barList.get(i).setOpacity(1);
            BoilerminiController.barStateArray[i] = true;
        }
        for (int i = 12; i < 14; i++) {
            BoilerController.barList.get(i).setOpacity(1);
            BoilerminiController.barStateArray[i] = true;
        }
        for (int i = 18; i < 19; i++) {
            BoilerController.barList.get(i).setOpacity(1);
            BoilerminiController.barStateArray[i] = true;
        }

        userModeView.setOpacity(0);
        if (nightmodeState == false) {
            
             keyPressed(nightMode,"timesetup_modeSLEEPING"); //ecomode On됬을때 사진넣기
            keyDefault(ecoMode, "timesetup_modeECO");
            keyDefault(userMode, "timesetup_modeUSER");

            nightmodeState = true;
            usermodeState = false;
            ecomodeState = false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/boiler_modeSLEEPING.png").toString()));   //boiler쪽 mode이미지변경
            BoilerController.modeImage.setOpacity(1);
        } else {
            keyDefault(nightMode, "timesetup_modeSLEEPING");//nightmode off됬을때 사진넣기
            nightmodeState = false;
            BoilerController.modeImage.setOpacity(0);
        }

    }

    private void ok() {
        BoilerController.boilerModeStack.getChildren().remove(BoilerController.boilermodeView);
        BoilerController.count = 0;
    }

    private void timeSetting(ImageView number, int value) {
        if (amState == true) {   ///am 선택시
            if (BoilerminiController.barStateArray[value] == false) { //해당번호가 체크 되어있는지
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value) + ".png").toString()));
                BoilerController.barList.get(value).setOpacity(1);
                BoilerminiController.barStateArray[value] = true;
            } else {
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value + 12) + ".png").toString()));
                BoilerminiController.barStateArray[value] = false;
                BoilerController.barList.get(value).setOpacity(0);

            }
        } else {  //pm 선택시
            if (BoilerminiController.barStateArray[value + 12] == false) { //해당번호가 체크 되어있는지
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value) + ".png").toString()));
                BoilerController.barList.get(value + 12).setOpacity(1);
                BoilerminiController.barStateArray[value + 12] = true;
            } else {
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value + 12) + ".png").toString()));
                BoilerminiController.barStateArray[value + 12] = false;
                BoilerController.barList.get(value + 12).setOpacity(0);
            }

        }
    }

    private void am() {
        for (int i = 0; i < 12; i++) {
            if (BoilerminiController.barStateArray[i] == true) {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i) + ".png").toString()));
            } else {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i + 12) + ".png").toString()));
            }
        }
        amState = true;
        keyPressed(am,"timesetup_am"); //am상태 on
        keyDefault(pm,"timesetup_pm"); //pm 상태 off

    //    for (ImageView key : keyList) {

      //  }
    }

    private void pm() {
        for (int i = 0; i < 12; i++) {
            if (BoilerminiController.barStateArray[i+12] == true) {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i) + ".png").toString()));

            } else {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i + 12) + ".png").toString()));
            }
        }
        amState = false;
        keyPressed(pm,"timesetup_pm");//pm상태 on
        keyDefault(am,"timesetup_am");//am상태 off
    }

    private void keyDefault(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/boiler_" + name + "_default.png").toString()));
    }

    private void keyDragged(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/boiler_" + name + "_default.png").toString()));
    }

    private void keyPressed(ImageView image, String name) {
        image.setImage(new Image(getClass().getResource("images/boiler_" + name + "_clicked.png").toString()));
    }

}

package team1.Homvis.boiler;

import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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

        imageName.add("boiler_one_clicked");
        imageName.add("boiler_two_clicked");
        imageName.add("boiler_three_clicked");
        imageName.add("boiler_four_clicked");
        imageName.add("boiler_five_clicked");
        imageName.add("boiler_six_clicked");
        imageName.add("boiler_seven_clicked");
        imageName.add("boiler_eight_clicked");
        imageName.add("boiler_nine_clicked");
        imageName.add("boiler_ten_clicked");
        imageName.add("boiler_eleven_clicked");
        imageName.add("boiler_twelve_clicked");
        imageName.add("one");
        imageName.add("two");
        imageName.add("three");
        imageName.add("four");
        imageName.add("five");
        imageName.add("six");
        imageName.add("seven");
        imageName.add("eight");
        imageName.add("nine");
        imageName.add("ten");
        imageName.add("eleven");
        imageName.add("twelve");

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
        ///////////4시간에 한번씩 돌아가는 에코모드
        for(int i=0;i<6;i++){
            BoilerController.barList.get(i*4).setOpacity(1);
        }
        
        userModeView.setOpacity(0);
        if (BoilerController.ecomodeState == false) {

            BoilerController.modeImage.setOpacity(1);
            ecoMode.setImage(new Image(getClass().getResource("images/ecoOn.png").toString()));   //ecomode On됬을때 사진넣기
            userMode.setImage(new Image(getClass().getResource("images/usermode.PNG").toString()));
            nightMode.setImage(new Image(getClass().getResource("images/nightmode.PNG").toString()));
            BoilerController.ecomodeState = true;
            BoilerController.nightmodeState = false;
            BoilerController.usermodeState = false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/ecoOn.png").toString()));
        } else {
            ecoMode.setImage(new Image(getClass().getResource("images/ecomode.PNG").toString()));//dcomode off됬을때 사진넣기
            BoilerController.ecomodeState = false;
            BoilerController.modeImage.setOpacity(0);
        }
    }

    private void userMode() {
        for (ImageView bar : BoilerController.barList) {
            bar.setOpacity(0);
        }
        for (int i = 0; i < 12; i++) {
            if (amNumchk[i] == true) {
                BoilerController.barList.get(i).setOpacity(1);
            } else {
                BoilerController.barList.get(i).setOpacity(0);
            }
        }
        for (int i = 0; i < 12; i++) {
            if (pmNumchk[i] == true) {
               BoilerController.barList.get(i+12).setOpacity(1);

            } else {
                BoilerController.barList.get(i+12).setOpacity(0);
            }
        }

        if (BoilerController.usermodeState == false) {
            userModeView.setOpacity(1);
            userMode.setImage(new Image(getClass().getResource("images/userOn.PNG").toString()));   //ecomode On됬을때 사진넣기
            ecoMode.setImage(new Image(getClass().getResource("images/ecomode.PNG").toString()));
            nightMode.setImage(new Image(getClass().getResource("images/nightmode.PNG").toString()));
            BoilerController.modeImage.setOpacity(1);
            BoilerController.usermodeState = true;
            BoilerController.nightmodeState = false;
            BoilerController.ecomodeState = false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/userOn.PNG").toString()));
        } else {
            userModeView.setOpacity(0);
            userMode.setImage(new Image(getClass().getResource("images/usermode.PNG").toString()));//dcomode off됬을때 사진넣기
            BoilerController.usermodeState = false;
            BoilerController.modeImage.setOpacity(0);
        }

    }

    private void nightMode() {
        for (ImageView bar : BoilerController.barList) {
            bar.setOpacity(0);
        }
        
        //숙면을 취할수 있게 해주는모드
        for(int i=1;i<3;i++){
            BoilerController.barList.get(i).setOpacity(1);
        }
        for(int i=5;i<7;i++){
            BoilerController.barList.get(i).setOpacity(1);
        }
        for(int i=12;i<14;i++){
            BoilerController.barList.get(i).setOpacity(1);
        }
        for(int i=18;i<19;i++){
            BoilerController.barList.get(i).setOpacity(1);
        }
        
        userModeView.setOpacity(0);
        if (BoilerController.nightmodeState == false) {

            nightMode.setImage(new Image(getClass().getResource("images/nightmodeOn.PNG").toString()));   //nightmode On됬을때 사진넣기
            userMode.setImage(new Image(getClass().getResource("images/usermode.PNG").toString()));   //nightmode On됬을때 사진넣기
            ecoMode.setImage(new Image(getClass().getResource("images/ecomode.PNG").toString()));   //nightmode On됬을때 사진넣기
            BoilerController.nightmodeState = true;
            BoilerController.usermodeState = false;
            BoilerController.ecomodeState = false;
            BoilerController.modeImage.setImage(new Image(getClass().getResource("images/nightmodeOn.PNG").toString()));   //boiler쪽 mode이미지변경
            BoilerController.modeImage.setOpacity(1);
        } else {
            nightMode.setImage(new Image(getClass().getResource("images/nightmode.png").toString()));//nightmode off됬을때 사진넣기
            BoilerController.nightmodeState = false;
            BoilerController.modeImage.setOpacity(0);
        }

    }

    private void ok() {
        BoilerController.boilerModeStack.getChildren().remove(BoilerController.boilermodeView);
        BoilerController.count = 0;
    }

    private void timeSetting(ImageView number, int value) {
        if (amState == true) {   ///am 선택시
            if (amNumchk[value] == false) { //해당번호가 체크 되어있는지
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value) + ".png").toString()));
                BoilerController.barList.get(value).setOpacity(1);
                amNumchk[value] = true;
            } else {
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value + 12) + ".png").toString()));
                amNumchk[value] = false;
                BoilerController.barList.get(value).setOpacity(0);

            }
        } else {  //pm 선택시
            if (pmNumchk[value] == false) { //해당번호가 체크 되어있는지
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value) + ".png").toString()));
                BoilerController.barList.get(value + 12).setOpacity(1);
                pmNumchk[value] = true;
            } else {
                number.setImage(new Image(getClass().getResource("images/" + imageName.get(value + 12) + ".png").toString()));
                pmNumchk[value] = false;
                BoilerController.barList.get(value + 12).setOpacity(0);
            }

        }
    }

    private void am() {
        for (int i = 0; i < 12; i++) {
            if (amNumchk[i] == true) {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i) + ".png").toString()));
            } else {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i + 12) + ".png").toString()));
            }
        }
        amState = true;
        am.setImage(new Image(getClass().getResource("images/ecoOn.png").toString())); //am상태 on
        pm.setImage(new Image(getClass().getResource("images/pm.PNG").toString())); //pm 상태 off

        for (ImageView key : keyList) {

        }
    }

    private void pm() {
        for (int i = 0; i < 12; i++) {
            if (pmNumchk[i] == true) {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i) + ".png").toString()));

            } else {
                keyList.get(i).setImage(new Image(getClass().getResource("images/" + imageName.get(i + 12) + ".png").toString()));
            }
        }
        amState = false;
        pm.setImage(new Image(getClass().getResource("images/ecoOn.png").toString()));//pm상태 on
        am.setImage(new Image(getClass().getResource("images/am.PNG").toString()));//am상태 off
    }

}

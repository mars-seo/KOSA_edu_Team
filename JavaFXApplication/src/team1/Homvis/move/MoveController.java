package team1.Homvis.move;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class MoveController implements Initializable {

    @FXML
    private ImageView imgSun;
    @FXML
    private ImageView imgMoon;
    @FXML
    private ImageView imgBack;

    private PathTransition pathTransition = new PathTransition();
    private PathTransition pathTransition2 = new PathTransition();
    private LocalDateTime now = LocalDateTime.now();
    private int hour = now.getHour();
    private int minute = now.getMinute();
    private int sec = now.getSecond();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // 해와 달을 이동시키는 메소드 호출
        handleSunMoonChange();

        // 시간에 따라 배경을 변경시키는 메소드 호출
        handleBackChange();

    }

    // 해와 달을 이동시키는 메소드
    private void handleSunMoonChange() {

        Path path = new Path();
        // MoveTo (x , y)    시작 위치 좌표
        path.getElements().add(new MoveTo(400, 700));
        // 각도 / 끝 위치 좌표
        ArcTo arcTo = new ArcTo(12, 10, 0, 400, 50, true, false);
        ArcTo arcTo2 = new ArcTo(12, 10, 0, 400, 700, true, false);

        // 두개를 합쳐서 타원형으로 이동시킴
        path.getElements().add(arcTo);
        path.getElements().add(arcTo2);

        // 실제
//        pathTransition.setDuration(Duration.hours(24));
        // 테스트 60초 (하루를 60초로 정함)
        pathTransition.setDuration(Duration.seconds(60));
        pathTransition.setNode(imgSun);
        pathTransition.setPath(path);
        pathTransition.setOrientation(OrientationType.NONE);
        pathTransition.setCycleCount(Integer.MAX_VALUE);
        pathTransition.setAutoReverse(false);
        // 같은 속도로 진행하도록
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.play();
        // 실제 시간에 맞는 곳에서 시작
//        pathTransition.jumpTo(Duration.minutes(hour * 60 + minute));
        // 테스트 현재 초를 기준(0초: 0시 / 30초: 12시)
        pathTransition.jumpTo(Duration.seconds(sec));

        // 달 
        Path path2 = new Path();
        // MoveTo (x , y)    시작 위치 좌표
        path2.getElements().add(new MoveTo(400, 50));
        // 각도 / 끝 위치 좌표
        arcTo = new ArcTo(12, 10, 0, 400, 50, true, false);
        arcTo2 = new ArcTo(12, 10, 0, 400, 700, true, false);
// 두개를 합쳐서 타원형으로 이동시킴
        path2.getElements().add(arcTo2);
        path2.getElements().add(arcTo);

        // 실제
//        pathTransition2.setDuration(Duration.hours(24));
        // 테스트 60초 (하루를 60초로 정함)
        pathTransition2.setDuration(Duration.seconds(60));
        pathTransition2.setNode(imgMoon);
        pathTransition2.setPath(path2);
        pathTransition2.setOrientation(OrientationType.NONE);
        pathTransition2.setCycleCount(Integer.MAX_VALUE);
        pathTransition2.setAutoReverse(false);
        // 같은 속도로 진행하도록
        pathTransition2.setInterpolator(Interpolator.LINEAR);
        pathTransition2.play();
        // 실제 시간에 맞는 곳에서 시작
//        pathTransition2.jumpTo(Duration.minutes(hour * 60 + minute));
        // 테스트 현재 초를 기준(0초: 0시 / 30초: 12시)
        pathTransition2.jumpTo(Duration.seconds(sec));

    }
    
    // 시간에 따라 배경을 변경시키는 메소드
    private void handleBackChange() {
        // 시간에 따른 배경 변경
        // 현재는 6시와 18시를 기준으로 2번만 변경됨
        // 이미지가 충분히 존재한다면 더 쪼갤 수 있음
        // 배경의 투명도 설정
        imgBack.setOpacity(0.8);

        Thread thread = new Thread(() -> {
            String imgTime = "";
            while (true) {
                // 현재는 하루가 60초인 경우로 나타낸 것, 5초가 2시간
                // 24시 기준으로 하려면 getHour() <=2 
                // 2시간 단위로 하면 됨
                if (LocalDateTime.now().getSecond() <= 5) {
                    imgTime = "images/2.png";
                } else if (LocalDateTime.now().getSecond() <= 10) {
                    imgTime = "images/2.png";
                } else if (LocalDateTime.now().getSecond() <= 15) {
                    imgTime = "images/2.png";
                } else if (LocalDateTime.now().getSecond() <= 20) {
                    imgTime = "images/1.png";
                } else if (LocalDateTime.now().getSecond() <= 25) {
                    imgTime = "images/1.png";
                } else if (LocalDateTime.now().getSecond() <= 30) {
                    imgTime = "images/1.png";
                } else if (LocalDateTime.now().getSecond() <= 35) {
                    imgTime = "images/1.png";
                } else if (LocalDateTime.now().getSecond() <= 40) {
                    imgTime = "images/1.png";
                } else if (LocalDateTime.now().getSecond() <= 45) {
                    imgTime = "images/1.png";
                } else if (LocalDateTime.now().getSecond() <= 50) {
                    imgTime = "images/2.png";
                } else if (LocalDateTime.now().getSecond() <= 55) {
                    imgTime = "images/2.png";
                } else if (LocalDateTime.now().getSecond() <= 60) {
                    imgTime = "images/2.png";
                }
                imgBack.setImage(new Image(getClass().getResource(imgTime).toString()));
                // 현재 60초 기준
                System.out.println(LocalDateTime.now().getSecond() + "초");
                try {
                    // 테스트시 1초마다 검사
                    Thread.sleep(1000);
                    // 실제는 10분마다 검사
//                    Thread.sleep(1000 * 60 * 10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}

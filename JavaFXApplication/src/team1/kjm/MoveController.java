package team1.kjm;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class MoveController implements Initializable {

    @FXML
    private ImageView imgSun;
    PathTransition pathTransition = new PathTransition();    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // 두개의 패스를 합쳐서 타원형으로 이동시킴
        Path path = new Path();
        // MoveTo (x , y)    시작 위치 좌표
        path.getElements().add(new MoveTo(400, 700));
        // 각도 / 끝 위치 좌표
        ArcTo arcTo = new ArcTo(12, 10, 0, 400, 50, true, false);
        Path path2 = new Path();        
        path2.getElements().add(new MoveTo(400, 50));
        ArcTo arcTo2 = new ArcTo(12, 10, 0, 400, 700, true, false);

        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();

        path.getElements().add(arcTo);
        path.getElements().add(arcTo2);

        // 실제
//        pathTransition.setDuration(Duration.hours(24));
        // 테스트 24초 (하루를 24초로 정함)
        pathTransition.setDuration(Duration.seconds(24));
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
        // 테스트 6시 기준 시작 (6초)
        pathTransition.jumpTo(Duration.seconds(6));
    }

}

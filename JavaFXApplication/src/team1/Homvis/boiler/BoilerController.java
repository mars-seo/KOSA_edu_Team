package team1.Homvis.boiler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import team1.Homvis.main.mainController;

public class BoilerController implements Initializable {

    @FXML
    private AnchorPane boilerRoot;
    @FXML
    private ImageView exit;
    @FXML
    private BarChart<String, Integer> barChar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exit.setOnMouseClicked(event -> exit());

        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("남자");
        ObservableList<XYChart.Data<String, Integer>> data2 = FXCollections.observableArrayList();

        data2.add(new XYChart.Data<String, Integer>("0", 10));
        data2.add(new XYChart.Data<String, Integer>("1", 10));
        data2.add(new XYChart.Data<String, Integer>("2", 10));
        data2.add(new XYChart.Data<String, Integer>("3", 10));
        data2.add(new XYChart.Data<String, Integer>("4", 10));
        data2.add(new XYChart.Data<String, Integer>("5", 10));
        data2.add(new XYChart.Data<String, Integer>("6", 10));
        data2.add(new XYChart.Data<String, Integer>("7", 10));
        data2.add(new XYChart.Data<String, Integer>("8", 10));
        data2.add(new XYChart.Data<String, Integer>("9", 10));
        data2.add(new XYChart.Data<String, Integer>("10", 10));
        data2.add(new XYChart.Data<String, Integer>("11", 10));
        data2.add(new XYChart.Data<String, Integer>("12", 10));
        data2.add(new XYChart.Data<String, Integer>("15", 10));
        data2.add(new XYChart.Data<String, Integer>("18", 10));
        data2.add(new XYChart.Data<String, Integer>("21", 10));
        data2.add(new XYChart.Data<String, Integer>("24", 10));
        series1.setData(data2);
        barChar.getData().add(series1);
    }

    private void exit() {
        mainController.menuicon2.setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
        mainController.stackPane.getChildren().remove(boilerRoot);
        /*     boilerRoot.setOpacity(1);
        boilerRoot.setTranslateX(0);
        KeyValue keyValue = new KeyValue(boilerRoot.opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
                (event) -> {
                    Root1Controller.stackPane.getChildren().remove(boilerRoot);
                },
                keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        Root1Controller.menuicon2.setImage(new Image(getClass().getResource("images/main_boiler_default.png").toString()));
         */

    }

}

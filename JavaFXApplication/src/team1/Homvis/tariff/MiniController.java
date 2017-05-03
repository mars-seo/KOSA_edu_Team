package team1.Homvis.tariff;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class MiniController implements Initializable {

    @FXML
    private Label gasFee;

    @FXML
    private Label electricFee;
    @FXML
    private Label waterFee;
    @FXML
    private PieChart pieChart;

    public MiniController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalDateTime now = LocalDateTime.now();
        int DateDay = now.getDayOfMonth();
        int Hour = now.getHour();
        int Minute = now.getMinute();
        int Second = now.getSecond();
        int feeNumber = (DateDay * 24 * 60 * 60 + Hour * 60 * 60 + Minute * 60 + Second) / 20000;
        String gasNowFee = String.valueOf(feeNumber * 300) ;
        String waterNowFee = String.valueOf(feeNumber * 100) ;
        String electricNowFee = String.valueOf(feeNumber * 200) ;
        gasFee.setText(gasNowFee);
        waterFee.setText(waterNowFee);
        electricFee.setText(electricNowFee);

        pieChart.setData(FXCollections.observableArrayList(
                new PieChart.Data("가스", Double.valueOf(gasNowFee)),
                new PieChart.Data("전기", Double.valueOf(electricNowFee)),
                new PieChart.Data("수도", Double.valueOf(waterNowFee))
        ));

    }

}

package team1.Homvis.tariff;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class GasController implements Initializable {

    @FXML
    private ImageView chartButton;
    @FXML
    private TableView<Fee> tableView;
    @FXML
    private Label howManyUseLabel;
    @FXML
    private Label howManyFeeLabel;

    @FXML
    private StackPane mainStackPane;

    private static StackPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = mainStackPane;
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        TableColumn tc2 = tableView.getColumns().get(2);
        TableColumn tc3 = tableView.getColumns().get(3);

        tc0.setCellValueFactory(new PropertyValueFactory<Fee, String>("month"));
        tc1.setCellValueFactory(new PropertyValueFactory<Fee, String>("howManyUse"));
        tc2.setCellValueFactory(new PropertyValueFactory<Fee, String>("fee"));
        tc3.setCellValueFactory(new PropertyValueFactory<Fee, String>("check"));

        tc0.setStyle("-fx-alignment: CENTER;");
        tc1.setStyle("-fx-alignment: CENTER;");
        tc2.setStyle("-fx-alignment: CENTER;");
        tc3.setStyle("-fx-alignment: CENTER;");

        ObservableList<Fee> list = FXCollections.observableArrayList();
        LocalDateTime now = LocalDateTime.now();
        int DateDay = now.getDayOfMonth();
        int Hour = now.getHour();
        int Minute = now.getMinute();
        int Second = now.getSecond();
        int feeNumber = (DateDay * 24 * 60 * 60 + Hour * 60 * 60 + Minute * 60 + Second) / 20000;
        String feeMeter = String.valueOf(feeNumber) + "\u33A5";
        String fee = String.valueOf(feeNumber * 300) + "원";
        list.add(new Fee("1", "128" + "\u33A5", "69120원", "납부완료"));
        list.add(new Fee("2", "111" + "\u33A5", "59940원", "납부완료"));
        list.add(new Fee("3", "78" + "\u33A5", "42120원", "납부완료"));

        tableView.setItems(list);

        howManyUseLabel.setText(feeMeter);
        howManyFeeLabel.setText(fee);

        chartButton.setOnMouseClicked((event) -> {
            chartButton.setImage(new Image(getClass().getResource("tariffImg/chart_clicked.png").toString()));
            handlerChartButton(event);
        });
    }

    private void handlerChartButton(MouseEvent event) {
        try {
            
            rootPane.getChildren().clear();
            Parent gasScene = FXMLLoader.load(getClass().getResource("gasChart.fxml"));
            rootPane.getChildren().add(gasScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

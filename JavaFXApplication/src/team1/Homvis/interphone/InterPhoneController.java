package team1.Homvis.interphone;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import team1.Homvis.MainController;
import team1.Homvis.interphone.MiniInterPhoneController;
import static team1.Homvis.interphone.MiniInterPhoneController.now;

public class InterPhoneController implements Initializable {

	@FXML
	private ImageView phoneBtn;
	@FXML
	private ImageView openBtn;
	@FXML
	private ImageView closeBtn;
	@FXML
	private AnchorPane interphoneRoot;
	@FXML
	private ImageView locationBtn;
	@FXML
	private ImageView location;
	
	private boolean cur;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if(!MiniInterPhoneController.now){
			location.setImage(new Image(getClass().getResource("interphoneImg/interphone_indoor.png").toString()));
			cur = now;
		}
		else {
			location.setImage(new Image(getClass().getResource("interphoneImg/interphone_outdoor.png").toString()));
			cur = now;
		}
		locationBtn.setOnMouseClicked(e->changeLocation());
		phoneBtn.setOnMousePressed(e->phoneBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_phonecall_clicked.png").toString())));
		phoneBtn.setOnMouseClicked(e->callNopen(e, "call"));
		openBtn.setOnMousePressed(e->openBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_open_clicked.png").toString())));
		openBtn.setOnMouseClicked(e->callNopen(e, "open"));
		closeBtn.setOnMousePressed(e->closeBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_exit_clicked.png").toString())));
		closeBtn.setOnMouseClicked(e->exit());
	}	
	private void callNopen(MouseEvent e, String status) {
		
			try {
				//팝업을 설정
				Popup popup = new Popup();
				HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("interPhonePopup.fxml"));
				Label lblMessage = (Label)hbox.lookup("#lbsMessage");
				// 들어오는 값에 따라 팝업의 내용 결정
				if(status.equals("call")){
					lblMessage.setText("통화가 연결되었습니다.");
					phoneBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_phonecall_default.png").toString()));
				}else if(status.equals("open")){
					lblMessage.setText("문이 열렸습니다.");
					openBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_open_default.png").toString()));
				}
				popup.getContent().add(hbox);
				popup.setAutoHide(true);
				popup.show(((ImageView)e.getSource()).getScene().getWindow());
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}
	private void exit() {
		now = cur;
		MainController.menuicon[3].setImage(new Image(getClass().getResource("interphoneImg/main_interphone_default.png").toString()));
		MainController.stackPane.getChildren().remove(interphoneRoot);
		closeBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_exit_default.png").toString()));
		MainController.menuicon[3].setDisable(false);
    }

	private void changeLocation() {
		if(!cur)location.setImage(new Image(getClass().getResource("interphoneImg/interphone_indoor.png").toString()));
		else location.setImage(new Image(getClass().getResource("interphoneImg/interphone_outdoor.png").toString()));
		
		cur = !cur;
	}
}

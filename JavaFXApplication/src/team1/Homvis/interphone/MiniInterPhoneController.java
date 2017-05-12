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


public class MiniInterPhoneController implements Initializable {

	@FXML
	private ImageView phoneBtn;
	@FXML
	private ImageView openBtn;
	@FXML
	private ImageView closeBtn;
	@FXML
	private ImageView locationBtn;
	@FXML
	private AnchorPane miniInterphoneRoot;
	@FXML
	private ImageView maximize;
	@FXML
	private ImageView location;
	
	public static boolean now;
	private boolean cur;
	


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if(!now)location.setImage(new Image(getClass().getResource("interphoneImg/interphone_indoor.png").toString()));
		else location.setImage(new Image(getClass().getResource("interphoneImg/interphone_outdoor.png").toString()));
		locationBtn.setOnMouseClicked(e->changeLocation());
		phoneBtn.setOnMousePressed(e->phoneBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_phonecall_clicked.png").toString())));
		phoneBtn.setOnMouseClicked(e->callNopen(e, "call"));
		openBtn.setOnMousePressed(e->openBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_open_clicked.png").toString())));
		openBtn.setOnMouseClicked(e->callNopen(e, "open"));
		closeBtn.setOnMousePressed(e->closeBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_exit_clicked.png").toString())));
		closeBtn.setOnMouseClicked(e->exit());
		maximize.setOnMousePressed(e->maximize.setImage(new Image(getClass().getResource("interphoneImg/interphone_expension_clicked.png").toString())));
		maximize.setOnMouseClicked(e->maximizeScreen());
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
		MainController.menuicon[3].setImage(new Image(getClass().getResource("interphoneImg/main_interphone_default.png").toString()));
		MainController.stackPane.getChildren().remove(miniInterphoneRoot);
		closeBtn.setImage(new Image(getClass().getResource("interphoneImg/interphone_exit_default.png").toString()));
    }

	private void changeLocation() {
		if(cur)location.setImage(new Image(getClass().getResource("interphoneImg/interphone_indoor.png").toString()));
		else location.setImage(new Image(getClass().getResource("interphoneImg/interphone_outdoor.png").toString()));
		
		cur = !cur;
	}

	private void maximizeScreen() {
		try {	
			now = cur;
			if(MainController.veiw[3]==null) MainController.veiw[3] = FXMLLoader.load(getClass().getResource(MainController.menuList.get(3)+".fxml"));
			MainController.stackPane.getChildren().add(MainController.veiw[3]);
			maximize.setImage(new Image(getClass().getResource("interphoneImg/interphone_expension_default.png").toString()));
			MainController.stackPane.getChildren().remove(miniInterphoneRoot);
		} catch (IOException ex) {
			
		}
    }
}

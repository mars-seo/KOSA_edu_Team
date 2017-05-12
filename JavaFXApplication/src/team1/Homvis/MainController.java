package team1.Homvis;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MainController implements Initializable {

	@FXML
	private ImageView background;
	@FXML
	private HBox menu;
	@FXML
	private ImageView menuIcon1;
	@FXML
	private ImageView menuIcon2;
	@FXML
	private ImageView menuIcon3;
	@FXML
	private ImageView menuIcon4;
	@FXML
	private ImageView menuIcon5;
	@FXML
	private ImageView menuIcon6;
	@FXML
	private ImageView menuIcon7;
	@FXML
	private ImageView menuIcon8;
	@FXML
	private Label clock;
	@FXML
	private AnchorPane mainPane;

	public static ImageView menuicon[] = new ImageView[8];

	public static String password;
	public static AnchorPane stackPane;
	public static boolean menu1PasswordChk;
	public static boolean menu2PasswordChk;
	public static boolean menu3PasswordChk;
	public static boolean menu4PasswordChk;
	public static boolean menu5PasswordChk;
	public static boolean menu6PasswordChk;
	public static boolean menu7PasswordChk;
	public static boolean menu8PasswordChk;

	public static List<String> menuList = new ArrayList<>();
	public static Parent veiw[] = new Parent[7];

	public static List<Parent> miniParent = new ArrayList<>();
	public static Parent miniVeiw[] = new Parent[7];

	public static boolean miniWindow;
	public static Parent preIndex1;
	public static Parent preIndex2;
	public static int preindex1 = -1;
	public static int preindex2 = -1;
	private Parent secretview;
	public static int secretCount;
	private int count = -1;
	private Timeline timeline;

	public MainController() {

		this.menuList.add("home");
		this.menuList.add("boiler");
		this.menuList.add("elecNgas");
		this.menuList.add("interphone");
		this.menuList.add("internet");
		this.menuList.add("player");
		this.menuList.add("tariff");
		this.menuList.add("secret");

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//나중에 디폴트로 만들기위해
		menuicon[0] = menuIcon1;
		menuicon[1] = menuIcon2;
		menuicon[2] = menuIcon3;
		menuicon[3] = menuIcon4;
		menuicon[4] = menuIcon5;
		menuicon[5] = menuIcon6;
		menuicon[6] = menuIcon7;
		menuicon[7] = menuIcon8;

		stackPane = mainPane;

		//clock start
		Thread thread = new Thread() {
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				while (true) {
					String strTime = sdf.format(new Date());
					Platform.runLater(() -> {
						clock.setText(strTime);
						System.gc();
					});
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
				}

			}
		};
		thread.setDaemon(true);
		thread.start();
		////////////////////////////clock end
		System.gc();
		//아이콘 눌렀을때
		menuIcon1.setOnMousePressed(event -> menuPressed(menuIcon1, 0));
		menuIcon1.setOnMouseClicked(event -> menuClicked(menuIcon1, 0, menu1PasswordChk));
		menuIcon2.setOnMousePressed(event -> menuPressed(menuIcon2, 1));
		menuIcon2.setOnMouseClicked(event -> menuClicked(menuIcon2, 1, menu2PasswordChk));
		menuIcon3.setOnMousePressed(event -> menuPressed(menuIcon3, 2));
		menuIcon3.setOnMouseClicked(event -> menuClicked(menuIcon3, 2, menu3PasswordChk));
		menuIcon4.setOnMousePressed(event -> menuPressed(menuIcon4, 3));
		menuIcon4.setOnMouseClicked(event -> menuClicked(menuIcon4, 3, menu4PasswordChk));
		menuIcon5.setOnMousePressed(event -> menuPressed(menuIcon5, 4));
		menuIcon5.setOnMouseClicked(event -> menuClicked(menuIcon5, 4, menu5PasswordChk));
		menuIcon6.setOnMousePressed(event -> menuPressed(menuIcon6, 5));
		menuIcon6.setOnMouseClicked(event -> menuClicked(menuIcon6, 5, menu6PasswordChk));
		menuIcon7.setOnMousePressed(event -> menuPressed(menuIcon7, 6));
		menuIcon7.setOnMouseClicked(event -> menuClicked(menuIcon7, 6, menu7PasswordChk));
		//menuIcon8.setOnMousePressed(event -> secretPressed());
		menuIcon8.setOnMousePressed(event -> secretClicked(true)); //암호설정 서브메뉴이동
		System.gc();
		//메뉴시작위치
		menu.setTranslateX(0);
		menu.setTranslateY(200);
////////////////
		System.gc();
		background.setOnMouseClicked(event -> {
			count = count * (-1);
			if (count == 1) {
				menuOpen();
			} else {
				menuClose();
			}
		});

		//      menu.setOnSwipeRight(new EventHandler<SwipeEvent>() {   //터치패드사용
		//         @Override
		//        public void handle(SwipeEvent event) {
		//            System.out.println("swipeRight");
		//            event.consume();
		//        }
		//   });
		//드래그할때 메뉴 옮기는거 부분, 시간있으면 진행
		/*     menu.setOnMousePressed((event) -> {
            xValue = event.getSceneX();
        });

        menu.setOnMouseDragged((event) -> {
            System.out.println(menu.getTranslateX());

            if (menu.getTranslateX() < -1000) {
                menu.setTranslateX(-1000);
                System.out.println("if1");
            } else if (menu.getTranslateX() > 0) {
                menu.setTranslateX(0);
                System.out.println("if2");
            } else {
                System.out.println("if3");
                menu.setTranslateX(event.getSceneX() - xValue);
            }

        });*/
	}

	private void menuOpen() {
		//sstackPane.getChildren().add(menu);
		if (timeline != null) {
			timeline.stop();
		}
		KeyValue keyValue = new KeyValue(menu.translateYProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(400), keyValue);
		timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		System.gc();
	}

	private void menuClose() {
		if (timeline != null) {
			timeline.stop();
		}
		KeyValue keyValue = new KeyValue(menu.translateYProperty(), 200);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(400), keyValue);
		timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		System.gc();
	}

	private void menuPressed(ImageView menuIcon, int index) {
		menuIcon.setImage(new Image(getClass().getResource("images/main_" + menuList.get(index) + "_pressed.png").toString()));
		System.gc();
	}

	private void menuClicked(ImageView menuIcon, int index, boolean chk) {
		if (timeline != null) {
			timeline.stop();
		}
		menuIcon.setImage(new Image(getClass().getResource("images/main_" + menuList.get(index) + "_clicked.png").toString()));
		menuIcon.setDisable(true);
		if (index == 0) {
			for (int i = 0; i < menuList.size(); i++) {
				menuicon[i].setImage(new Image(getClass().getResource("images/main_" + menuList.get(i) + "_default.png").toString()));
				menuicon[i].setDisable(false);
			}
			menuicon[7].setImage(new Image(getClass().getResource("images/main_" + menuList.get(7) + "_default.png").toString()));
			menuicon[7].setDisable(false);
			mainPane.getChildren().removeAll(miniParent);
			mainPane.getChildren().remove(secretview);
			preIndex1 = null;
			preIndex2 = null;
			System.gc();
		} else {
			try {
				if (!chk) {
					if (miniVeiw[index] == null) {
						miniVeiw[index] = FXMLLoader.load(getClass().getResource(menuList.get(index) + "/Mini" + menuList.get(index) + ".fxml"));
					}
					mainPane.getChildren().add(miniVeiw[index]);
					if (!miniWindow) {

						if (preIndex1 != null) {
							mainPane.getChildren().remove(preIndex1);
							menuicon[preindex1].setImage(new Image(getClass().getResource("images/main_" + menuList.get(preindex1) + "_default.png").toString()));
							menuicon[preindex1].setDisable(false);
						}
						miniVeiw[index].setTranslateX(0);
						miniVeiw[index].setTranslateY(0);
						/*miniView.setOpacity(0);
						KeyValue keyValue = new KeyValue(miniView.opacityProperty(), 1);
						KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
						timeline = new Timeline();
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
						 */
						preIndex1 = miniVeiw[index];
						preindex1 = index;
					} else {
						if (preIndex2 != null) {
							mainPane.getChildren().remove(preIndex2);
							menuicon[preindex2].setImage(new Image(getClass().getResource("images/main_" + menuList.get(preindex2) + "_default.png").toString()));
							menuicon[preindex2].setDisable(false);
						}
						miniVeiw[index].setTranslateX(400);
						miniVeiw[index].setTranslateY(0);
						/*miniView.setOpacity(0);
						KeyValue keyValue = new KeyValue(miniView.opacityProperty(), 1);
						KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
						timeline = new Timeline();
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
						 */
						preIndex2 = miniVeiw[index];
						preindex2 = index;
					}
					miniWindow = !miniWindow;
					miniParent.add(miniVeiw[index]);
					System.gc();

				} else {
					// passwordChk(index + 1);
					secretCount = index + 1;
					secretClicked(chk);
					System.gc();
				}
			} catch (IOException ex) {
				Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}
/*
	private void secretPressed() {
		menuIcon8.setImage(new Image(getClass().getResource("images/main_secret_pressed.png").toString()));
		System.gc();
	}
*/
	private void secretClicked(boolean chk) {

		if (timeline != null) {
			timeline.stop();
		}
		menuIcon8.setImage(new Image(getClass().getResource("images/main_secret_clicked.png").toString()));
		menuIcon8.setDisable(true);
		if (chk) {
			try {
				secretview = FXMLLoader.load(getClass().getResource("newpassword.fxml"));

				mainPane.getChildren().add(secretview);
				secretview.setTranslateY(0);
				if (!miniWindow) {
					if (preIndex1 != null) {
						mainPane.getChildren().remove(preIndex1);
						menuicon[preindex1].setImage(new Image(getClass().getResource("images/main_" + menuList.get(preindex1) + "_default.png").toString()));
						menuicon[preindex1].setDisable(false);
					}
					secretview.setTranslateX(0);
					secretview.setTranslateY(0);
					/*
					secretview.setOpacity(0);
					KeyValue keyValue = new KeyValue(secretview.opacityProperty(), 1);
					KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
					timeline = new Timeline();
					timeline.getKeyFrames().add(keyFrame);
					timeline.play();
					 */
					if (secretCount > 1) {
						VBox chkboxview = (VBox) secretview.lookup("#chkboxview");
						Label txt1 = (Label) secretview.lookup("#txt1");
						Label txt2 = (Label) secretview.lookup("#txt2");
						PasswordField password2 = (PasswordField) secretview.lookup("#password2");

						txt1.setText("비밀번호");
						txt2.setText("");
						chkboxview.setOpacity(0);
						password2.setOpacity(0);
					}
					preIndex1 = secretview;
					preindex1 = 7;
				} else {
					if (preIndex2 != null) {
						mainPane.getChildren().remove(preIndex1);
						menuicon[preindex2].setImage(new Image(getClass().getResource("images/main_" + menuList.get(preindex2) + "_default.png").toString()));
						menuicon[preindex2].setDisable(false);
					}
					secretview.setTranslateX(400);
					secretview.setTranslateY(0);
					/*
					secretview.setOpacity(0);
					KeyValue keyValue = new KeyValue(secretview.opacityProperty(), 1);
					KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
					timeline = new Timeline();
					timeline.getKeyFrames().add(keyFrame);
					timeline.play();
					 */
					if (secretCount > 1) {
						VBox chkboxview = (VBox) secretview.lookup("#chkboxview");
						Label txt1 = (Label) secretview.lookup("#txt1");
						Label txt2 = (Label) secretview.lookup("#txt2");
						PasswordField password2 = (PasswordField) secretview.lookup("#password2");

						txt1.setText("비밀번호");
						txt2.setText("");
						chkboxview.setOpacity(0);
						password2.setOpacity(0);
					}
					preIndex2 = secretview;
					preindex2 = 7;
				}
				miniWindow = !miniWindow;
				System.gc();
				Label txt1 = (Label) secretview.lookup("#txt1");
				Label txt2 = (Label) secretview.lookup("#txt2");

				if (secretCount == 1) {
					txt1.setText("기존 비밀번호");
					txt2.setText("신규 비밀번호");
					System.gc();
				}
			} catch (IOException ex) {

			}
		}
	}

}
/*
    private void passwordChk(int value) { //각각의 menuicon들의 번호를 넘겨받음, passwordcontroll에서 암호가 맞을시에 창띄울때 사용
        Parent chkView;
        secretCount = value;
        try {
            chkView = FXMLLoader.load(getClass().getResource("../secret/newpassword.fxml"));
            stackPane.getChildren().add(chkView);
            chkView.setTranslateX(0);
            chkView.setTranslateY(-200);
            chkView.setOpacity(0);
            KeyValue keyValue = new KeyValue(chkView.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

            VBox chkboxview = (VBox) chkView.lookup("#chkboxview");
            Label txt1 = (Label) chkView.lookup("#txt1");
            Label txt2 = (Label) chkView.lookup("#txt2");
            PasswordField password2 = (PasswordField) chkView.lookup("#password2");

            txt1.setText("비밀번호");
            txt2.setText("");
            chkboxview.setOpacity(0);
            password2.setOpacity(0);
          
             
        } catch (IOException ex) {

        }
    }
 */
//    private void homePressed() {
//        menuIcon1.setImage(new Image(getClass().getResource("images/main_home_pressed.png").toString()));
//
//    }
//
//    private void homeClicked() {
//        menuIcon1.setImage(new Image(getClass().getResource("images/main_home_clicked.png").toString()));
//
//    }
//
//    private void boilerPressed() {
//        menuIcon2.setImage(new Image(getClass().getResource("images/main_boiler_pressed.png").toString()));
//    }
//
//    private void boilerClicked() {
//        menuIcon2.setImage(new Image(getClass().getResource("images/main_boiler_clicked.png").toString()));
//        if (menu2PasswordChk == false) {
//			
//			Parent boilerview = parent.get(0);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//            
//        } else {
//            passwordChk(2);
//        }
//
//    }
//
//    private void elecNgasPressed() {
//        menuIcon3.setImage(new Image(getClass().getResource("images/main_elecNgas_pressed.png").toString()));
//
//    }
//
//    private void elecNgasClicked() {
//        menuIcon3.setImage(new Image(getClass().getResource("images/main_elecNgas_clicked.png").toString()));
//        if (menu3PasswordChk == false) {
//                    
//			Parent boilerview = parent.get(1);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//			
//        } else {
//            passwordChk(3);
//        }
//
//    }
//
//    private void interphonePressed() {
//        menuIcon4.setImage(new Image(getClass().getResource("images/main_interphone_pressed.png").toString()));
//    }
//
//    private void interphoneClicked() {
//        menuIcon4.setImage(new Image(getClass().getResource("images/main_interphone_clicked.png").toString()));
//        if (menu4PasswordChk == false) {
//			Parent boilerview = parent.get(2);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(4);
//        }
//    }
//
//    private void internetPressed() {
//
//    }
//
//    private void internetClicked() {
//        if (menu5PasswordChk == false) {
//			Parent boilerview = parent.get(3);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(5);
//        }
//
//    }
//
//    private void playerPressed() {
//        menuIcon6.setImage(new Image(getClass().getResource("images/main_player_pressed.png").toString()));
//    }
//
//    private void playerClicked() {
//        menuIcon6.setImage(new Image(getClass().getResource("images/main_player_clicked.png").toString()));
//        if (menu6PasswordChk == false) {
//			Parent boilerview = parent.get(4);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(6);
//        }
//    }
//
//    private void tariffPressed() {
//        menuIcon7.setImage(new Image(getClass().getResource("images/main_tariff_pressed.png").toString()));
//    }
//
//    private void tariffClicked() {
//        menuIcon7.setImage(new Image(getClass().getResource("images/main_tariff_clicked.png").toString()));
//        if (menu7PasswordChk == false) {
//			Parent boilerview = parent.get(5);
//			stackPane.getChildren().add(boilerview); 
//			boilerview.setTranslateX(0);
//			boilerview.setOpacity(0);
//			KeyValue keyValue = new KeyValue(boilerview.opacityProperty(), 1);
//			KeyFrame keyFrame = new KeyFrame(Duration.millis(1500), keyValue);
//			Timeline timeline = new Timeline();
//			timeline.getKeyFrames().add(keyFrame);
//			timeline.play();
//        } else {
//            passwordChk(7);
//        }
//    }

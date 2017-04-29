package team1.kcm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Root1Controller implements Initializable {

	@FXML
	private StackPane stackPane;
	@FXML
	private ImageView background;
	@FXML
	private HBox menu;

	private static int count = -1;
	private static double xValue;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		menu.setTranslateX(0);
		menu.setTranslateY(200);

		background.setOnMouseClicked(event -> {
			count = count * (-1);
			if (count == 1) {
				menuOpen();
			} else {
				menuClose();
			}
		});

		menu.setOnSwipeRight(new EventHandler<SwipeEvent>() {
			@Override
			public void handle(SwipeEvent event) {
				System.out.println("swipeRight");
				event.consume();
			}
		});

		//  menu.setOnMouseReleased(new EventHandler<MouseEvent>() {
		//     @Override
		//      public void handle(MouseEvent event) {
		//          System.out.println("mousereleased");
		//          menu.setTranslateX(menu.getTranslateX() + event.getX());
		//          menu.setTranslateY(menu.getTranslateY() + event.getY());
		//          event.consume();
		//      }
		//   });
		//   menu.setOnMouseReleased((event) -> {
		//      System.out.println("mousereleased");
		// });
		menu.setOnMousePressed((event) -> {
			xValue = event.getSceneX();
			System.out.println(xValue);
		});
		
		menu.setOnMouseDragged((event) -> {
			//   System.out.println("mousereleased2");
			//double value=event.getX();
			//  System.out.println(value);
			//  double value1=event.getSceneX();
			//  System.out.println(value1);
			//  double value2=event.getScreenX();
			//   System.out.println(value2);
			//   double value3=menu.getTranslateX();
			//   double value4= menu.getLayoutX();
			//    System.out.println(value4);
			//	 double value4= menu.getLayoutX();
			//	 System.out.println(value4);

			//System.out.println(event.getSceneX());
			//System.out.println(xValue);
			//System.out.println(menu.getTranslateX());    !!!!!!!!!!!!
			if(menu.getTranslateX()>=-250&&menu.getTranslateX()<=0){
				System.out.println("ㅋㅋ");
			menu.setTranslateX(event.getSceneX()-xValue);
			}
			
			// menu.setTranslateY(event.getSceneY() + event.getY());
		});

		//      menu.setOnMouseDragOver((event) -> {
		//         System.out.println("mousereleased1");
		//    });
	}

	private void menuOpen() {
		System.out.println("open");
		//sstackPane.getChildren().add(menu);

		KeyValue keyValue = new KeyValue(menu.translateYProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

	private void menuClose() {
		System.out.println("close");
		KeyValue keyValue = new KeyValue(menu.translateYProperty(), 200);
		// KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),
		//         (event) -> {
		//           sstackPane.getChildren().remove(menu);
		//      },
		//        keyValue);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();

	}

}

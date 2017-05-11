package team1.Homvis.interphone;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Location {
	private ImageView chImg;

	public ImageView getChImg(String lb) {
		if(lb.equals("out")) chImg.setImage(new Image(getClass().getResource("interphoneImg/interphone_outdoor.png").toString()));
		else if(lb.equals("in")) chImg.setImage(new Image(getClass().getResource("interphoneImg/interphone_indoor.png").toString()));
		
		return chImg;
	}
}

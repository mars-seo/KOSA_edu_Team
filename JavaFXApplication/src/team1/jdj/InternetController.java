/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.jdj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author dongju
 */
public class InternetController implements Initializable {

    @FXML
    private WebView newsWebView;
    @FXML
    private ToggleButton newsButton;
    @FXML
    private ToggleGroup SelectGroup;
    @FXML
    private ToggleButton youtubeButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WebEngine engine = newsWebView.getEngine();

        newsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine.load("http://m.news.naver.com/");
            }
        });

        youtubeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine.load("https://m.youtube.com");
            }
        });

    }

}

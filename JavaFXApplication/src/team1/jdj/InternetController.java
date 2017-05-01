/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.jdj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
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
    @FXML
    private Button refresh;
    @FXML
    private Button backButton;
    @FXML
    private Button forwardButton;

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

        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine.reload();
            }

        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final WebHistory history = engine.getHistory();
                ObservableList<WebHistory.Entry> entryList = history.getEntries();
                int currentIndex = history.getCurrentIndex();
                Platform.runLater(() -> {
                    history.go(entryList.size() > 1 && currentIndex > 0 ? -1 : 0);
                });
            }
        });

        forwardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final WebHistory history = engine.getHistory();
                ObservableList<WebHistory.Entry> entryList = history.getEntries();
                int currentIndex = history.getCurrentIndex();

                Platform.runLater(() -> {
                    history.go(entryList.size() > 1 && currentIndex < entryList.size() - 1 ? 1 : 0);
                });
            }
        });

    }

}

package team1.Homvis.internet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import team1.Homvis.main.MainController;

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
    ObservableList<Bookmark> bookmarks = FXCollections.observableArrayList();
    @FXML
    private TableView<Bookmark> table;
    @FXML
    private TableColumn<Bookmark, String> siteColumn;
    @FXML
    private TableColumn<Bookmark, String> urlColumn;
    @FXML
    private StackPane changeableStackPane;

    WebEngine engine;
    @FXML
    private ToggleButton favoriteToggle;
    @FXML
    private Button favoritAdd;
    @FXML
    private Button favoriteDelete;
	@FXML
	private ImageView exit;
	@FXML
	private StackPane internetRoot;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
		exit.setOnMouseClicked(e->exit());
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

        favoriteToggle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (favoriteToggle.isSelected() == false) {
                    changeableStackPane.setVisible(false);
                } else if (favoriteToggle.isSelected() == true) {
                    changeableStackPane.setVisible(true);
                }
            }
        });

        bookmarks.addAll(
                new Bookmark("Google", "https://www.google.co.kr/"),
                new Bookmark("Facebook", "https://www.facebook.com/"),
                new Bookmark("Twitter", "https://twitter.com/")
        );
        siteColumn.setCellValueFactory(new PropertyValueFactory("site"));
        urlColumn.setCellValueFactory(new PropertyValueFactory("url"));

        table.setItems(bookmarks);
        TableView.TableViewSelectionModel<Bookmark> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Bookmark>() {
            @Override
            public void changed(ObservableValue<? extends Bookmark> value, Bookmark old, Bookmark next) {
                if (next != null) {
                    String url = next.getUrl();
                    engine.load(url);
                }
            }
        });

        favoritAdd.setOnAction((event) -> {
            String aurl = engine.getLocation();
            try {
                URL aURL = new URL(aurl);
                bookmarks.addAll(new Bookmark(getBaseDomain(aurl).replaceFirst(".com", " "), engine.getLocation()));
                System.out.println(getBaseDomain(aurl));
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

        });

        favoriteDelete.setOnAction((event) -> {
            bookmarks.remove(selectionModel.getSelectedIndex());

        });

    }

    public static String getHost(String url) {
        if (url == null || url.length() == 0) {
            return "";
        }

        int doubleslash = url.indexOf("//"); // http://중 //의 위치를 사용해 2를더하면 주소시작위치가된다.
        if (doubleslash == -1) {
            doubleslash = 0;
        } else {
            doubleslash += 2;
        }

        int end = url.indexOf('/', doubleslash);
        end = end >= 0 ? end : url.length();

        int port = url.indexOf(':', doubleslash);
        end = (port > 0 && port < end) ? port : end;

        return url.substring(doubleslash, end);
    }

    public static String getBaseDomain(String url) {
        String host = getHost(url);

        int startIndex = 0;
        int nextIndex = host.indexOf('.');
        int lastIndex = host.lastIndexOf('.');
        while (nextIndex < lastIndex) {
            startIndex = nextIndex + 1;
            nextIndex = host.indexOf('.', startIndex);
        }
        if (startIndex > 0) {
            return host.substring(startIndex);
        } else {
            return host;
        }
    }
	private void exit() {
		MainController.menuicon5.setImage(new Image(getClass().getResource("../main/images/main_internet_default.png").toString()));
        MainController.stackPane.getChildren().remove(internetRoot);
    }
}

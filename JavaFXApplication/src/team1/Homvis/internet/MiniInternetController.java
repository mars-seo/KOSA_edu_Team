/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.Homvis.internet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import team1.Homvis.MainController;

/**
 * FXML Controller class
 *
 * @author dongju
 */
public class MiniInternetController implements Initializable {

	@FXML
	private WebView newsWebView;
	@FXML
	private ImageView newsButton;
	@FXML
	private ImageView youtubeButton;
	@FXML
	private ImageView refresh;
	@FXML
	private ImageView backButton;
	@FXML
	private ImageView forwardButton;
	static ObservableList<Bookmark> bookmarks = FXCollections.observableArrayList();
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
	private ImageView favoriteToggle;
	@FXML
	private ImageView favoriteAdd;
	@FXML
	private ImageView favoriteDelete;
	@FXML
	private ImageView exit;
	@FXML
	private StackPane internetRoot;
	private static int count = -1;
	@FXML
	private ImageView maximize;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		maximize.setOnMouseClicked(e -> maximizeScreen());
		exit.setOnMouseClicked(e -> exit());
		WebEngine engine = newsWebView.getEngine();
//        newsWebView.setFontScale(5);
		newsWebView.resize(400, 240);
		newsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				engine.load("http://m.news.naver.com");
				newsButton.setImage(new Image(getClass().getResource("internetImg/internet_naver_clicked.png").toString()));
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
				}
				Platform.runLater(() -> {
					newsButton.setImage(new Image(getClass().getResource("internetImg/internet_naver_default.png").toString()));
				});
			}
		});

		youtubeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				engine.load("https://m.youtube.com");
				youtubeButton.setImage(new Image(getClass().getResource("internetImg/internet_youtube_clicked.png").toString()));
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
				}
				Platform.runLater(() -> {
					youtubeButton.setImage(new Image(getClass().getResource("internetImg/internet_youtube_default.png").toString()));
				});
			}
		});

		refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				engine.reload();
				refresh.setImage(new Image(getClass().getResource("internetImg/internet_refresh_clicked.png").toString()));
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
				}
				Platform.runLater(() -> {
					refresh.setImage(new Image(getClass().getResource("internetImg/internet_refresh_default.png").toString()));
				});
			}

		});

		backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				backButton.setImage(new Image(getClass().getResource("internetImg/internet_back_clicked.png").toString()));
				final WebHistory history = engine.getHistory();
				ObservableList<WebHistory.Entry> entryList = history.getEntries();
				int currentIndex = history.getCurrentIndex();
				Platform.runLater(() -> {
					history.go(entryList.size() > 1 && currentIndex > 0 ? -1 : 0);
				});
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
				}
				Platform.runLater(() -> {
					backButton.setImage(new Image(getClass().getResource("internetImg/internet_back_default.png").toString()));
				});
			}
		});

		forwardButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				forwardButton.setImage(new Image(getClass().getResource("internetImg/internet_forward_clicked.png").toString()));
				final WebHistory history = engine.getHistory();
				ObservableList<WebHistory.Entry> entryList = history.getEntries();
				int currentIndex = history.getCurrentIndex();

				Platform.runLater(() -> {
					history.go(entryList.size() > 1 && currentIndex < entryList.size() - 1 ? 1 : 0);
				});
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
				}
				Platform.runLater(() -> {
					forwardButton.setImage(new Image(getClass().getResource("internetImg/internet_forward_default.png").toString()));
				});
			}
		});

		favoriteToggle.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//                if (changeableStackPane.isVisible() == false) {
//                    changeableStackPane.setVisible(false);
//                } else if (favoriteToggle.isVisible() == true) {
//                    changeableStackPane.setVisible(true);
//                }
				count = count * (-1);
				if (count == 1) {
					changeableStackPane.setVisible(true);
					favoriteToggle.setImage(new Image(getClass().getResource("internetImg/internet_favorite_clicked.png").toString()));
				} else {
					changeableStackPane.setVisible(false);
					favoriteToggle.setImage(new Image(getClass().getResource("internetImg/internet_favorite_default.png").toString()));
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

		favoriteAdd.setOnMouseClicked((event) -> {
			String aurl = engine.getLocation(); //Webengine의 getLoaction()메소드를 통해 url주소를 구한다.
			//ex) m.naver.com/12390940901/sfs
			favoriteAdd.setImage(new Image(getClass().getResource("internetImg/internet_+_clicked.png").toString()));
			try {
				URL aURL = new URL(aurl);   //String aurl을 URL타입으로 바꾼다.
				String host = aURL.getHost();
				if (host.endsWith("com")) { //(aURL)은 naver.com을 리턴한다. 따라서 replaceFirst메소드를 통해 .com부분을 지워 'naver'라는 이름을 얻어낸다.
					bookmarks.addAll(new Bookmark(getBaseDomain(aURL).replaceFirst(".com", " "), engine.getLocation()));
				}
				if (host.endsWith("co.kr")) {//(aURL)의 .co.kr부분을 지워 'google'이라는 이름을 얻어낸다.
					bookmarks.addAll(new Bookmark(getBaseDomain(aURL).replaceFirst(".co.kr", " "), engine.getLocation()));
				}
				System.out.println(aURL.getHost());
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
			}
			Platform.runLater(() -> {
				favoriteAdd.setImage(new Image(getClass().getResource("internetImg/internet_+_default.png").toString()));
			});
		});

		favoriteDelete.setOnMouseClicked((event) -> {
			favoriteDelete.setImage(new Image(getClass().getResource("internetImg/internet_-_clicked.png").toString()));
			bookmarks.remove(selectionModel.getSelectedIndex()); //북마크리스트에서 선택된 인덱스번째의 항목을 지운다.
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
			}
			Platform.runLater(() -> {
				favoriteDelete.setImage(new Image(getClass().getResource("internetImg/internet_-_default.png").toString()));
			});
		});

	}

	public static String getBaseDomain(URL url) {
		String host = url.getHost(); //getHost()메소드를 통해 host를 얻는다. ex)m.naver.com

		int startIndex = 0;    //startIndex는 0
		int nextIndex = host.indexOf('.'); //nextIndex는 '.naver'의 '.'
		int lastIndex = host.lastIndexOf('.'); //lastIndex는 .com의 '.'

		if (nextIndex == lastIndex) {   //twiter.com과 같이 첫단어부터 도메인인 경우는 바로 리턴하고 종료
			return host;
		} else if (host.endsWith("co.kr")) {
			startIndex = nextIndex + 1;         //startIndex는 .naver.의 첫번째 글자가 되고, ex)n
			nextIndex = host.indexOf('.', startIndex); //nextIndex는 m.naver.com 중 naver.com에서 .이 처음으로 나타나는 위치 .com의 .으로 바뀐다.
			return host.substring(startIndex);
		}

		while (nextIndex < lastIndex) {     //nextIndex가 lastIndex와 같아질때까지(즉 .naver.에서 첫번째'.'이 마지막 '.'의 위치가 될때까지 반복)
			startIndex = nextIndex + 1;         //startIndex는 .naver.의 첫번째 글자가 되고, ex)n
			nextIndex = host.indexOf('.', startIndex); //nextIndex는 m.naver.com 중 naver.com에서 .이 처음으로 나타나는 위치 .com의 .으로 바뀐다.
		}   //nextIndex와 lastIndex가 같아졌으므로 종료, startIndex는 n이 된다.
		if (startIndex > 0) {
			return host.substring(startIndex); //m.naver.com중 n부터 시작하는 naver.com을 리턴한다.
		} else {
			return host;
		}
	}

	private void exit() {
		MainController.menuicon[4].setImage(new Image(getClass().getResource("internetImg/main_internet_default.png").toString()));
		MainController.stackPane.getChildren().remove(internetRoot);
		MainController.menuicon[4].setDisable(false);
	}

	private void maximizeScreen() {
		try {
			if (MainController.veiw[4] == null) {
				MainController.veiw[4] = FXMLLoader.load(getClass().getResource(MainController.menuList.get(4) + ".fxml"));
			}
			MainController.stackPane.getChildren().add(MainController.veiw[4]);
			MainController.stackPane.getChildren().remove(internetRoot);
		} catch (IOException ex) {

		}
	}

	public static ObservableList<Bookmark> getBookmarks() {
		return bookmarks;
	}

}

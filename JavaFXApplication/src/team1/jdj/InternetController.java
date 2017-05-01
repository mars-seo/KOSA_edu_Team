/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.jdj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WebEngine engine= newsWebView.getEngine();
        
    }    
    
}
